package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtpwd;
    
  String pwd="";
    @FXML
    void dologin(ActionEvent event)
    { 
    	pwd=txtpwd.getText();
    	
    	if(pwd.equals("hey"))
    	{
    	   try{
    		
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("dashboard/dashboard.fxml")); 
    		Scene scene = new Scene(root);
    		
    		Stage stage=new Stage();

    		stage.setScene(scene);
    		
    		stage.show();

    		//to hide the opened window
    		 
    		  /* Scene scene1=(Scene)btnComboApp.getScene();
    		   scene1.getWindow().hide();*/
    		 

    	    }
    	    catch(Exception e)
    	    {
    		e.printStackTrace();
    	    }
    	}
      else
    	 {
    		    showAlert("invalid password");
         }
    }

    @FXML
    void forgot(ActionEvent event)
    {
try{
    		
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("recovery/recovery.fxml")); 
    		Scene scene = new Scene(root);
    		
    		Stage stage=new Stage();

    		stage.setScene(scene);
    		
    		stage.show();

    		//to hide the opened window
    		 
    		  /* Scene scene1=(Scene)btnComboApp.getScene();
    		   scene1.getWindow().hide();*/
    		 

    	    }
    	    catch(Exception e)
    	    {
    		e.printStackTrace();
    	    }
    }
    
    void showAlert(String msg)
   	{
   		Alert alert=new Alert(Alert.AlertType.WARNING);
   		alert.setHeaderText("status");
   		alert.setContentText(msg);
   		alert.show();
   	}
    @FXML
    void initialize() {
        
    }
}
