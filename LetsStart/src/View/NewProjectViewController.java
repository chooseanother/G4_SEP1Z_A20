package View;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewProjectViewController {
	@FXML private TextField projectName, description;
	@FXML private DatePicker deadline;
	@FXML private Button requirements, save, home, cancel;
	@FXML private Label errorLabel, descriptionLabel, deadlineLabel, nameLabel;
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;


	public NewProjectViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
	}

	public void reset() {
		projectName.setText("");
		description.setText("");
		errorLabel.setText("");
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void cancelButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void saveButtonPressed() {
		//Project name is used for what??? where is id???
		//try and catch exceptions base on if any field is missing,
		// written name is not accepted or if deadline is before today or
		//not far enough into the future
		managementSystemModel.addProject(new Project(projectName.getText(),new TeamMemberList(),new RequirementList(),new Customer(),new MyDate(deadline.toString()),description.getText()));
	}

	@FXML private void projectNameTyped() {

	}

	@FXML private void descriptionTyped() {

	}

	@FXML private void homeButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void requirementsButtonPressed() {

		//requirement list for what project??? pass id??? how???
		viewHandler.openView("requirementList");
	}

}
