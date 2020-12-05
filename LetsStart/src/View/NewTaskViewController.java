package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewTaskViewController {

	@FXML private Region root;

	@FXML private TextField taskTitleID;

	@FXML private TextField taskID;

	@FXML private TextField deadlineID;

	@FXML private TextField statusID;

	@FXML private TextField totalHoursWorkedID;

	@FXML private TextField estimatedHoursID;

	@FXML private TextField responsibleTeamMembersID;

	@FXML private ViewHandler viewHandler;

	@FXML private ManagementSystemModel managementSystemModel;



	public NewTaskViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
	}

	public void reset() {

	}

	public Region getRoot() {
		return root;
	}

	@FXML private void taskTitlePressed() {

	}

	@FXML private void taskIDPressed() {

	}

	@FXML private void responsibleTeamMembersPressed() {

	}

	@FXML private void totalHoursWorkedPressed() {

	}

	@FXML private void deadlinePressed() {

	}

	@FXML private void estimatedHoursPressed() {

	}

	@FXML private void cancelButtonPressed() {

	}

	@FXML private void saveButtonPressed() {

	}

	@FXML private void homeButtonPressed() {

	}

	@FXML private void projectOverviewPressed() {

	}

	@FXML private void requirementsPressed() {

	}

	@FXML private void tasksPressed() {

	}

	@FXML private void teamMembersPressed() {

	}

}
