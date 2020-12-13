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
	@FXML private TextField idText, statusText, hoursSpentText, estimateText;
	@FXML private TextArea descriptionText;
	@FXML private ChoiceBox<String> responsibleChoice, priorityChoice;
	@FXML private DatePicker deadlineDate;
	@FXML private TableView<TaskViewModel> taskListTable;
	@FXML private TableColumn<TaskViewModel, String> titleCollum;
	@FXML private TableColumn<TaskViewModel, String> statusCollum;
	@FXML private TableColumn<TaskViewModel, Number> idCollum;
	private TaskListViewModel taskListViewModel;
	private final ObservableList<String> priorities = FXCollections.observableArrayList(
			Priority.PRIORITIES[0],Priority.PRIORITIES[1],
			Priority.PRIORITIES[2],Priority.PRIORITIES[3]);
	private ObservableList<String> allowedTeamMembers = FXCollections.observableArrayList();;



	public RequirementViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state=state;
		priorityChoice.setItems(priorities);
		responsibleChoice.setItems(allowedTeamMembers);
		taskListViewModel = new TaskListViewModel(managementSystemModel, this.state);
		titleCollum.setCellValueFactory(cellData -> cellData.getValue().titlePropertyProperty());
		statusCollum.setCellValueFactory(cellData -> cellData.getValue().statusPropertyProperty());
		idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		taskListTable.setItems(taskListViewModel.getList());
		errorLabel.setText("");
		if(this.state.getRequirementId()<0){
			requirementLabel.setText("New Requirement");
		}
		else
		{
			Requirement display=managementSystemModel.getProject(this.state.getProjectId()).getRequirementList().getRequirementId(this.state.getRequirementId());
			requirementLabel.setText("Requirement");
			idText.setText(display.getId()+"");
			//Responsible
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			//status
			hoursSpentText.setText(display.getTimeSpent()+" H");
			//priority
			//Estimated time
			taskListViewModel.update();
		}
	}

	public void reset() {
		errorLabel.setText("");
		if(this.state.getRequirementId()<0){
			requirementLabel.setText("New Requirement");
			idText.setText("");
			//Responsible
			descriptionText.setText("");
			deadlineDate.setValue(null);
			//status
			hoursSpentText.setText("");
			//priority
			estimateText.setText("");
		}
		else
		{
			Requirement display=managementSystemModel.getProject(this.state.getProjectId()).getRequirementList().getRequirementId(this.state.getRequirementId());
			requirementLabel.setText("Requirement");
			idText.setText(display.getId()+"");
			//Responsible
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			//status
			hoursSpentText.setText(display.getTimeSpent()+" H");
			//priority
			//Estimated time
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
		//
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
