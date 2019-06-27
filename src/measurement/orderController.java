package measurement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import tailor.data;

public class orderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
  
    @FXML
    private TextField txtmobile;

    @FXML
    private ComboBox<String> comboitems;
    
    @FXML
    private ComboBox<String> combospecializedfor;

    @FXML
    private ListView<String> listt;

    @FXML
    private TextField txtquantity;

    @FXML
    private TextField txtdod;

    @FXML
    private TextField txttotal;

    @FXML
    private TextField txtprice;

    @FXML
    private TextArea txtmeasure;
    
    @FXML
    private DatePicker txtdate;

    void showalert(String msg)
   	{
   		Alert alert=new Alert(Alert.AlertType.WARNING);
   		alert.setHeaderText("status");
   		alert.setContentText(msg);
   		alert.show();
   	}
   
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

    
    String all="";
    int c=0;
    @FXML
    void dofillitems(ActionEvent event) 
      {
    	int index=comboitems.getSelectionModel().getSelectedIndex();
    	combospecializedfor.getSelectionModel().select(index);
      }
    
    @FXML
    void dofillspecializedfor(ActionEvent event) 
    {
    	try
        {
		   listt.getItems().clear();
    	   String s=combospecializedfor.getSelectionModel().getSelectedItem();
    	   pst=con.prepareStatement("select * from worker");
		   ResultSet rs=pst.executeQuery();
		   boolean jasus=false;
		      while(rs.next())
			    {
			    String r=rs.getString("specializedfor");
			    String arr[]=r.split(",");
				 for(String d:arr)
				   {
					 if(d.equals(s))
					     {
						 listt.getItems().add(rs.getString("workername"));
				     	 }
				 
				   }
			    
			    }
 	    }
 	    catch (SQLException e) 
     	{
 			
 			e.printStackTrace();
 		}
    	
    
    }
  
    

    String all1="";
    @FXML
    void doChoose(MouseEvent event)
    {
    		ObservableList<String> obi= listt.getSelectionModel().getSelectedItems();
    		for(String str:obi)
    		{
    			all1=str;
    			
    		}
    		
    }

  
   

    @FXML
    void dosave(ActionEvent event) 
    {

   	 try
        {
        	pst=con.prepareStatement("insert into order1(mobile,item,measurement,worker,quantity,price,total,dod,currentdate,status) values(?,?,?,?,?,?,?,?,current_date,0)");
        	
        	pst.setString(1, txtmobile.getText());
        	pst.setString(2,comboitems.getSelectionModel().getSelectedItem());
        	pst.setString(3, txtmeasure.getText());
        	pst.setString(4, all1);
        	pst.setInt(5,Integer.parseInt(txtquantity.getText()));
        	pst.setInt(6,Integer.parseInt(txtprice.getText()));
        	pst.setInt(7,Integer.parseInt(txttotal.getText()));
        	 LocalDate local=txtdate.getValue();
             java.sql.Date Date=java.sql.Date.valueOf(local);
             pst.setDate(8,Date);

        	pst.executeUpdate();
        	
        	pst=con.prepareStatement("select max(orderid) as orderid from order1");
        	ResultSet rs=pst.executeQuery();
        	if(rs.next())
        		showalert("Your order id is :"+(rs.getString("orderid")));
        	
        	pst=con.prepareStatement("insert into measurement values(?,?,?)");
        	pst.setString(1, txtmobile.getText());
        	pst.setString(2,comboitems.getSelectionModel().getSelectedItem());
        	pst.setString(3, txtmeasure.getText());
        	pst.executeUpdate();
        	
        	
        	System.out.println("Record inserted");
        	showalert("Record Inserted");
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
   	 }

   @FXML
    void dofetch(ActionEvent event) 
    { 
	   try
	   {
	    pst=con.prepareStatement("select item,measurement from measurement where mobile=?");
		pst.setString(1, txtmobile.getText());
		ResultSet rs=pst.executeQuery();
		
		boolean jasus=false;
		while(rs.next())
		{
			String j=rs.getString("item");
			if(j.equals("kamiz"))
				comboitems.getSelectionModel().select(1);
			else if(j.equals("salwar"))
				comboitems.getSelectionModel().select(2);
			else if(j.equals("top"))
				comboitems.getSelectionModel().select(3);
			else if(j.equals("lehanga"))
				comboitems.getSelectionModel().select(4);
			else if(j.equals("pant"))
				comboitems.getSelectionModel().select(5);
			else if(j.equals("shirt"))
				comboitems.getSelectionModel().select(6);
			else if(j.equals("jeans"))
				comboitems.getSelectionModel().select(7);
			else if(j.equals("kurta"))
				comboitems.getSelectionModel().select(8);
			else if(j.equals("pajama"))
				comboitems.getSelectionModel().select(9);
			
			txtmeasure.setText(rs.getString("measurement"));
			combospecializedfor.getSelectionModel().select(0);
			listt.getItems().clear();
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
   		pst=con.prepareStatement("update measurement set item=?, measurement=? where mobile=?");//prepare query
   		
   		pst.setString(3,txtmobile.getText());//fill data
   		
   		pst.setString(1, comboitems.getSelectionModel().getSelectedItem());
   		pst.setString(2, txtmeasure.getText());
   		   int count=pst.executeUpdate();//fire query-saving data in table
   		  if(count!=0)
   		  {
   	   		System.out.println("Record updated...");
   	   	showalert("Record updated");
   		  }
   	   		else
   			{
   	   			System.out.println("Invalid mobile");
   	   		showalert("Invalid mobile");
   	   		
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
      comboitems.getSelectionModel().select(0);
      combospecializedfor.getSelectionModel().select(0);
      listt.getItems().clear();
      txtmeasure.setText("");
      txtquantity.setText("");
      txtprice.setText("");
      txttotal.setText("");
     
    }

    @FXML
    void doclose(ActionEvent event)
    {
          System.exit(0);
    }

   

    
    @FXML
    void initialize() 
    {
        doConnection();
        ArrayList<String>items1=new ArrayList<>(Arrays.asList("select","kamiz","salwar","top","lehanga","pant","shirt","jeans","kurta","pajama"));
        comboitems.getItems().addAll(items1);
        comboitems.getSelectionModel().select(0);
        ArrayList<String>items2=new ArrayList<>(Arrays.asList("select","kamiz","salwar","top","lehanga","pant","shirt","jeans","kurta","pajama"));
        combospecializedfor.getItems().addAll(items2);
        combospecializedfor.getSelectionModel().select(0);
        listt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
