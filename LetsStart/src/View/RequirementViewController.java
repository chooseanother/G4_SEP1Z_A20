package View;

import View.ListView.TaskViewModel;
import View.ListView.TaskListViewModel;
import Model.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;
import java.util.Optional;

public class RequirementViewController {
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;
	@FXML private Label requirementLabel, errorLabel;
	@FXML private TextField idText, hoursSpentText, estimateText;
	@FXML private TextArea descriptionText;
	@FXML private ChoiceBox<String> responsibleChoice, priorityChoice, statusChoice;
	@FXML private DatePicker deadlineDate;
	@FXML private TableView<TaskViewModel> taskListTable;
	@FXML private TableColumn<TaskViewModel, String> titleCollum;
	@FXML private TableColumn<TaskViewModel, String> statusCollum;
	@FXML private TableColumn<TaskViewModel, Number> idCollum;
	private TaskListViewModel taskListViewModel;
	private final ObservableList<String> priorities = FXCollections.observableArrayList(
			Priority.PRIORITIES[0],Priority.PRIORITIES[1],
			Priority.PRIORITIES[2],Priority.PRIORITIES[3]);
	private final ObservableList<String> statuses = FXCollections.observableArrayList(
			Status.APPROVED,Status.ENDED, Status.REJECTED, Status.IN_PROGRESS);
	private ObservableList<String> allowedTeamMembers = FXCollections.observableArrayList();



	public RequirementViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state=state;
		errorLabel.setText("");
		priorityChoice.setItems(priorities);
		taskListViewModel = new TaskListViewModel(managementSystemModel, this.state);
		titleCollum.setCellValueFactory(cellData -> cellData.getValue().titlePropertyProperty());
		statusCollum.setCellValueFactory(cellData -> cellData.getValue().statusPropertyProperty());
		idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		taskListTable.setItems(taskListViewModel.getList());
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
		if(this.state.getRequirementId()<0){
			root.setUserData("New Requirement");
			requirementLabel.setText("New Requirement");
			idText.setText("");
			responsibleChoice.setValue("");
			descriptionText.setText("");
			deadlineDate.setValue(null);
			statusChoice.setValue(null);
			statusChoice.setItems(FXCollections.observableArrayList(Status.IN_PROGRESS));
			hoursSpentText.setText("");
			priorityChoice.setValue(null);
			estimateText.setText("");
		}
		else
		{
			root.setUserData("Requirement");
			requirementLabel.setText("Requirement");
			Requirement display=managementSystemModel.getRequirement(this.state.getProjectId(),this.state.getRequirementId());
			display.updateStatus();
			statusChoice.setItems(statuses);
			idText.setText(display.getId()+"");
			responsibleChoice.setValue(display.getResponsibleTeamMember().getName().toString());
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			statusChoice.setValue(display.getStatus().toString());
			hoursSpentText.setText(display.getTimeSpent()+" H");
			priorityChoice.setValue(display.getPriority().toString());
			estimateText.setText(display.getEstimatedTime()+" H");
			deadlineDate.setEditable(false);
		}
		taskListViewModel.update();
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void addButtonPressed() {
		if (state.getRequirementId()>0){
			errorLabel.setText("");
			viewHandler.openView("task");
		}
		else {
			errorLabel.setText("Save requirement before adding tasks");
		}
	}

	@FXML private void removeButtonPressed() {
		//confirmation
		errorLabel.setText("");
		try
		{
			TaskViewModel selectedItem = taskListTable.getSelectionModel().getSelectedItem();
			boolean remove = removeConfirmation();
			if (remove)
			{
				managementSystemModel.getRequirement(state.getProjectId(),state.getRequirementId()).getAllTasks().removeTask(selectedItem.getIdProperty());
				taskListViewModel.remove(selectedItem.getIdProperty());
				taskListTable.getSelectionModel().clearSelection();
			}
		}
		catch (Exception e)
		{
			errorLabel.setText("Item not found: " + e.getMessage());
		}
	}

	@FXML private void openButtonPressed() {
		errorLabel.setText("");
		try
		{
			state.setTaskId(
					taskListTable.getSelectionModel().getSelectedItem().getIdProperty());
			viewHandler.openView("task");
		}
		catch (Exception e)
		{
			errorLabel.setText("Item not found: " + e.getMessage());
		}
	}

	@FXML private void saveButtonPressed() {
		//check if deadline is valid
		//check if other stuff is valid
		try {
			LocalDate dl = deadlineDate.getValue();
			Priority priority = new Priority(priorityChoice.getSelectionModel().getSelectedIndex());
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
			if (state.getRequirementId() < 0) {
				Requirement tmp = new Requirement(descriptionText.getText(), deadline, priority,
						responsible, estimatedTime);
				managementSystemModel.addRequirement(state.getProjectId(),tmp);
				state.setRequirementId(tmp.getId());
			}
			else {
				managementSystemModel.editRequirement(state.getProjectId(), state.getRequirementId(),
						descriptionText.getText(), estimatedTime, statusChoice.getValue(),
						priority, responsible);
			}
			managementSystemModel.saveToFile();
			reset();
		}
		catch (Exception e){
			errorLabel.setText("Error: " + e.getMessage());
		}
	}

	@FXML private void backButtonPressed() {
		if (exitConfirmation()){
			state.setRequirementId(-1);
			viewHandler.openView("project");
		}
	}

	@FXML private void homeButtonPressed() {
		if (exitConfirmation()){
			state.reset();
			viewHandler.openView("home");
		}
	}

	private boolean removeConfirmation()
	{
		int index = taskListTable.getSelectionModel().getSelectedIndex();
		TaskViewModel selectedItem = taskListTable.getItems().get(index);
		if (index < 0 || index >= taskListTable.getItems().size())
		{
			return false;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(
				"Removing task " + selectedItem.getTitleProperty() + " "
						+ selectedItem.getIdProperty());
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
