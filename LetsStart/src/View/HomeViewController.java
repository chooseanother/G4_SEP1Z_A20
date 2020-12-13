package View;

import ListView.ProjectListViewModel;
import ListView.ProjectViewModel;
import Model.ManagementSystemModel;
import Model.Project;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.util.Optional;

public class HomeViewController {

	@FXML private TableColumn<ProjectViewModel, Number> idCollum;
	@FXML private TableColumn<ProjectViewModel, String> titleCollum, deadlineCollum, progressCollum;
	@FXML private TableView<ProjectViewModel> projectListTable;
	private Region root;
	private ManagementSystemModel managementSystemModel;
	private ViewHandler viewHandler;
	private ViewState state;
	private ProjectListViewModel projectListViewModel;

	public HomeViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state = state;
		managementSystemModel.loadFromFile();
		projectListViewModel = new ProjectListViewModel(managementSystemModel);
		idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		titleCollum.setCellValueFactory(cellData -> cellData.getValue().titlePropertyProperty());
		deadlineCollum.setCellValueFactory(cellData -> cellData.getValue().deadlinePropertyProperty());
		progressCollum.setCellValueFactory(cellData -> cellData.getValue().progressPropertyProperty());
		projectListTable.setItems(projectListViewModel.getList());
	}

	public void reset() {
		projectListViewModel.update();
	}

	public Region getRoot() {
		return root;
	}

	@FXML private  void addProjectButtonPressed(ActionEvent actionEvent)
	{
		state.setProjectId(-1);
		viewHandler.openView("project");
	}

	@FXML private  void openButtonPressed(ActionEvent actionEvent)
	{
		state.setProjectId(projectListTable.getSelectionModel().getSelectedItem().getIdProperty());
		viewHandler.openView("project");
	}

	@FXML private  void removeButtonPressed(ActionEvent actionEvent)
	{
		try
		{
			ProjectViewModel selectedItem = projectListTable.getSelectionModel().getSelectedItem();
			boolean remove = removeConfirmation();
			if (remove)
			{
				managementSystemModel.removeProject(selectedItem.getIdProperty());
				projectListViewModel.remove(selectedItem.getIdProperty());
				projectListTable.getSelectionModel().clearSelection();
			}
		}
		catch (Exception e)
		{
			//errorLabel.setText("Item not found: " + e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	@FXML private  void exitButtonPressed(ActionEvent actionEvent)
	{
		if (exitConfirmation()){
			managementSystemModel.saveToFile();
		}
		viewHandler.closeView();
	}

	private boolean removeConfirmation()
	{
		int index = projectListTable.getSelectionModel().getSelectedIndex();
		ProjectViewModel selectedItem = projectListTable.getItems().get(index);
		if (index < 0 || index >= projectListTable.getItems().size())
		{
			return false;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(
				"Removing project " + selectedItem.getTitleProperty() + " "
						+ selectedItem.getIdProperty());
		Optional<ButtonType> result = alert.showAndWait();
		return (result.isPresent()) && (result.get() == ButtonType.OK);
	}

	private boolean exitConfirmation()
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("You are about to exit.\nPress OK to save changes\nPress Cancel to exit without saving.");
		Optional<ButtonType> result = alert.showAndWait();
		return (result.isPresent()) && (result.get() == ButtonType.OK);
	}

	@FXML private void testDoubleClick(MouseEvent mouseEvent)
	{

	}
}
