package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class TaskListViewController {
	//Missing stuff here
	private ArrayList<String> questionMark;
	@FXML private ListView<ObservableList<String>> taskList;
	private ViewState state;

	private Region root;

	private ManagementSystemModel managementSystemModel;

	private ViewHandler viewHandler;



	public TaskListViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;	}

	public Region getRoot() {
		return root;
	}

	public void reset() {

	}

	@FXML private void homeButtonPressed() {

	}

	@FXML private void projectOverviewPressed() {

	}

	@FXML private void requirementsPressed() {

	}

	@FXML private void addButtonPressed() {

	}

	@FXML private void teamMembersPressed() {

	}

}
