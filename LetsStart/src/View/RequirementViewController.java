package View;

import Model.ManagementSystemModel;
import Model.Requirement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class RequirementViewController {
	//Stuff is missing here...
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;
	@FXML private Label requirementLabel;



	public RequirementViewController() {
	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state=state;


		if(this.state.getRequirementId()<0)
		{
			requirementLabel.setText("New Requirement");
			root.setUserData("New Requirement");
		}
		else
		{
			Requirement display=managementSystemModel.getProject(this.state.getProjectId()).getRequirementList().getRequirementId(this.state.getRequirementId());
			requirementLabel.setText("Requirement");
		}
	}

	public void reset() {
		if (state.getRequirementId()>0)
		{
			root.setUserData("Requirement");
		}
		else
			root.setUserData("New Requirement");


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
