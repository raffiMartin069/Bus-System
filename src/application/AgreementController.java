package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class AgreementController  implements Initializable {

	Parent root;
	Scene scene;
	Stage stage;
	
	
    @FXML
    private Button Agree_bttn;

    @FXML
    private CheckBox agreementBox;

    @FXML
    private Button cancel_Bttn;

    @FXML
    void agree_toMenu(ActionEvent event) {
     try {
		root = FXMLLoader.load(getClass().getResource("LandingSite.fxml"));
	} catch (IOException e) {
		e.printStackTrace();
	}
 	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 	 scene = new Scene(root);
 	 stage.setScene(scene);
 	 stage.show();
     	 
     	 System.out.println("\nLanding Site Launched");
    }

    @FXML
    void cancel_toMenu(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Agree_bttn.setDisable(true); // Initially disable the button

		//We used lambda and is function.
	    agreementBox.setOnAction(event -> {
	        boolean isChecked = agreementBox.isSelected();
	        Agree_bttn.setDisable(!isChecked);
	    });
		
	}
}
