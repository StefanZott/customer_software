package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainViewController {
	
	@FXML
    private BorderPane mainView;

    @FXML
    private Button firstButton;
    
    @FXML
    private Label testLbl;

    @FXML
    void buttonClick(ActionEvent event) {
    	System.out.println("IT WORKS");
    	testLbl.setText("click the first button");
    	
    	//this.clv = new CustomerListView();
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/CustomerListView.fxml"));
			mainView.getChildren().remove(mainView.getCenter());
			mainView.setCenter(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
