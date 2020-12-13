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
		if (state.getMemberId()>0){
			TeamMember tmp;
			//check if its from project or task
			if (state.getTaskId()<0)
			{
				tmp = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getMemberId());//implement team member id in all model classes
			}
			else{
				tmp = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getRequirementId(),
								state.getTaskId(), state.getMemberId());//implement team member id in all model classes
			}
			nameText.setText(tmp.getName().getFullName());
			idText.setText(state.getMemberId() + "");
			roleChoice.setValue(tmp.getRole().getRole());
		}
		else{
			title.setText("New Team Member");
		}
	}

	public void reset() {
		errorLabel.setText("");
		if (state.getMemberId()>0){
			TeamMember tmp;
			//check if its from project or task
			if (state.getTaskId()<0)
			{
				tmp = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getMemberId());//implement team member id in all model classes

			}
			else{
				tmp = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getRequirementId(),
								state.getTaskId(), state.getMemberId());//implement team member id in all model classes
			}
			nameText.setText(tmp.getName().getFullName());
			idText.setText(state.getMemberId() + "");
			roleChoice.setValue(tmp.getRole().getRole());
		}
		else{
			title.setText("New Team Member");
			nameText.setText("");
			idText.setText("");
			roleChoice.setValue("");
		}
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

		if (state.getMemberId()<0) {
			TeamMember tmp;
			tmp = new TeamMember(new Name(nameText.getText()),
					roleChoice.getSelectionModel().getSelectedItem());
			if (state.getTaskId() < 0)
				//if it is a task then it should be a team member from the project list
				//maybe a different view with a choice box where you can select
				// team members from related project that can be added.
				managementSystemModel.addTeamMember(state.getProjectId(), tmp);
			else
				managementSystemModel.addTeamMember(state.getProjectId(),
						state.getRequirementId(),state.getTaskId(),
						tmp);
		}
		else{
			TeamMember edit;
			if (state.getTaskId() < 0)
			{
				edit = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getMemberId());
			}
			else{
				edit = managementSystemModel
						.getTeamMember(state.getProjectId(), state.getRequirementId(),
								state.getTaskId(), state.getMemberId());
			}
			edit.setName(new Name(nameText.getText()));
			edit.assignRole(new Role(roleChoice.getSelectionModel().getSelectedItem()));
		}
		state.setMemberId(-1);
		viewHandler.openView("project");
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
