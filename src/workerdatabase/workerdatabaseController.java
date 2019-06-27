package workerdatabase;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import workerdatabase.ProductBean;

public class workerdatabaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboname;

    @FXML
    private RadioButton rdworking;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton rdleft;

    @FXML
    private TableView<ProductBean> tableView1;

    @FXML
    void dofetch(ActionEvent event) 
    {
      tableView1.getColumns().clear();
    	
    	TableColumn<ProductBean, String> wname=new TableColumn<ProductBean, String>("WORKER NAME");
    	wname.setCellValueFactory(new PropertyValueFactory<>("workername"));//field name in bean
    	wname.setMinWidth(100);
    	
    	TableColumn<ProductBean, String> address=new TableColumn<ProductBean, String>("ADDRESS");
    	address.setCellValueFactory(new PropertyValueFactory<>("address"));//field name in bean
    	address.setMinWidth(100);
    	
        TableColumn<ProductBean, String> city=new TableColumn<ProductBean, String>("CITY");
    	city.setCellValueFactory(new PropertyValueFactory<>("city"));//field name in bean
    	city.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("MOBILE");
      	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
      	mobile.setMinWidth(100);
    	
        TableColumn<ProductBean, String> experience=new TableColumn<ProductBean, String>("EXPERIENCE");
    	experience.setCellValueFactory(new PropertyValueFactory<>("experience"));//field name in bean
    	experience.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> specialist=new TableColumn<ProductBean, String>("SPECIALIST");
    	  specialist.setCellValueFactory(new PropertyValueFactory<>("specialist"));//field name in bean
    	  specialist.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> specializedfor=new TableColumn<ProductBean, String>("specializedfor");
    	  specializedfor.setCellValueFactory(new PropertyValueFactory<>("specializedfor"));//field name in bean
    	  specializedfor.setMinWidth(100);
    	 
    	  TableColumn<ProductBean, String> status=new TableColumn<ProductBean, String>("status");
    	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
    	  status.setMinWidth(100);
    	  
    	  TableColumn<ProductBean, String> path=new TableColumn<ProductBean, String>("path");
    	  path.setCellValueFactory(new PropertyValueFactory<>("path"));//field name in bean
    	  path.setMinWidth(100);
    	  
    	  tableView1.getColumns().addAll(wname,address,city,mobile,experience,specialist,specializedfor,status,path);
    	
    	ObservableList<ProductBean>list=getRecordsFromTable2(comboname.getValue());
    	System.out.println(list.size());
    	tableView1.setItems(list);
    	

    }
    ObservableList<ProductBean> getRecordsFromTable2(String name1)
   	{
   		ObservableList<ProductBean> list=FXCollections.observableArrayList();
   		
   		try {
   			  pst=con.prepareStatement("select * from worker where workername=?");
   			  pst.setString(1, name1);
   			ResultSet rs=  pst.executeQuery();
   			while(rs.next())
   			{
   				String workername=rs.getString("workername");
   				String address=rs.getString("address");
   				String city=rs.getString("city");
   				String mobile=rs.getString("mobile");
   				String experience=rs.getString("experience");
   				String specialist=rs.getString("specialist");
   				String specializedfor=rs.getString("specializedfor");
   				String status=rs.getString("status");
   				String path=rs.getString("path");
   				ProductBean bean=new ProductBean(workername,address,city,mobile,experience,specialist,specializedfor,status,path);
   				list.add(bean);
   				System.out.println(workername);
   				
   				
   				
   			}
   			
   			} 
   		catch (SQLException e) 
   		{
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		return list;
   	}
    @FXML
    void dofill(ActionEvent event) {

    }

    String var="";
    @FXML
    void doinfo(ActionEvent event) 
    {
     tableView1.getColumns().clear();
    	
    	TableColumn<ProductBean, String> wname=new TableColumn<ProductBean, String>("WORKER NAME");
    	wname.setCellValueFactory(new PropertyValueFactory<>("workername"));//field name in bean
    	wname.setMinWidth(100);
    	
    	TableColumn<ProductBean, String> address=new TableColumn<ProductBean, String>("ADDRESS");
    	address.setCellValueFactory(new PropertyValueFactory<>("address"));//field name in bean
    	address.setMinWidth(100);
    	
        TableColumn<ProductBean, String> city=new TableColumn<ProductBean, String>("CITY");
    	city.setCellValueFactory(new PropertyValueFactory<>("city"));//field name in bean
    	city.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("MOBILE");
      	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
      	mobile.setMinWidth(100);
    	
        TableColumn<ProductBean, String> experience=new TableColumn<ProductBean, String>("EXPERIENCE");
    	experience.setCellValueFactory(new PropertyValueFactory<>("experience"));//field name in bean
    	experience.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> specialist=new TableColumn<ProductBean, String>("SPECIALIST");
    	  specialist.setCellValueFactory(new PropertyValueFactory<>("specialist"));//field name in bean
    	  specialist.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> specializedfor=new TableColumn<ProductBean, String>("specializedfor");
    	  specializedfor.setCellValueFactory(new PropertyValueFactory<>("specializedfor"));//field name in bean
    	  specializedfor.setMinWidth(100);
    	 
    	 
    	  
    	  tableView1.getColumns().addAll(wname,address,city,mobile,experience,specialist,specializedfor);
    	   
    	  if(rdworking.isSelected())
    	  { var="working";}
    	  else if(rdleft.isSelected())
    	  {var="left";}
    	ObservableList<ProductBean>list=getRecordsFromTable3(var);
    	System.out.println(list.size());
    	tableView1.setItems(list);
    }
    ObservableList<ProductBean> getRecordsFromTable3(String status1)
   	{
   		ObservableList<ProductBean> list=FXCollections.observableArrayList();
   		
   		try {
   			  pst=con.prepareStatement("select * from worker where status=?");
   			  pst.setString(1, status1);
   			ResultSet rs=  pst.executeQuery();
   			while(rs.next())
   			{
   				String workername=rs.getString("workername");
				String address=rs.getString("address");
				String city=rs.getString("city");
				String mobile=rs.getString("mobile");
				String experience=rs.getString("experience");
				String specialist=rs.getString("specialist");
				String specializedfor=rs.getString("specializedfor");
				
				ProductBean bean=new ProductBean(workername,address,city,mobile,experience,specialist,specializedfor,"","");
				list.add(bean);
				System.out.println(workername);
   				
   				
   			}
   			
   			} 
   		catch (SQLException e) 
   		{
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		return list;
   	}
    
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
    void initialize() {
      doConnect();
      ArrayList<String> ary=new ArrayList<String>(Arrays.asList("select","chaman","harpreet","jashan","john","johny","raman","yoy"));
      comboname.getItems().addAll(ary);
      comboname.getSelectionModel().select(0);
    }
}
