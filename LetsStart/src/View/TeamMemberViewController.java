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
	@FXML private TextField nameText, idText;
	@FXML private ChoiceBox<String> roleChoice;
	@FXML private Label title, errorLabel, roleLabel, idLabel;
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
		reset();
	}

	public void reset() {
		errorLabel.setText("");
		if (state.getTaskId()<0)
		{
			roleChoice.setVisible(true);
			roleLabel.setVisible(true);
			idLabel.setVisible(true);
			idText.setVisible(true);
			if (state.getMemberId() > 0)
			{//check if its new or existing team member
				root.setUserData("Team Member");
				TeamMember tmp;
				tmp = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getMemberId());

				nameText.setText(tmp.getName().getFullName());
				idText.setText(state.getMemberId() + "");
				roleChoice.setValue(tmp.getRole().getRole());
			}
			else
			{
				title.setText("New Team Member");
				root.setUserData("New Team Member");
				nameText.setText("");
				idText.setText("");
				roleChoice.setValue("");
			}
		}
		else {
			roleChoice.setVisible(false);
			roleLabel.setVisible(false);
			idLabel.setVisible(false);
			idText.setVisible(false);
		}
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void homeButtonPressed() {
		state.reset();
		viewHandler.openView("home");
	}

	@FXML private void backButtonPressed() {
		state.setMemberId(-1);
		if (state.getTaskId() < 0)
			viewHandler.openView("project");
		else
			viewHandler.openView("task");
	}

	@FXML private void saveButtonPressed(){
		//check state if its a new tm that needs to be added, or existing tm that needs to be edited
		//check if role is available
		if (state.getTaskId()<0)
		{
			if (state.getMemberId() < 0)
			{
				TeamMember tmp;
				tmp = new TeamMember(new Name(nameText.getText()),
						roleChoice.getSelectionModel().getSelectedItem());

				managementSystemModel.addTeamMember(state.getProjectId(), tmp);
				managementSystemModel.addTeamMember(state.getProjectId(), state.getRequirementId(),
						state.getTaskId(), tmp);
			}
			else
			{
				TeamMember edit;

				edit = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getMemberId());

				edit.setName(new Name(nameText.getText()));
				edit.assignRole(new Role(roleChoice.getSelectionModel().getSelectedItem()));
			}
			state.setMemberId(-1);
			viewHandler.openView("project");
		}
		else {
			TeamMember add = managementSystemModel
					.getTeamMember(state.getProjectId(), state.getMemberId());

			managementSystemModel.addTeamMember(state.getProjectId(), state.getRequirementId(),
					state.getTaskId(), add);
			state.setMemberId(-1);
			viewHandler.openView("task");
		}

	}

	@FXML private void nameTyped(){
		if (nameText.getText().split(" ").length !=2){
			errorLabel.setText("Name must be in the form of \"Name Surname\"");
		}
		else{
			errorLabel.setText("");
		}
	}
}
