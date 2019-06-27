package dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application 
{
	@Override
 public void start(Stage primaryStage) 
   {
		
		
		
		
		try {
			
				Parent root=FXMLLoader.load(getClass().getResource("dashboard.fxml")); 
				//primaryStage.initStyle(StageStyle.TRANSPARENT);
				Scene scene = new Scene(root);
				//scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				//primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.show();
		    } 
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

