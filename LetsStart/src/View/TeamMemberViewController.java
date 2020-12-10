package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class TeamMemberViewController {
	//missing stuff here
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;

	public TeamMemberViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
	}

	public void reset() {

	}

	public Region getRoot() {
		return root;
	}

	@FXML private void removeButtonPressed() {

	}

	@FXML private void homeButtonPressed() {

	}

	@FXML private void teamMembersPressed() {

	}

	@FXML private void projectOverviewPressed() {

	}

	@FXML private void requirementsPressed() {

	}

	@FXML private void backButtonPressed() {

	}
}
