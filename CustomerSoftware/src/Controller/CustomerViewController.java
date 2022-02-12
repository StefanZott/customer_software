package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Model.Customer;
import Model.Database;

public class CustomerViewController {
	
	@FXML
    private Label customerID;

    @FXML
    private Label email;

    @FXML
    private Label firstname;

    @FXML
    private Label houseNumber;

    @FXML
    private Label lastname;

    @FXML
    private Label place;

    @FXML
    private Label postCode;

    @FXML
    private Label street;

	private Database db;
	private ObservableList<Customer> customerList;

	public void initialize(int customerIDFromListView) {
		this.db = new Database();
		
		try {
			this.customerList = FXCollections.observableArrayList();
			this.customerList = db.getAllCustomer();
			
			
			for (Customer customer : customerList) {
				if(customer.getCustomerID() == customerIDFromListView) {
					this.customerID.setText(String.valueOf(customer.getCustomerID()));
					this.firstname.setText(customer.getFirstName());
					this.lastname.setText(customer.getLastName());
					this.street.setText(customer.getStreet());
					this.houseNumber.setText(String.valueOf(customer.getHouseNumber()));
					this.postCode.setText(String.valueOf(customer.getPostCode()));
					this.place.setText(customer.getPlace());
					this.email.setText(customer.getEmail());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
