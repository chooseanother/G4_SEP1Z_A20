package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ProjectViewController {

	@FXML private Label titleID;
	@FXML private TextField descriptionID;
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;

	public ProjectViewController() {

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

	@FXML private void homeButtonPressed() {

	}

	@FXML private void projectOverviewPressed() {

	}

	@FXML private void requirementsPressed() {

	}

	@FXML private void teamMembersPressed() {

	}

}
