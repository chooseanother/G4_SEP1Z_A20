package View;

import ListView.TaskViewModel;
import ListView.TaskListViewModel;
import Model.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

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
		statusChoice.setItems(statuses);

		taskListViewModel = new TaskListViewModel(managementSystemModel, this.state);
		titleCollum.setCellValueFactory(cellData -> cellData.getValue().titlePropertyProperty());
		statusCollum.setCellValueFactory(cellData -> cellData.getValue().statusPropertyProperty());
		idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		taskListTable.setItems(taskListViewModel.getList());
		errorLabel.setText("");
		if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers() > 0){
			for (int i = 0; i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++){
				allowedTeamMembers.add(managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).toString());
			}
		}

		if(this.state.getRequirementId()<0){
			requirementLabel.setText("New Requirement");
			root.setUserData("New Requirement");
		}
		else
		{
			Requirement display=managementSystemModel.getProject(this.state.getProjectId()).getRequirementList().getRequirementId(this.state.getRequirementId());
			requirementLabel.setText("Requirement");
			root.setUserData("Requirement");
			idText.setText(display.getId()+"");
			responsibleChoice.setValue(display.getResponsibleTeamMember().toString());
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			statusChoice.setValue(display.getStatus().toString());
			hoursSpentText.setText(display.getTimeSpent()+" H");
			priorityChoice.setValue(display.getPriority().toString());
			estimateText.setText(display.getEstimatedTime()+" H");
			taskListViewModel.update();

		}
		responsibleChoice.setItems(allowedTeamMembers);
	}

	public void reset() {
		errorLabel.setText("");
		if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers() > 0){
			for (int i = 0; i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++){
				allowedTeamMembers.add(managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).toString());
			}
		}
		if(this.state.getRequirementId()<0){
			root.setUserData("Requirement");
			requirementLabel.setText("New Requirement");
			idText.setText("");
			responsibleChoice.setValue("");
			descriptionText.setText("");
			deadlineDate.setValue(null);
			statusChoice.setValue("");
			hoursSpentText.setText("");
			priorityChoice.setValue("");
			estimateText.setText("");
		}
		else
		{
			root.setUserData("Requirement");
			Requirement display=managementSystemModel.getProject(this.state.getProjectId()).getRequirementList().getRequirementId(this.state.getRequirementId());
			requirementLabel.setText("Requirement");
			idText.setText(display.getId()+"");
			responsibleChoice.setValue(display.getResponsibleTeamMember().toString());
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			statusChoice.setValue(display.getStatus().toString());
			hoursSpentText.setText(display.getTimeSpent()+" H");
			priorityChoice.setValue(display.getPriority().toString());
			estimateText.setText(display.getEstimatedTime()+" H");
		}
		taskListViewModel.update();
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void addButtonPressed() {

	}

	@FXML private void removeButtonPressed() {

	}

	@FXML private void openButtonPressed() {
		state.setTaskId(
				taskListTable.getSelectionModel().getSelectedItem().getIdProperty());
		viewHandler.openView("task");
	}

	@FXML private void saveButtonPressed() {
		//check if deadline is valid
		//check if other stuff is valid
	}

	@FXML private void backButtonPressed() {
		state.setRequirementId(-1);
		viewHandler.openView("project");
	}

	@FXML private void homeButtonPressed() {
		state.reset();
		viewHandler.openView("home");
	}

}
