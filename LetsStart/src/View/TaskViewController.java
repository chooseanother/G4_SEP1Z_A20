package View;

import Model.ManagementSystemModel;
import Model.Priority;
import Model.Status;
import View.ListView.TaskViewModel;
import View.ListView.TeamMemberListViewModel;
import View.ListView.TeamMemberViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.util.Optional;

public class TaskViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private ManagementSystemModel managementSystemModel;
  private ViewState state;
  private TeamMemberListViewModel teamMemberListViewModel;
  @FXML private TableView<TeamMemberViewModel> teamMemberListTable;
  @FXML private TableColumn<TeamMemberViewModel, String> nameCollum;
  @FXML private TableColumn<TeamMemberViewModel, Number> idCollum;
  @FXML private Label titleLabel, errorLabel;
  @FXML private TextField titleText, reqIdText, taskIdText, enterHoursText,
      hoursText, estimateText;
  @FXML private DatePicker deadlineDate;
  @FXML private ChoiceBox<String> responsibleChoice, statusChoice;
  private final ObservableList<String> statuses = FXCollections.observableArrayList(
      Status.NOT_STARTED, Status.STARTED, Status.FINISHED);
  private ObservableList<String> allowedTeamMembers = FXCollections.observableArrayList();


  public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
    this.viewHandler = viewHandler;
    this.managementSystemModel = model;
    this.root = root;
    teamMemberListViewModel = new TeamMemberListViewModel(managementSystemModel, this.state);
    nameCollum.setCellValueFactory(cellData -> cellData.getValue().namePropertyProperty());
    idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
    teamMemberListTable.setItems(teamMemberListViewModel.getList());
    reset();
  }

  public void reset() {
    allowedTeamMembers.clear();
    int amount = managementSystemModel.getTask(this.state.getProjectId(),
        state.getRequirementId(), state.getTaskId()).getAllTeamMembers().numberOfTeamMembers();
    if (amount > 0){
      for (int i = 0; i <amount; i++){
        allowedTeamMembers.add(managementSystemModel.getTask(this.state.getProjectId(),
            state.getRequirementId(), state.getTaskId()).getAllTeamMembers().getTeamMemberIndex(i).getName().toString());
      }
    }
    responsibleChoice.setItems(allowedTeamMembers);
    if (state.getTaskId()<0)
    {
      root.setUserData("New Task");
      titleLabel.setText("New Task");
      titleText.setText("");
      reqIdText.setText("");
      taskIdText.setText("");
      responsibleChoice.setValue(null);
      statusChoice.setItems(FXCollections.observableArrayList(Status.NOT_STARTED));
    }
    else{
      root.setUserData("Task");
      titleLabel.setText("Task");
      statusChoice.setItems(statuses);
    }
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void savePressed() {
    //check if estimated time is allowed
    // (estimated time for requirement minus total estimated time from all tasks
    // related to requirement should be above estimated time form a new task
    // else there will be an error/warning)
  }

  @FXML private void deletePressed() {

  }

  @FXML private void addPressed() {

  }

  @FXML private void removePressed() {
    try
    {
      TeamMemberViewModel selectedItem = teamMemberListTable.getSelectionModel().getSelectedItem();
      boolean remove = removeConfirmation();
      if (remove)
      {
        managementSystemModel.removeTeamMember(state.getProjectId(),state.getRequirementId(),state.getTaskId(),selectedItem.getIdProperty());
        teamMemberListViewModel.remove(selectedItem.getIdProperty());
        teamMemberListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void backPressed() {
    //confirmation
    if (exitConfirmation()){
      state.setTaskId(-1);
      viewHandler.openView("requirement");
    }
  }

  @FXML private void homePressed() {
    if (exitConfirmation()){
      state.reset();
      viewHandler.openView("home");
    }
  }

  private boolean removeConfirmation()
  {
    int index = teamMemberListTable.getSelectionModel().getSelectedIndex();
    TeamMemberViewModel selectedItem = teamMemberListTable.getItems().get(index);
    if (index < 0 || index >= teamMemberListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing Team Member " + selectedItem.getNameProperty());
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  private boolean exitConfirmation(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("You are about to exit.\nPress OK to lose unsaved changes");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }
}
