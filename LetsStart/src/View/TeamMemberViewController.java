package View;

import Model.ManagementSystemModel;
import Model.Name;
import Model.Role;
import Model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class TeamMemberViewController {
	//missing stuff here
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;
	@FXML private TextField nameText;
	@FXML private ChoiceBox<String> roleChoice;
	@FXML private Label title, errorLabel;
	private final ObservableList<String> roles = FXCollections.observableArrayList(
					Role.TEAM_MEMBER,Role.SCRUM_MASTER,
					Role.PRODUCT_OWNER,Role.PROJECT_CREATOR);

	public TeamMemberViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state = state;
		roleChoice.setItems(roles);
		errorLabel.setText("");
	}

	public void reset() {
		errorLabel.setText("");
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void removeButtonPressed() {
		//need some kind of state that handles what team member is displayed that needs to be removed
		if (state.getTaskId() < 0)
		 viewHandler.openView("project");
		else
			viewHandler.openView("task");
	}

	@FXML private void homeButtonPressed() {
		state = new ViewState();
		viewHandler.openView("home");
	}

	@FXML private void backButtonPressed() {
		if (state.getTaskId() < 0)
			viewHandler.openView("project");
		else
			viewHandler.openView("task");
	}

	@FXML private void saveButtonPressed(){
		//check state if its a new tm that needs to be added, or existing tm that needs to be edited
		if (state.getTaskId() < 0)
		 managementSystemModel.addTeamMember(state.getProjectId(),
				 new TeamMember(new Name(nameText.getText()), roleChoice.getValue()));
		else
			managementSystemModel.addTeamMember(state.getProjectId(),
					state.getRequirementId(),state.getTaskId(),
					new TeamMember(new Name(nameText.getText()),roleChoice.getValue()));
	}

	@FXML private void nameTyped(){
		if (nameText.getText().split(" ").length !=2){
			errorLabel.setText("Name must be in the form off \"Name Surname\"");
		}
		else{
			errorLabel.setText("");
		}
	}
}
