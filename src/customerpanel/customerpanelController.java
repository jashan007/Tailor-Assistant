package customerpanel;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import customerpanel.ProductBean;

public class customerpanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtmobile;

    @FXML
    private TableView<ProductBean> tableView1;

    Connection con;
	PreparedStatement pst;
	void doConnect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javatailorproject","root","jashan");
			System.out.println("Connection Est...");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
    
	@FXML
    void dofetch(ActionEvent event) 
	{
		  tableView1.getColumns().clear();
	    	
	    	System.out.println("fetching");
	    	
	    	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("Mobile no");
	    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
	    	mobile.setMinWidth(100);
	    	
	    	TableColumn<ProductBean, String> name=new TableColumn<ProductBean, String>("Name of customer");
	    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//field name in bean
	    	name.setMinWidth(100);
	    	
	    	
	    	TableColumn<ProductBean, String> address=new TableColumn<ProductBean, String>("Address");
	    	address.setCellValueFactory(new PropertyValueFactory<>("address"));//field name in bean
	    	address.setMinWidth(100);
	    	
	    	
	    	TableColumn<ProductBean, String> city=new TableColumn<ProductBean, String>("City");
	    	city.setCellValueFactory(new PropertyValueFactory<>("city"));//field name in bean
	    	city.setMinWidth(100);
	    	
	    	TableColumn<ProductBean, String> gender=new TableColumn<ProductBean, String>("Gender");
	    	gender.setCellValueFactory(new PropertyValueFactory<>("gender"));//field name in bean
	    	gender.setMinWidth(100);
	    	
	    	tableView1.getColumns().addAll(mobile,name,address,city,gender);
	    	
	    	ObservableList<ProductBean>list=getRecordsFromTable2(txtmobile.getText());
	    	System.out.println(list.size());
	    	tableView1.setItems(list);
	    	

 }
	    
	    ObservableList<ProductBean> getRecordsFromTable2(String mob)
	   	{
	   		ObservableList<ProductBean> list=FXCollections.observableArrayList();
	   		
	   		try 
	   		{
	   			  pst=con.prepareStatement("select * from customerprofile where mobile=?");
	   			  pst.setString(1, mob);
	   			ResultSet rs=  pst.executeQuery();
	   			while(rs.next())
	   			   {
	   				String mobile=rs.getString("mobile");
	   				String name=rs.getString("name");
	   				String address=rs.getString("address");
	   				String city=rs.getString("city");
	   				String gender=rs.getString("gender");
		   			
		   			ProductBean bean=new ProductBean(mobile, name, address, city,gender);
	   				list.add(bean);
	   				System.out.println(mobile);
	   				}
	   			
	   		} 
	   		catch (SQLException e) 
	   		{
	   			e.printStackTrace();
	   		}
	   		
	   		return list;
	   	}
	
    @FXML
    void doshowall(ActionEvent event)
    {
         tableView1.getColumns().clear();
    	
    	System.out.println("showing");
    	
    	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
    	mobile.setMinWidth(100);
    	
    	TableColumn<ProductBean, String> name=new TableColumn<ProductBean, String>("name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//field name in bean
    	name.setMinWidth(100);
    	
    	
    	TableColumn<ProductBean, String> address=new TableColumn<ProductBean, String>("address");
    	address.setCellValueFactory(new PropertyValueFactory<>("address"));//field name in bean
    	address.setMinWidth(100);
    	
    	
    	TableColumn<ProductBean, String> city=new TableColumn<ProductBean, String>("city");
    	city.setCellValueFactory(new PropertyValueFactory<>("city"));//field name in bean
    	city.setMinWidth(100);
    	
    	TableColumn<ProductBean, String> gender=new TableColumn<ProductBean, String>("gender");
    	gender.setCellValueFactory(new PropertyValueFactory<>("gender"));//field name in bean
    	gender.setMinWidth(100);
    	
    	tableView1.getColumns().addAll(mobile,name,address,city,gender);
    	
    	ObservableList<ProductBean>list=getRecordsFromTable();
    	System.out.println(list.size());
    	tableView1.setItems(list);
    	
    		
    }

    ObservableList<ProductBean> getRecordsFromTable()
   	{
   		ObservableList<ProductBean> list=FXCollections.observableArrayList();
   		
   		try 
   		{
   			  pst=con.prepareStatement("select * from customerprofile");
   			  
   			ResultSet rs=  pst.executeQuery();
   			while(rs.next())
   			{
   				String mobile=rs.getString("mobile");
   				
   				String name=rs.getString("name");
   				String address=rs.getString("address");
   				String city=rs.getString("city");
   				String gender=rs.getString("gender");
   				
   				ProductBean bean=new ProductBean(mobile,name,address,city,gender);
   				list.add(bean);
   				System.out.println(name);
             }
   			
   		} 
   		catch (SQLException e) 
   		{
   			e.printStackTrace();
   		}
   		
   		return list;
    }

    @FXML
    void initialize() 
    {
    	 doConnect();
    }
}
