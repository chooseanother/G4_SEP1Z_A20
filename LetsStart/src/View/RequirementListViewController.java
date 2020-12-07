package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.util.Optional;

public class RequirementListViewController {

	@FXML private ObservableList<String> criticalPriorityList;
	@FXML private ObservableList<String> highPriorityList;
	@FXML private ObservableList<String> mediumPriorityList;
	@FXML private ObservableList<String> lowPriorityList;
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;

	public RequirementListViewController() {

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

	//choose a requirement to open? like remove from gradelist exercise
	@FXML private void removeButtonPressed() {
		confirmation();
	}

	private boolean confirmation()
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(
				"Removing requirement {??????????}");
		Optional<ButtonType> result = alert.showAndWait();
		return (result.isPresent()) && (result.get() == ButtonType.OK);
	}

	@FXML private void openButtonPressed(){
		viewHandler.openView("newRequirement");
	}

	@FXML private void addButtonPressed() {
		viewHandler.openView("newRequirement");
	}

	@FXML private void homeButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void projectOverviewPressed() {
		//project id???
		viewHandler.openView("project");
	}
}
