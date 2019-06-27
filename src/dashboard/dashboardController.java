package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void customerpanel(MouseEvent event) {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("customerpanel/customerpanel.fxml")); 
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

    @FXML
    void measurement(MouseEvent event) {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("measurement/order.fxml")); 
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

    @FXML
    void orderdelivery(MouseEvent event) {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("orderdelivery/orderdelivery.fxml")); 
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

    @FXML
    void ordergoogle(MouseEvent event) {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("ordergoogle/ordergoogle.fxml")); 
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

    @FXML
    void tailor(MouseEvent event) 
    {
            try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("tailor/tailor.fxml")); 
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

    @FXML
    void worker(MouseEvent event) 
    {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("worker/worker.fxml")); 
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

    @FXML
    void workerdatabase(MouseEvent event) 
    {
        try{
    		
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("workerdatabase/workerdatabase.fxml")); 
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

    @FXML
    void about(MouseEvent event) 
    {
    	try{
    		
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("about/about.fxml")); 
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
    @FXML
    void initialize() {

    }
}
