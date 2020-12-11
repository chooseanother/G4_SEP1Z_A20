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
	@FXML private  TableColumn<RequirementViewModel, Integer> idCollum;
	@FXML private  TableColumn<RequirementViewModel, String> statusCollum;
	@FXML private  TableColumn<RequirementViewModel, String> priorityCollum;
	@FXML private  TableView<TeamMemberViewModel> teamMemberListTable;
	@FXML private  TableColumn<TeamMemberViewModel, String> nameCollum;
	@FXML private  TableColumn<TeamMemberViewModel, String> roleCollum;

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
		System.out.println(state.getProjectId());
		if (state.getProjectId()<0){
			projectLabel.setText("New Project");
		}
		else{
			Project display = model.getProject(state.getProjectId());
			projectLabel.setText("Project");
			titleText.setText(display.getTitle());
			customerText.setText(display.getCustomer().toString());
			descriptionText.setText(display.getDescription());
			//how to set deadline? deadlineDate.
			progressText.setText(String.format("%.2f",display.getProgress())+"%");
			hoursSpentText.setText(display.getTotalHoursSpent()+"H");
			idText.setText(display.getId()+"");
		}
	}

	public void reset() {
		descriptionText.setText("");
		errorLabel.setText("");
		customerText.setText("");
		progressText.setText("");
		titleText.setText("");
		//how to reset date picker? deadlineDate.
		hoursSpentText.setText("");
		idText.setText("");
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
		if (state.getProjectId()==-1){
			Project tmp = new Project(titleText.getText(),new Customer(customerText.getText()),
					new MyDate(dl.getDayOfMonth(),dl.getMonthValue(),dl.getYear()),
					descriptionText.getText());
			state.setProjectId(tmp.getId());
			managementSystemModel.addProject(tmp);
			titleText.setText(tmp.getTitle());
		}
		else{
			managementSystemModel.getProject(state.getProjectId()).
					setTitle(titleText.getText());
			managementSystemModel.getProject(state.getProjectId()).
					setCustomer(new Customer(customerText.getText()));
			managementSystemModel.getProject(state.getProjectId()).
					setDescription(descriptionText.getText());
			managementSystemModel.getProject(state.getProjectId()).setDeadline(
					new MyDate(dl.getDayOfMonth(),dl.getMonthValue(),dl.getYear()));
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
		viewHandler.openView("requirementList");
	}

	@FXML private void tMDButtonPressed(ActionEvent actionEvent)
	{
	}

	@FXML private void addReqButtonPressed(ActionEvent actionEvent)
	{
	}

	@FXML private void removeReqButtonPressed(ActionEvent actionEvent)
	{
	}

	@FXML private void addTMButtonPressed(ActionEvent actionEvent)
	{
	}

	@FXML private void removeTMButtonPressed(ActionEvent actionEvent)
	{
	}
}
