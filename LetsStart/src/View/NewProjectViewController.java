package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class NewProjectViewController {
	@FXML private Button cancel;
	@FXML private TextField projectNameID;
	@FXML private TextField descriptionID;
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

	}

	public Region getRoot() {
		return root;
	}

	@FXML private void cancelButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void saveButtonPressed() {

	}

	@FXML private void projectNameTyped() {

	}

	@FXML private void descriptionTyped() {

	}

	@FXML private void backButtonPressed() {

	}

}
