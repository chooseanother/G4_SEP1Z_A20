package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class HomeViewController {

	@FXML private Button newProject;
	@FXML private TextField searchProjectBar;
	private ObservableList<String> projectList;
	private Region root;
	private ManagementSystemModel managementSystemModel;
	private ViewHandler viewHandler;


	public HomeViewController() {

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

	@FXML private void newProjectButtonPressed() {
		viewHandler.openView("newProject");
	}

	@FXML private void searchProjectButtonPressed() {

	}

	@FXML private void projectPressed() {

	}

}
