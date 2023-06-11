package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpController implements Initializable{

	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField familyName;
	
	@FXML
	private DatePicker birthDate;
	
	@FXML
    private RadioButton button_Custom;

    @FXML
    private RadioButton button_Female;

    @FXML
    private RadioButton button_Male;
	
    @FXML
    private ToggleGroup GenderRadioButtons;

    @FXML
    private Button SignUpBack;

    @FXML
    private DatePicker birth_date;

    @FXML
    private Button createAccount;
    
    @FXML
    private ChoiceBox<String> country;
    
    ObservableList <String> country_Picker = FXCollections.observableArrayList(); 

    @FXML
    void BackButton(ActionEvent event) throws IOException{
     root = FXMLLoader.load(getClass().getResource("LandingSite.fxml"));
  	 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	 scene = new Scene(root);
  	 stage.setScene(scene);
  	 stage.show();
  	 
  	 System.out.println("\nLanding Site Launched");
    }

    @FXML
    void CreationDone(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("t&c.fxml"));
        Parent root = loader.load();
        
        Stage newStage = new Stage();
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        newStage.setTitle("On The Go Terms & Conditions");
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
        
        System.out.println("\nTerms and Conditions Launched");
    }
    
    private void fetchCountry() {     
    	country.setItems(Country.fetchCountryData());
    	System.out.println("\nCountry List Fetched");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       fetchCountry();
    }
}
