package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import Model.*;

public class CustomerListViewController implements Initializable{

    @FXML
    private VBox customerListViewBox;
    
    @FXML
    private TableView<Customer> customerTableView;
    
    private Database db;
    private ObservableList<Customer> customerList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Beginn");
		
		db = new Database();
		
		
		try {
			customerList = db.getAllCustomer();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		customerListViewBox.setSpacing(10);
		customerListViewBox.setPadding(new Insets(10, 10, 0, 10));
		
		// Create Columns for the table
		TableColumn<Customer, String> customerIdCol = new TableColumn<Customer, String>("kdnr");
		customerIdCol.setMinWidth(35);
		customerIdCol.setMaxWidth(50);
		
		TableColumn<Customer, String> firstNameCol = new TableColumn<Customer, String>("Vorname");
		TableColumn<Customer, String> lastNameCol = new TableColumn<Customer, String>("Nachname");
		TableColumn<Customer, String> streetCol = new TableColumn<Customer, String>("Straﬂe");
		TableColumn<Customer, String> houseNumberCol = new TableColumn<Customer, String>("Hausnummer");
		TableColumn<Customer, String> postCodeCol = new TableColumn<Customer, String>("PLZ");
		TableColumn<Customer, String> placeCol = new TableColumn<Customer, String>("Ort");
		TableColumn<Customer, String> emailCol = new TableColumn<Customer, String>("E-Mail");
		TableColumn<Customer, String> editButtonCol = new TableColumn<Customer, String>("");
		
		Callback<TableColumn<Customer, String>, TableCell<Customer, String>> cellFactory = new Callback<TableColumn<Customer, String>, TableCell<Customer, String>>() {

			@Override
			public TableCell<Customer, String> call(TableColumn<Customer, String> arg0) {
				final TableCell<Customer, String> cell = new TableCell<Customer, String>() {

                    final Button btn = new Button("Bearbeiten");
                    
                    {
                        btn.setOnAction((ActionEvent event) -> {
                        	
                            
                            try {
                            	Customer customer = getTableView().getItems().get(getIndex());
                               
                            	FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/customerView.fxml"));
                    			Parent root = loader.load();
                    			CustomerViewController cvc = loader.getController();
                    			cvc.initialize(customer.getCustomerID());
                    			
                    			Stage stage = new Stage();
                    			stage.setScene(new Scene(root));
                    			stage.show();
                    		} catch(Exception e) {
                    			e.printStackTrace();
                    		}
                        });
                    }
                    
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                    
				};
				
				return cell;
			}
			
		};
		
		editButtonCol.setCellFactory(cellFactory);
		
		// Add the columns to table
		customerTableView.getColumns().addAll(customerIdCol, firstNameCol, lastNameCol, streetCol, houseNumberCol, postCodeCol, placeCol, emailCol, editButtonCol);
		
		
		// add Info in columns
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
		houseNumberCol.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
		postCodeCol.setCellValueFactory(new PropertyValueFactory<>("place"));
		placeCol.setCellValueFactory(new PropertyValueFactory<>("postCode"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		customerTableView.setItems(customerList);
		
		System.out.println("Ende");
		
	}
    
   

}