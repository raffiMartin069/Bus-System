package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class DashboardController {
	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	@FXML
	private Button SignOut;

	// Event Listener on Button[#SignOut].onAction
	@FXML
    void LogOut(ActionEvent event) throws IOException{
   	 root = FXMLLoader.load(getClass().getResource("LandingSite.fxml"));
   	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	 scene = new Scene(root);
   	 stage.setScene(scene);
   	 stage.show();
    }
}
