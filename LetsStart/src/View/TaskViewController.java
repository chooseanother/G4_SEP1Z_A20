package View;

import Model.*;
import View.ListView.TaskViewModel;
import View.ListView.TeamMemberListViewModel;
import View.ListView.TeamMemberViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;
import java.util.Optional;

public class TaskViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private ManagementSystemModel managementSystemModel;
  private ViewState state;
  private TeamMemberListViewModel teamMemberListViewModel;
  @FXML private TableView<TeamMemberViewModel> taskTeamMemberListTable;
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
    this.state = state;
    teamMemberListViewModel = new TeamMemberListViewModel(managementSystemModel, this.state);
    nameCollum.setCellValueFactory(cellData -> cellData.getValue().namePropertyProperty());
    idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
    taskTeamMemberListTable.setItems(teamMemberListViewModel.getList());
    reset();
  }

  public void reset() {
    errorLabel.setText("");
    allowedTeamMembers.clear();
    if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers() > 0){
      for (int i = 0; i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++){
        allowedTeamMembers.add(managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).getName().toString());
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
      deadlineDate.setValue(null);
      statusChoice.setItems(FXCollections.observableArrayList(Status.NOT_STARTED));
      enterHoursText.setVisible(false);
    }
    else{
      Task display = managementSystemModel.getTask(state.getProjectId(),
          state.getRequirementId(), state.getTaskId());
      enterHoursText.setVisible(true);
      enterHoursText.setText("");
      enterHoursText.setPromptText("Enter hours");
      root.setUserData("Task");
      titleLabel.setText("Task");
      statusChoice.setItems(statuses);
      titleText.setText(display.getTitle());
      reqIdText.setText(display.getReqId()+"");
      taskIdText.setText(display.getId()+"");
      responsibleChoice.setValue(display.getResponsibleTeamMember().getName().toString());
      MyDate tmp = display.getDeadline();
      deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
      statusChoice.setValue(display.getStatus().toString());
      hoursText.setText(display.getHoursSpent()+"");
      estimateText.setText(display.getEstimatedTime()+"");
    }
    teamMemberListViewModel.update();
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void savePressed() {
    //check if estimated time is allowed
    // (estimated time for requirement minus total estimated time from all tasks
    // related to requirement should be above estimated time form a new task
    // else there will be an error/warning)
    try {
    LocalDate dl = deadlineDate.getValue();
    MyDate deadline = new MyDate(dl.getDayOfMonth(), dl.getMonthValue(), dl.getYear());
    int estimatedTime = Integer.parseInt(estimateText.getText().split(" ")[0]);
    TeamMember responsible = null;
    for (int i = 0;
         i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++) {
      if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).getName().toString()
          .equalsIgnoreCase(responsibleChoice.getValue())) {
        responsible = managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList()
            .getTeamMemberIndex(i);
      }
    }
    if (state.getTaskId()<0){
      Task save = new Task(titleText.getText(),estimatedTime,deadline,responsible,state.getRequirementId());
      managementSystemModel.addTask(state.getProjectId(),state.getRequirementId(),save);
      state.setTaskId(save.getId());
    }
    else{
      int addedHours = 0;
      if (enterHoursText.getText().matches("[0-9]+")){
        addedHours = Integer.parseInt(enterHoursText.getText());
      }
      managementSystemModel.editTask(state.getProjectId(), state.getRequirementId(), state.getTaskId(),
          titleText.getText(), responsible, statusChoice.getValue(),addedHours,estimatedTime);
    }
      managementSystemModel.saveToFile();
    reset();
    }
    catch (Exception e){
      errorLabel.setText("Error: " + e.getMessage());
    }
  }

  @FXML private void addPressed() {
    if (state.getTaskId()<0){
      errorLabel.setText("Save task before adding team members");
    }
    else {
      state.setMemberId(-1);
      viewHandler.openView("teamMember");
    }
  }

  @FXML private void removePressed() {
    try
    {
      TeamMemberViewModel selectedItem = taskTeamMemberListTable.getSelectionModel().getSelectedItem();
      boolean remove = removeConfirmation();
      if (remove)
      {
        managementSystemModel.removeTeamMember(state.getProjectId(),state.getRequirementId(),state.getTaskId(),selectedItem.getIdProperty());
        teamMemberListViewModel.remove(selectedItem.getIdProperty());
        taskTeamMemberListTable.getSelectionModel().clearSelection();
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
    int index = taskTeamMemberListTable.getSelectionModel().getSelectedIndex();
    TeamMemberViewModel selectedItem = taskTeamMemberListTable.getItems().get(index);
    if (index < 0 || index >= taskTeamMemberListTable.getItems().size())
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
