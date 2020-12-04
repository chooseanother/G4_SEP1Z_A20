package View;

import Model.ManagementSystemModel;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewRequirementViewController {

	private Label requirementTitleID;

	private TextField requirementID;

	private TextField descriptionID;

	private TextField totalHoursWorkedID;

	private TextField estimatedHoursID;

	private TextField statusID;

	private TextField priorityID;

	private TextField deadlineID;

	private TextField responsibleTeamMemberID;

	private Region root;

	private ManagementSystemModel managementSystemModel;

	private ViewHandler viewHandler;



	public NewRequirementViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {

	}

	public void reset() {

	}

	public Region getRoot() {
		return null;
	}

	private void cancelButtonPressed() {

	}

	private void saveButtonPressed() {

	}

	private void backButtonPressed() {

	}

}
