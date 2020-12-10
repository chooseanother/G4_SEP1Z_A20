package View;

import Model.ManagementSystemModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

public class NewRequirementViewController {

	@FXML private TextField descriptionID;
	@FXML private TextField estimatedHoursID;
	@FXML private TextField statusID;
	@FXML private TextField priorityID;
	@FXML private TextField deadlineID;
	@FXML private TextField responsibleTeamMemberID;
	@FXML private ChoiceBox priorityBox;
	private Region root;
	private ManagementSystemModel managementSystemModel;
	private ViewHandler viewHandler;

	private ObservableList<String> priorities = FXCollections.observableArrayList("Low","Medium","High","Critical");

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
		viewHandler.openView("requirementList");
	}

	@FXML private void saveButtonPressed() {

	}

	@FXML public void initialize() {
		priorityBox.setItems(priorities);
	}

}
