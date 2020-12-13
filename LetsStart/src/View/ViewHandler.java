package View;

import Model.ManagementSystemModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{

	private Scene currentScene;
	private Stage primaryStage;
	private Region root;
	private ManagementSystemModel model;
	private HomeViewController homeViewController;
	private ProjectViewController projectViewController;
	private RequirementViewController requirementViewController;
	private TaskViewController taskViewController;
	private TeamMemberViewController teamMemberViewController;
	private ViewState state;

	public ViewHandler(ManagementSystemModel model)
	{
		this.currentScene = new Scene(new Region());
		this.model = model;
		state = new ViewState();
	}

	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		openView("home");
	}

	public void openView(String id)
	{
		root = null;
		switch (id)
		{
			case "home":
				root = loadHomeView("HomeView.fxml", state);
				break;
			case "project":
				root = loadProjectView("ProjectView.fxml", state);
				break;
			case "requirement":
				root = loadRequirementView("RequirementView.fxml", state);
				break;
			case "task":
				root = loadTaskView("TaskView.fxml", state);
				break;
			case "teamMember":
				root = loadTeamMemberView("TeamMemberView.fxml", state);
				break;
		}

		currentScene.setRoot(root);
		String title = "";
		if (root.getUserData() != null)
		{
			title += root.getUserData();
		}
		primaryStage.setTitle(title);
		primaryStage.setScene(currentScene);
		primaryStage.setWidth(root.getPrefWidth());
		primaryStage.setHeight(root.getPrefHeight());
		primaryStage.show();
	}

	public void closeView()
	{
		primaryStage.close();
	}

	private Region loadHomeView(String fxmlFile, ViewState state)
	{
		if (homeViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				homeViewController = loader.getController();
				homeViewController.init(this, model, root, state);
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

	private Region loadProjectView(String fxmlFile, ViewState state)
	{
		if (projectViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				projectViewController = loader.getController();
				projectViewController.init(this, model, root, state);
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

	private Region loadRequirementView(String fxmlFile, ViewState state)
	{
		if (requirementViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				requirementViewController = loader.getController();
				requirementViewController.init(this, model, root, state);
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

	private Region loadTaskView(String fxmlFile, ViewState state)
	{
		if (taskViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				taskViewController = loader.getController();
				taskViewController.init(this, model, root, state);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			taskViewController.reset();
		return taskViewController.getRoot();
	}

	private Region loadTeamMemberView(String fxmlFile, ViewState state)
	{
		if (teamMemberViewController == null)
		{
			try
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(fxmlFile));
				root = loader.load();
				teamMemberViewController = loader.getController();
				teamMemberViewController.init(this, model, root, state);
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
}