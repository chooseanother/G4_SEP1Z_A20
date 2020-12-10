package view;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewTeamMemberViewController {

	@FXML private TextField nameID;
	private Region root;
	private ManagementSystemModel managementSystemModel;
	private ViewHandler viewHandler;
	private ViewState state;


	public void NewTeamMemberViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
	}

	public Region getRoot() {
		return root;
	}

	public void reset() {

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

	@FXML private void backButtonPressed() {

	}
}
