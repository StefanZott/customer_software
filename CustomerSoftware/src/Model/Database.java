package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
	
	public static final String DB_NAME = "customerDB.sqlite";
	public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\workspace\\CustomerSoftware\\src\\" + DB_NAME;	

	private Connection connection;
	
	public Database() {
		createConnection();
	}
	
	private void createConnection() {
		try {
			this.connection = DriverManager.getConnection(CONNECTION_STRING);
			
			if (this.connection != null) {
				System.out.println("Datenbank Verbindung wurde erstellt!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCustomerToDB() {
		try {
			Statement st = connection.createStatement();
			st.execute("");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Customer> getAllCustomer() throws Exception {
		ObservableList<Customer> list = FXCollections.observableArrayList();
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("SELECT * FROM customer_table");
		
		while(resultSet.next()) {
			int id = resultSet.getInt(1);
			String firstname = resultSet.getString(2);
			String lastname = resultSet.getString(3);
			String street = resultSet.getString(4);
			int houseNumber = resultSet.getInt(5);
			int postCode = resultSet.getInt(6);
			String place = resultSet.getString(7);
			String email = resultSet.getString(8);
			
			
			list.add(new Customer(id, firstname, lastname, street, houseNumber, postCode,
					place, email));
		}
		
		st.close();
		
		return list;
	}
	
}
