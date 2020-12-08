package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewRequirementViewController {

	@FXML private Label requirementTitleID;
	@FXML private TextField requirementID;
	@FXML private TextField descriptionID;
	@FXML private TextField totalHoursWorkedID;
	@FXML private TextField estimatedHoursID;
	@FXML private TextField statusID;
	@FXML private TextField priorityID;
	@FXML private TextField deadlineID;
	@FXML private TextField responsibleTeamMemberID;
	private Region root;
	private ManagementSystemModel managementSystemModel;
	private ViewHandler viewHandler;



	public NewRequirementViewController() {

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

	@FXML private void cancelButtonPressed() {

	}

	@FXML private void saveButtonPressed() {

	}

}
