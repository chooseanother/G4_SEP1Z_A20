package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class RequirementViewController {
	//Stuff is missing here...
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;



	public RequirementViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state=state;
	}

	public void reset() {

	}

	public Region getRoot() {
		return root;
	}

	@FXML private void changePriorityButtonPressed() {

	}

	@FXML private void projectOverviewButtonPressed() {

	}

	@FXML private void requirementsButtonPressed() {

	}

	@FXML private void tasksButtonPressed() {

	}

	@FXML private void teamMembersButtonPressed() {

	}

	@FXML private void homeButtonPressed() {

	}

}
