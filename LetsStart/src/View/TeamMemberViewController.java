package View;

import Model.ManagementSystemModel;
import Model.Name;
import Model.Role;
import Model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	@FXML private Button saveButton;
	@FXML private ChoiceBox<String> roleChoice;
	@FXML private Label title, errorLabel, roleLabel, idLabel, nameLabel;
	private final ObservableList<String> roles = FXCollections.observableArrayList(
			Role.TEAM_MEMBER,Role.SCRUM_MASTER,
			Role.PRODUCT_OWNER,Role.PROJECT_CREATOR);

	private ObservableList<String> allowedTeamMembers = FXCollections.observableArrayList();

	public TeamMemberViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state = state;

		reset();
	}

	public void reset() {
		errorLabel.setText("");
		if (state.getTaskId()<0)
		{
			roleChoice.setItems(roles);
			roleLabel.setText("Role:");
			saveButton.setText("Save");
			nameText.setVisible(true);
			nameLabel.setVisible(true);
			idLabel.setVisible(true);
			idText.setVisible(true);
			if (state.getMemberId() > 0)
			{//check if its new or existing team member
				root.setUserData("Team Member");
				title.setText("Team Member");
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
				roleChoice.setValue(null);
			}
		}
		else {
			root.setUserData("Team Member");
			title.setText("Choose team member");
			allowedTeamMembers.clear();
			if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers() > 0){
				for (int i = 0; i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++){
					if (!managementSystemModel.getTask(state.getProjectId(),state.getRequirementId(),
							state.getTaskId()).getAllTeamMembers().contains(managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i))){
						allowedTeamMembers.add(managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).getName().toString());
					}
				}
			}
			saveButton.setText("Add");
			roleLabel.setText("Choose:");
			roleChoice.setItems(allowedTeamMembers);
			roleChoice.setValue(null);
			nameText.setVisible(false);
			nameLabel.setVisible(false);
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
			if (roleChoice.getValue().equals("")){
				errorLabel.setText("Select a role");
			}
			else
			{
				if (state.getMemberId() < 0)
				{
					TeamMember tmp;
					tmp = new TeamMember(new Name(nameText.getText()),
							roleChoice.getSelectionModel().getSelectedItem());

					managementSystemModel.addTeamMember(state.getProjectId(), tmp);
				}
				else
				{
					TeamMember edit = managementSystemModel.getTeamMember(state.getProjectId(), state.getMemberId());
					edit.setName(new Name(nameText.getText()));
					edit.assignRole(new Role(roleChoice.getSelectionModel().getSelectedItem()));
				}
				state.setMemberId(-1);
				viewHandler.openView("project");
			}
		}
		else {
			if (roleChoice.getValue().equals("")){
				errorLabel.setText("Select a team member");
			}
			TeamMember add = null;
			for (int i = 0;
					 i < managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++) {
				if (managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList().getTeamMemberIndex(i).getName().toString()
						.equalsIgnoreCase(roleChoice.getValue())) {
					add = managementSystemModel.getProject(this.state.getProjectId()).getTeamMemberList()
							.getTeamMemberIndex(i);
				}
			}
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
