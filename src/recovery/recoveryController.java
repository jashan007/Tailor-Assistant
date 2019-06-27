package recovery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class recoveryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtmobile;


    @FXML
    void docancel(ActionEvent event) {
    	System.exit(0);

    }
    String m="";
    @FXML
    void dosend(ActionEvent event)
    {
    	m=txtmobile.getText();
         
    	
    	String resp=SST_SMS.bceSunSoftSend(m, "hey");
    	System.out.println(resp);
    	
    	if(resp.indexOf("Exception")!=-1)
    		System.out.println("Check Internet Connection");
    	
    	else
    		if(resp.indexOf("successfully")!=-1)
        		System.out.println("Sent");
    		else
    		System.out.println( "Invalid Number");
    }

    @FXML
    void initialize() {
        
    }
}
