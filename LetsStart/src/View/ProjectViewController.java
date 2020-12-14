package View;

import Model.*;
import ListView.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class ProjectViewController
{

	@FXML private Label errorLabel, descriptionLabel, deadlineLabel, customerLabel,projectLabel;
	@FXML private TextArea descriptionText;
	@FXML private  DatePicker deadlineDate;
	@FXML private  TextField progressText,hoursSpentText,idText, customerText, titleText;
	@FXML private  TableView<RequirementViewModel> requirementListTable;
	@FXML private  TableColumn<RequirementViewModel, String> descriptionCollum;
	@FXML private  TableColumn<RequirementViewModel, Number> idCollum;
	@FXML private  TableColumn<RequirementViewModel, String> statusCollum;
	@FXML private  TableColumn<RequirementViewModel, String> priorityCollum;
	@FXML private  TableView<TeamMemberViewModel> teamMemberListTable;
	@FXML private  TableColumn<TeamMemberViewModel, String> nameCollum;
	@FXML private  TableColumn<TeamMemberViewModel, String> roleCollum;
	@FXML private  TableColumn<TeamMemberViewModel, Number> tmIdCollum;

	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;
	private RequirementListViewModel requirementListViewModel;
	private TeamMemberListViewModel teamMemberListViewModel;


	public ProjectViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		this.state = state;
		errorLabel.setText("");
		requirementListViewModel = new RequirementListViewModel(managementSystemModel, this.state);
		teamMemberListViewModel = new TeamMemberListViewModel(managementSystemModel, this.state);
		descriptionCollum.setCellValueFactory(cellData -> cellData.getValue().descriptionPropertyProperty());
		idCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		statusCollum.setCellValueFactory(cellData -> cellData.getValue().statusPropertyProperty());
		priorityCollum.setCellValueFactory(cellData -> cellData.getValue().priorityPropertyProperty());
		requirementListTable.setItems(requirementListViewModel.getList());
		nameCollum.setCellValueFactory(cellData -> cellData.getValue().namePropertyProperty());
		roleCollum.setCellValueFactory(cellData -> cellData.getValue().rolePropertyProperty());
		tmIdCollum.setCellValueFactory(cellData -> cellData.getValue().idPropertyProperty());
		teamMemberListTable.setItems(teamMemberListViewModel.getList());
		if (this.state.getProjectId()<0)
		{
			projectLabel.setText("New Project");
			root.setUserData("New Project");
		}
		else{

			Project display = managementSystemModel.getProject(this.state.getProjectId());
			projectLabel.setText("Project");
			titleText.setText(display.getTitle());
			customerText.setText(display.getCustomer().toString());
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			progressText.setText(String.format("%.2f",display.getProgress())+"%");
			hoursSpentText.setText(display.getTotalHoursSpent()+"H");
			idText.setText(display.getId()+"");
			requirementListViewModel.update();
			teamMemberListViewModel.update();
		}


	}

	public void reset() {
		if (state.getProjectId() < 0)
		{
			projectLabel.setText("New Project");
			descriptionText.setText("");
			customerText.setText("");
			progressText.setText("");
			titleText.setText("");
			deadlineDate.setValue(null);
			hoursSpentText.setText("");
			idText.setText("");
			root.setUserData("New Project");
		}
		else{
			Project display = managementSystemModel.getProject(state.getProjectId());
			projectLabel.setText("Project");
			titleText.setText(display.getTitle());
			customerText.setText(display.getCustomer().toString());
			descriptionText.setText(display.getDescription());
			MyDate tmp = display.getDeadline();
			deadlineDate.setValue(LocalDate.of(tmp.getYear(),tmp.getMonth(),tmp.getDay()));
			progressText.setText(String.format("%.2f",display.getProgress())+"%");
			hoursSpentText.setText(display.getTotalHoursSpent()+"H");
			idText.setText(display.getId()+"");
			root.setUserData("Project");

		}
		errorLabel.setText("");
		requirementListViewModel.update();
		teamMemberListViewModel.update();
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void backButtonPressed() {
		state.setProjectId(-1);
		//check if there are changes not save, ask if user wants to save
		viewHandler.openView("home");
	}

	@FXML private void saveButtonPressed() {
		//try and catch exceptions base on if any field is missing,
		// written name is not accepted or if deadline is before today or
		//not far enough into the future
		LocalDate dl = deadlineDate.getValue();
		if (state.getProjectId()<0){
			try
			{
				Project tmp = new Project(titleText.getText(), new Customer(customerText.getText()),
						new MyDate(dl.getDayOfMonth(), dl.getMonthValue(), dl.getYear()),
						descriptionText.getText());
				state.setProjectId(tmp.getId());
				managementSystemModel.addProject(tmp);
				titleText.setText(tmp.getTitle());
				progressText.setText(String.format("%.2f", tmp.getProgress()) + "%");
				hoursSpentText.setText(tmp.getTotalHoursSpent() + "");
				idText.setText(tmp.getId() + "");
			}
			catch (Exception e){
				errorLabel.setText(e.getMessage());
			}
		}
		else{
			try
			{
				Project edit = managementSystemModel.getProject(state.getProjectId());
				edit.setTitle(titleText.getText());
				edit.setCustomer(new Customer(customerText.getText()));
				edit.setDescription(descriptionText.getText());
				edit.setDeadline(new MyDate(dl.getDayOfMonth(), dl.getMonthValue(), dl.getYear()));
			}
			catch (Exception e){
				errorLabel.setText(e.getMessage());
			}
		}
		managementSystemModel.saveToFile();
	}

	@FXML private void customerNameTyped(){
		if (customerText.getText().split(" ").length !=2){
			errorLabel.setText("Customer name must be in the form off \"Name Surname\"");
		}
		else{
			errorLabel.setText("");
		}
	}

	@FXML private void homeButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void reqDButtonPressed() {
		state.setRequirementId(requirementListTable.getSelectionModel().getSelectedItem().getIdProperty());
		viewHandler.openView("requirement");
	}

	@FXML private void tMDButtonPressed(ActionEvent actionEvent)
	{
		teamMemberListTable.getSelectionModel().getSelectedItem().getIdProperty();
		state.setMemberId(teamMemberListTable.getSelectionModel().getSelectedItem().getIdProperty());
		viewHandler.openView("teamMember"); //how to parse team member info that should be displayed
	}

	@FXML private void addReqButtonPressed(ActionEvent actionEvent)
	{
		state.setRequirementId(-1);//this is wrong, you need to know what project id you are working from
		//project id is already set to current id. state.setProjectId(Integer.parseInt(idText.getText()));
		if (state.getProjectId()<0){
			errorLabel.setText("\"Save project before adding requirements\"");
		}
		else{
			viewHandler.openView("requirement");
		}
	}

	@FXML private void removeReqButtonPressed(ActionEvent actionEvent)
	{
		state.setRequirementId(requirementListTable.getSelectionModel().getSelectedItem().getIdProperty());
		managementSystemModel.getProject(Integer.parseInt(idText.getText())).getRequirementList().removeRequirement(state.getRequirementId());
		requirementListViewModel.update();
	}

	@FXML private void addTMButtonPressed(ActionEvent actionEvent)
	{
		if (state.getProjectId() < 0){
			errorLabel.setText("Save project before adding team members");
		}
		else {
			viewHandler.openView("teamMember"); //how to make sure its a new team member window state
		}
	}

	@FXML private void removeTMButtonPressed(ActionEvent actionEvent)
	{
		TeamMemberViewModel tmv = teamMemberListTable.getSelectionModel().getSelectedItem();
		managementSystemModel.getProject(Integer.parseInt(idText.getText())).getTeamMemberList().removeTeamMember(tmv.getNameProperty());
		teamMemberListViewModel.update();
	}
}
