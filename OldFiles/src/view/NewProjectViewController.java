package view;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class NewProjectViewController {
	@FXML private TextField customer;
	@FXML private TextArea description;
	@FXML private DatePicker deadline;
	@FXML private Button requirements, save, home, cancel;
	@FXML private Label errorLabel, descriptionLabel, deadlineLabel, customerLabel;
	private Region root;
	private ViewHandler viewHandler;
	private ManagementSystemModel managementSystemModel;
	private ViewState state;


	public NewProjectViewController() {

	}

	public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
		this.viewHandler = viewHandler;
		this.managementSystemModel = model;
		this.root = root;
		errorLabel.setText("");
	}

	public void reset() {
		description.setText("");
		errorLabel.setText("");
		customer.setText("");
	}

	public Region getRoot() {
		return root;
	}

	@FXML private void cancelButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void saveButtonPressed() {
		//try and catch exceptions base on if any field is missing,
		// written name is not accepted or if deadline is before today or
		//not far enough into the future

		LocalDate dl = deadline.getValue();
		//errorLabel.setText(dl.getDayOfMonth()+"/"+dl.getMonthValue()+"/"+dl.getYear());
		Project tmp = new Project(new Customer(customer.getText()),
				new MyDate(dl.getDayOfMonth(),dl.getMonthValue(),dl.getYear()),
				description.getText());
		int prjId = tmp.getId();
		managementSystemModel.addProject(tmp);
		managementSystemModel.saveToFile();
		viewHandler.openView("project");
	}

	@FXML private void customerNameTyped(){
		if (customer.getText().split(" ").length !=2){
			errorLabel.setText("Customer name must be in the form off \"Name Surname\"");
		}
		else{
			errorLabel.setText("");
		}
	}

	@FXML private void homeButtonPressed() {
		viewHandler.openView("home");
	}

	@FXML private void requirementsButtonPressed() {
		//requirement list for what project??? pass id??? how???
		viewHandler.openView("requirementList");
	}
}
