package View;

import Model.ManagementSystemModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class TeamMemberListViewController {

	@FXML private Label teamMemberListTitle;
	@FXML private ObservableList<String> teamMemberList;
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;

	public TeamMemberListViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;	}

	public void reset() {

	}

	public Region getRoot() {
		return root;
	}

	@FXML private void teamMemberPressed() {

	}

	@FXML private void addButtonPressed() {

	}
	//operation35? The fuck? :D
	// Do we need a remove button here maybe?
	@FXML public void operation35() {

	}

}
