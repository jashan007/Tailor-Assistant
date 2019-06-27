package worker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import tailor.data;
import javafx.scene.control.Label;
public class workerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtname;
    
    @FXML
    private TextField txtexperience;

    @FXML
    private RadioButton rdleft;

    @FXML
    private RadioButton rdworking;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ListView<String> listt;

    @FXML
    private ToggleGroup togglestatus;

    @FXML
    private TextField txtitem;

    
    @FXML
    private ImageView prev;
    
    Connection con;
    PreparedStatement pst;
    void doConnection()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/javatailorproject",data.uid,data.pwd);
			System.out.println("Connected");
			
    	}
      catch (ClassNotFoundException | SQLException e) 
		{
    	    System.out.println("Not connected");
			e.printStackTrace();
		}
    	
    }
    void showAlert(String msg)
	{
		Alert alert=new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Status");
		alert.setContentText(msg);
		alert.show();

	}

    String picpath="";

    @FXML
    void dobrowse(ActionEvent event)
    {
    	FileChooser fc=new FileChooser();
    	fc.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
                );
    		File file=fc.showOpenDialog(null);
    		picpath=file.getAbsolutePath();
    		System.out.println(picpath);
    		try {
				prev.setImage(new Image(new FileInputStream(file)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    @FXML
    void dodelete(ActionEvent event) {
    	try {
         	 //?: in parameters
     		pst=con.prepareStatement("delete from worker where workername=?");//prepare query
     		pst.setString(1,txtname.getText());//fill data
     		
     		int count=pst.executeUpdate();//fire query-saving data in table
     		if(count!=0)
     		{
     		System.out.println("Record Deleted...");
 			showAlert("Record deleted");
     		}
     		else
     		{		System.out.println("Invalid id");
     		
     		}
     		
     		
     	} catch (SQLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}

    }

    @FXML
    void dofill1(ActionEvent event)
    {   	String item=combo1.getSelectionModel().getSelectedItem(); 
    	if(item.equals("Ladies"))
        {
    	listt.getItems().clear();
		listt.getItems().add("kamiz");
		listt.getItems().add("salwar");
		listt.getItems().add("top");
		listt.getItems().add("lehanga");
        }
		else
		{
			listt.getItems().clear();
			listt.getItems().add("pant");
			listt.getItems().add("shirt");
			listt.getItems().add("jeans");
			listt.getItems().add("kurta");
			listt.getItems().add("pajama");
		}
			
    }

    @FXML
    void dosave(ActionEvent event) 
    {
    	 try
         {   String c=combo1.getSelectionModel().getSelectedItem();
             String d=listt.getSelectionModel().getSelectedItem();
             
    		 if(c.equals("select")||d.equals("null"))  //throws null pointer exception to show alert
    		 {
    			 showAlert("select category from combo");
    			 
    		 }
    		 else{
         	pst=con.prepareStatement("insert into worker values(?,?,?,?,?,?,?,?,?)");
         	pst.setString(1,txtname.getText());
         	pst.setString(2,txtaddress.getText());
         	pst.setString(3,txtcity.getText());
         	pst.setString(4,txtmobile.getText());
         	pst.setString(5,txtexperience.getText());
         	pst.setString(6,combo1.getSelectionModel().getSelectedItem());
         	pst.setString(7, txtitem.getText());
         	String var;
         	if(rdworking.isSelected())
         		var="working";
         	else
         		var="left";
         	pst.setString(8,var);
         	pst.setString(9,picpath);
         	pst.executeUpdate();
         	System.out.println("inserted");
    		 }
    		 }
         catch(SQLException e)
         {
         	e.printStackTrace();
         }
    	 catch(NullPointerException ex)
    	 {
    		 showAlert("select item from listbox");
    	 }
    }
   String all="";
    @FXML
    void doChoose(MouseEvent event) 
    {
    	
         
    	int c=event.getClickCount();
    	if(c==2)
    	{
    		ObservableList<String> obi= listt.getSelectionModel().getSelectedItems();
    		
    		for(String str:obi)
    		{
    			all=all+str+",";
    			
    		}
    		
    		txtitem.setText(all);
    	}
    }


    @FXML
    void dosearch(ActionEvent event)
    {
    	try {
			pst=con.prepareStatement("select address,city,mobile,experience,specialist,specializedfor,status,path from worker where workername=?");
			pst.setString(1, txtname.getText());
			ResultSet rs=pst.executeQuery();
			
			boolean jasus=false;
			while(rs.next())
			{
				txtaddress.setText(rs.getString("address"));
				txtcity.setText(rs.getString("city"));
				txtmobile.setText(rs.getString("mobile"));
				
				txtexperience.setText(rs.getString("experience"));
				String s=rs.getString("specialist");
				
				if(s.equals("Ladies"))
				{
				combo1.getSelectionModel().select(1);
				}
				else{
				combo1.getSelectionModel().select(2);
				}
				txtitem.setText(rs.getString("specializedfor"));
				String r=rs.getString("status");
				
				if(r.equals("working"))
				{
					rdworking.setSelected(true);
				}
				else
				{
					rdleft.setSelected(true);
				}
				
				try {
					prev.setImage(new Image(new FileInputStream(rs.getString("path"))));
				}
				catch (FileNotFoundException e)
				{
					
					e.printStackTrace();
				}
				jasus=true;
			}
			
			if(jasus==false)
				{
				System.out.println("Invalid uid");
				
				}
		} 
    	catch (SQLException e) 
    	{
			
			e.printStackTrace();
		}
    	
    }

    @FXML
    void doupdate(ActionEvent event)
    {
    	try {
        	 //?: in parameters
    		pst=con.prepareStatement("update worker set address=?, city=?,mobile=?,experience=?,status=?,path=?,specializedfor=? where workername=?");//prepare query
    		
    		pst.setString(8,txtname.getText());//fill data
    		
    		pst.setString(1, txtaddress.getText());
    		pst.setString(2, txtcity.getText());
    		pst.setString(3, txtmobile.getText());
            pst.setString(4, txtexperience.getText());
            String var;
         	if(rdworking.isSelected())
         		var="working";
         	else
         		var="left";
         	pst.setString(5,var);
         	 pst.setString(6,picpath);
         	pst.setString(7, txtitem.getText());
            int count=pst.executeUpdate();//fire query-saving data in table
    		  if(count!=0)
    		  {
    	   		System.out.println("Record updated...");
    	   	    
    		  }
    	   		else
    			{
    	   			System.out.println("Invalid id");
    	   		
    			}
    		 
    	   		
    		} 
   	catch (SQLException e)
   	{
    		
    		e.printStackTrace();
    	}
    }
    @FXML
    void donew(ActionEvent event)
    {
       txtname.setText("");
       txtaddress.setText("");
       txtcity.setText("");
       txtexperience.setText("");
       txtmobile.setText("");
       txtitem.setText("");
       combo1.getSelectionModel().select(0);
       listt.getItems().clear();
       all="";
    }

    @FXML
    void doclear(ActionEvent event)
    {
      all="";
      txtitem.setText("");
    }


    @FXML
    void rdleft(ActionEvent event) {

    }

    @FXML
    void rdworking(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	ArrayList<String>items=new ArrayList<>(Arrays.asList("select","Ladies","Gents"));
    	combo1.getItems().addAll(items);
    	combo1.getSelectionModel().select(0);
        doConnection();
    	listt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
