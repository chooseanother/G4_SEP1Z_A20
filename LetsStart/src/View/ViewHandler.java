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


	public ViewHandler(ManagementSystemModel model) {
		this.currentScene = new Scene(new Region());
		this.model = model;
	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		openView("home");
	}

	public void openView(String id){
		root = null;
		switch (id){
			case "home":
				root = loadHomeView("HomeView.fxml");
				break;
			case "newProject":
				root = loadNewProjectView("newProjectView.fxml");
				break;
			case "newRequirement":
				root = loadNewRequirementView("newRequirementView.fxml");
				break;
			case "newTask":
				root = loadNewTaskView("newTaskView.fxml");
				break;
			case "newTeamMember":
				root = loadNewTeamMemberView("newTeamMemberView.fxml");
				break;
			case "project":
				root = loadProjectView("projectView.fxml");
				break;
			case "requirementList":
				root = loadRequirementListView("requirementListView.fxml");
				break;
			case "requirement":
				root = loadRequirementViewController("requirementView.fxml");
				break;
			case "taskList":
				root = loadTaskListView("taskListView.fxml");
				break;
			case "teamMemberList":
				root = loadTeamMemberListView("teamMemberListView.fxml");
				break;
			case "teamMember":
				root = loadTeamMemberView("teamMemberView.fxml");
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

	private Region loadHomeView(String fxmlFile) {
		if (homeViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				homeViewController = loader.getController();
				homeViewController.init(this,model,root);
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

	private Region loadProjectView(String fxmlFile) {
		if (projectViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				projectViewController = loader.getController();
				projectViewController.init(this,model,root);
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

	private Region loadRequirementListView(String fxmlFile) {
		if (requirementListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				requirementListViewController = loader.getController();
				requirementListViewController.init(this,model,root);
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

	private Region loadTaskListView(String fxmlFile) {
		if (taskListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				taskListViewController = loader.getController();
				taskListViewController.init(this,model,root);
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

	private Region loadTeamMemberListView(String fxmlFile) {
		if (teamMemberListViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				teamMemberListViewController = loader.getController();
				teamMemberListViewController.init(this,model,root);
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

	private Region loadNewProjectView(String fxmlFile) {
		if (newProjectViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newProjectViewController = loader.getController();
				newProjectViewController.init(this,model,root);
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

	private Region loadNewRequirementView(String fxmlFile) {
		if (newRequirementViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newRequirementViewController = loader.getController();
				newRequirementViewController.init(this,model,root);
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

	private Region loadTeamMemberView(String fxmlFile) {
		if (teamMemberViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				teamMemberViewController = loader.getController();
				teamMemberViewController.init(this,model,root);
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

	private Region loadNewTaskView(String fxmlFile) {
		if (newTaskViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newTaskViewController = loader.getController();
				newTaskViewController.init(this,model,root);
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

	private Region loadNewTeamMemberView(String fxmlFile) {
		if (newTeamMemberViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				newTeamMemberViewController = loader.getController();
				newTeamMemberViewController.init(this,model,root);
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

	private Region loadRequirementViewController(String fxmlFile) {
		if (requirementViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				requirementViewController = loader.getController();
				requirementViewController.init(this,model,root);
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
