package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class RequirementListViewController {

	@FXML private ObservableList<String> criticalPriorityList;
	@FXML private ObservableList<String> hightPriorityList;
	@FXML private ObservableList<String> mediumPriorityList;
	@FXML private ObservableList<String> lowPriorityList;
	@FXML private Region root;
	@FXML private ViewHandler viewHandler;
	@FXML private ManagementSystemModel managementSystemModel;



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

	@FXML private void addButtonPressed() {

	}

	@FXML private void homeButtonPressed() {

	}

	@FXML private void projectOverviewPressed() {

	}

}
