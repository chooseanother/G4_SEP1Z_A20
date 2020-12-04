package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class TaskListViewController {

	private ArrayList<String> questionMark;
	private ListView<ObservableList<String>> taskList;

	private Region root;

	private ManagementSystemModel managementSystemModel;

	private ViewHandler viewHandler;



	public TaskListViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {

	}

	public Region getRoot() {
		return null;
	}

	public void reset() {

	}

	public void homeButtonPressed() {

	}

	public void projectOverviewPressed() {

	}

	public void requirementsPressed() {

	}

	public void addButtonPressed() {

	}

	public void teamMembersPressed() {

	}

}
