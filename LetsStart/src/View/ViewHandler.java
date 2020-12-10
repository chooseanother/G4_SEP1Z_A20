package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {

	private Scene currentScene;
	private Stage primaryStage;
	private Region root;
	private ManagementSystemModel model;
	private HomeViewController homeViewController;
	private ProjectViewController projectViewController;
	private RequirementListViewController requirementListViewController;
	private TeamMemberListViewController teamMemberListViewController;
	private NewProjectViewController newProjectViewController;
	private TeamMemberViewController teamMemberViewController;
	private NewTaskViewController newTaskViewController;
	private RequirementViewController requirementViewController;
	private TaskListViewController taskListViewController;
	private NewTeamMemberViewController newTeamMemberViewController;
	private NewRequirementViewController newRequirementViewController;
	private ViewState state;


	public ViewHandler(ManagementSystemModel model) {
		this.currentScene = new Scene(new Region());
		this.model = model;
		state = new ViewState();
	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		openView("home");
	}

	public void openView(String id){
		root = null;
		switch (id){
			case "home":
				root = loadHomeView("HomeView.fxml", state);
				break;
			case "newProject":
				root = loadNewProjectView("NewProjectView.fxml", state);
				break;
			case "newRequirement":
				root = loadNewRequirementView("NewRequirementView.fxml", state);
				break;
			case "newTask":
				root = loadNewTaskView("NewTaskView.fxml", state);
				break;
			case "newTeamMember":
				root = loadNewTeamMemberView("NewTeamMemberView.fxml", state);
				break;
			case "project":
				root = loadProjectView("ProjectView.fxml", state);
				break;
			case "requirementList":
				root = loadRequirementListView("RequirementListView.fxml", state);
				break;
			case "requirement":
				root = loadRequirementViewController("RequirementView.fxml", state);
				break;
			case "taskList":
				root = loadTaskListView("TaskListView.fxml", state);
				break;
			case "teamMemberList":
				root = loadTeamMemberListView("TeamMemberListView.fxml", state);
				break;
			case "teamMember":
				root = loadTeamMemberView("TeamMemberView.fxml", state);
				break;
		}

		currentScene.setRoot(root);
		String title = "";
		if (root.getUserData() != null){
			title += root.getUserData();
		}
		primaryStage.setTitle(title);
		primaryStage.setScene(currentScene);
		primaryStage.setWidth(root.getPrefWidth());
		primaryStage.setHeight(root.getPrefHeight());
		primaryStage.show();
	}

	public void closeView() {
		primaryStage.close();
	}

	private Region loadHomeView(String fxmlFile, ViewState state) {
		if (homeViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				homeViewController = loader.getController();
				homeViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			homeViewController.reset();
		return homeViewController.getRoot();
	}

	private Region loadProjectView(String fxmlFile, ViewState state) {
		if (projectViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				projectViewController = loader.getController();
				projectViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			projectViewController.reset();
		return projectViewController.getRoot();
	}

	private Region loadRequirementListView(String fxmlFile, ViewState state) {
		if (requirementListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				requirementListViewController = loader.getController();
				requirementListViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			requirementListViewController.reset();
		return requirementListViewController.getRoot();
	}

	private Region loadTaskListView(String fxmlFile, ViewState state) {
		if (taskListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				taskListViewController = loader.getController();
				taskListViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			taskListViewController.reset();
		return taskListViewController.getRoot();
	}

	private Region loadTeamMemberListView(String fxmlFile, ViewState state) {
		if (teamMemberListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				teamMemberListViewController = loader.getController();
				teamMemberListViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			teamMemberListViewController.reset();
		return teamMemberListViewController.getRoot();
	}

	private Region loadNewProjectView(String fxmlFile, ViewState state) {
		if (newProjectViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newProjectViewController = loader.getController();
				newProjectViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			newProjectViewController.reset();
		return newProjectViewController.getRoot();
	}

	private Region loadNewRequirementView(String fxmlFile, ViewState state) {
		if (newRequirementViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newRequirementViewController = loader.getController();
				newRequirementViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			newRequirementViewController.reset();
		return newRequirementViewController.getRoot();
	}

	private Region loadTeamMemberView(String fxmlFile, ViewState state) {
		if (teamMemberViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				teamMemberViewController = loader.getController();
				teamMemberViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			teamMemberViewController.reset();
		return teamMemberViewController.getRoot();
	}

	private Region loadNewTaskView(String fxmlFile, ViewState state) {
		if (newTaskViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newTaskViewController = loader.getController();
				newTaskViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			newTaskViewController.reset();
		return newTaskViewController.getRoot();
	}

	private Region loadNewTeamMemberView(String fxmlFile, ViewState state) {
		if (newTeamMemberViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newTeamMemberViewController = loader.getController();
				newTeamMemberViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			newTeamMemberViewController.reset();
		return newTeamMemberViewController.getRoot();
	}

	private Region loadRequirementViewController(String fxmlFile, ViewState state) {
		if (requirementViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				requirementViewController = loader.getController();
				requirementViewController.init(this,model,root,state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			requirementViewController.reset();
		return requirementViewController.getRoot();
	}

}
