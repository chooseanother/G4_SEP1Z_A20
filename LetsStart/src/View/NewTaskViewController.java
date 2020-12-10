package View;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;



public class NewTaskViewController {

	@FXML private Region root;

	@FXML private TextField taskTitleID;

	@FXML private TextField taskID;

	@FXML private DatePicker deadlineID;

	@FXML private ChoiceBox statusID;

	@FXML private TextField totalHoursWorkedID;

	@FXML private TextField estimatedHoursID;

	@FXML private ChoiceBox responsibleTeamMembersID;

	@FXML private ViewHandler viewHandler;

	@FXML private ManagementSystemModel managementSystemModel;

  @FXML private String requirement;
  @FXML private ChoiceBox priorityID;
  private ObservableList<String> status= FXCollections.observableArrayList("Not Started", "Started", "Ended");
  private ObservableList<TeamMember> members=FXCollections.observableArrayList(managementSystemModel.);
  private ObservableList<String> priorities=FXCollections.observableArrayList("Low", "Medium", "High", "Critical");
 	public NewTaskViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		statusID.setItems(status);
		priorityID.setItems(priorities);
	}

	public void reset() {
		taskTitleID.setText("");
		taskID.setText("");
		deadlineID.setAccessibleText("");
		statusID.setAccessibleText("");
		totalHoursWorkedID.setText("");
		estimatedHoursID.setText("");
		responsibleTeamMembersID.setAccessibleText("");
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void taskTitlePressed() {
		taskTitleID.setText(taskTitleID.getUserData().toString());
	}

	@FXML private void taskIDPressed() {
   taskID.setText(taskID.getUserData().toString());
	}

	@FXML private void responsibleTeamMembersPressed() {
  responsibleTeamMembersID.setAccessibleText(responsibleTeamMembersID.getAccessibleText());
	}

	@FXML private void totalHoursWorkedPressed() {
   totalHoursWorkedID.setText(totalHoursWorkedID.getUserData().toString());
	}

	@FXML private void deadlinePressed() {
  deadlineID.setAccessibleText(deadlineID.getAccessibleText());
	}

	@FXML private void estimatedHoursPressed() {
  estimatedHoursID.setText(estimatedHoursID.getUserData().toString());
	}
  @FXML private void statusPressed()
	{
  statusID.setAccessibleText(statusID.getAccessibleHelp());
	}
	@FXML private void cancelButtonPressed() {
		reset();
		viewHandler.openView("taskList");
	}
  @FXML private void priorityPressed(){

	}
	@FXML private void saveButtonPressed() {
		int estimated=Integer.parseInt(estimatedHoursID.getUserData().toString());
		MyDate deadline=new MyDate();
		Status status=new Status(false);
		status.update(statusID.getUserData().toString());
		Priority priority=new Priority(Integer.parseInt(priorityID.getUserData().toString()));
		TeamMember model=managementSystemModel.getAllTeamMembers().getTeamMember(responsibleTeamMembersID.getUserData().toString());
    managementSystemModel.getRequirement().addTask(new Task(requirement, taskID.getAccessibleText(), "Task1", estimated, deadline, responsibleTeamMembersID.getUserData().toString(), status, priority), requirement);
	}

	@FXML private void homeButtonPressed() {
		reset();
		viewHandler.openView("taskList");
	}

	@FXML private void projectOverviewPressed() {
   reset();
   viewHandler.openView("project");
	}

	@FXML private void requirementsPressed() {
   reset();
   viewHandler.openView("requirement");
	}

	@FXML private void tasksPressed() {
		cancelButtonPressed();
	}

	@FXML private void teamMembersPressed() {
  reset();
  viewHandler.openView("teamMemberList");
	}

}
