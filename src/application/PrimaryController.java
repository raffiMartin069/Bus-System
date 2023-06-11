package application;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class PrimaryController implements Initializable {

	private Parent root;
	private Scene scene;
	private Stage stage;
    
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

	@FXML
    void LoginAccount(ActionEvent event) throws IOException {
	 root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 scene = new Scene(root);
	 stage.setScene(scene);
	 stage.show();
    }

    @FXML
    void proceedSignUp(ActionEvent event) throws IOException{
   	 root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
   	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	 scene = new Scene(root);
   	 stage.setScene(scene);
   	 stage.show();
    }
}
