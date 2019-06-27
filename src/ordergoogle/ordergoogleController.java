package ordergoogle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import  ordergoogle.ProductBean;
import javafx.scene.control.TableView;

public class ordergoogleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker txtfromdate;

    @FXML
    private DatePicker txttodate;

    @FXML
    private TextField txtmobile;

    @FXML
    private ComboBox<String> comboworker;

    @FXML
    private ComboBox<String> combostatus;

    @FXML
    private RadioButton rdpending1;

    @FXML
    private ToggleGroup toggledate;

    @FXML
    private RadioButton rddone1;

    @FXML
    private RadioButton rdall1;

    @FXML
    private RadioButton rdall2;

    @FXML
    private ToggleGroup togglemobile;

    @FXML
    private RadioButton rdfinish2;

    @FXML
    private RadioButton rdpending2;
    
    @FXML
    private TableView<ProductBean> tableView1;

    ObservableList<ProductBean> list;
    @FXML
    void doexport(ActionEvent event) 
    {

    	try {
			writeExcel();
			System.out.println("Exported to excel..");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    public void writeExcel() throws Exception 
    {
        Writer writer = null;
        try {
        	FileChooser chooser=new FileChooser();
	    	
        	chooser.setTitle("Select Path:");
        	
        	chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*")
                    
                );
        	 File file=chooser.showSaveDialog(null);
        	String filePath=file.getAbsolutePath();
        	if(!(filePath.endsWith(".csv")||filePath.endsWith(".CSV")))
        	{
        		txtmobile.setText("file name should have .csv extension");
        		return;
        	}
        	 file = new File(filePath);
        	 
        	 
        	 
            writer = new BufferedWriter(new FileWriter(file));
            String text="order id,mobile,item,measurement,worker,quantity,price,total,current date,date of delivery,status\n";
            writer.write(text);
           
            for (ProductBean p : list)
            {
				text = p.getOrderid()+ "," + p.getMobile()+ "," + p.getItem()+ "," + p.getMeasurement()+ ","+ p.getWorker()+ "," + p.getQuantity()+ "," + p.getPrice()+","+p.getTotal()+","+p.getCurrentdate()+","+p.getDod()+","+p.getStatus()+ "\n";
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }
    
    
    String var2="";
    
    @FXML
    void dofetch1(ActionEvent event) 
    {
    	tableView1.getColumns().clear();
      	
        TableColumn<ProductBean, Integer> orderid=new TableColumn<ProductBean, Integer>("Order Id");
     	orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));//field name in bean
     	orderid.setMinWidth(100);
     	
    	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
    	mobile.setMinWidth(100);
    	
        TableColumn<ProductBean, String	> item=new TableColumn<ProductBean, String>("item");
    	item.setCellValueFactory(new PropertyValueFactory<>("item"));//field name in bean
    	item.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> measurement=new TableColumn<ProductBean, String>("Measurement");
      	measurement.setCellValueFactory(new PropertyValueFactory<>("measurement"));//field name in bean
      	measurement.setMinWidth(100);
    	
        TableColumn<ProductBean, String> worker=new TableColumn<ProductBean, String>("WORKER");
    	worker.setCellValueFactory(new PropertyValueFactory<>("worker"));//field name in bean
    	worker.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> quantity=new TableColumn<ProductBean, Integer>("QUANTITY");
    	  quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));//field name in bean
    	  quantity.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> price=new TableColumn<ProductBean, Integer>("PRICE");
    	  price.setCellValueFactory(new PropertyValueFactory<>("price"));//field name in bean
    	  price.setMinWidth(100);
    	 
    	  TableColumn<ProductBean, Integer> total=new TableColumn<ProductBean, Integer>("TOTAL");
    	  total.setCellValueFactory(new PropertyValueFactory<>("total"));//field name in bean
    	  total.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> currentdate=new TableColumn<ProductBean, String>("CURRENT DATE");
    	  currentdate.setCellValueFactory(new PropertyValueFactory<>("currentdate"));//field name in bean
    	  currentdate.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> dod=new TableColumn<ProductBean, String>("DATE OF DELIVERY");
    	  dod.setCellValueFactory(new PropertyValueFactory<>("dod"));//field name in bean
    	  dod.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> status=new TableColumn<ProductBean, Integer>("STATUS");
    	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
    	  status.setMinWidth(100);
    	
    	  tableView1.getColumns().addAll(orderid,mobile,item,measurement,worker,quantity,price,total,currentdate,dod,status);
          
    	
    	
    	  list=FXCollections.observableArrayList();
   	     
   	
   		
   		try {
   			  pst=con.prepareStatement("select * from order1 where currentdate between ? and ? and status=?");
   			LocalDate local1=txtfromdate.getValue();
   			LocalDate local2=txttodate.getValue();
   			  java.sql.Date Date1=java.sql.Date.valueOf(local1);
   			java.sql.Date Date2=java.sql.Date.valueOf(local2);
   			 
   			 
   			if(rddone1.isSelected())
   				{pst.setDate(1,Date1);
  			   pst.setDate(2, Date2);
   				pst.setString(3, "1");}
            else if(rdpending1.isSelected())
            	{pst.setDate(1,Date1);
   			   pst.setDate(2, Date2);
            	pst.setString(3, "0");
            	}
            else
            {
            	pst=con.prepareStatement("select * from order1 where currentdate between ? and ?");
            	 pst.setDate(1,Date1);
       			 pst.setDate(2, Date2);
            }
   			ResultSet rs=  pst.executeQuery();
   			   while(rs.next())
   		     	   {
   				int orderid1=rs.getInt("orderid");
   			    String mobile1=rs.getString("mobile");
				String item1=rs.getString("item");
				String measurement1=rs.getString("measurement");
				String worker1=rs.getString("worker");
				int quantity1=rs.getInt("quantity");
				int price1=rs.getInt("price");
				int total1=rs.getInt("total");
				Date currentdate1=rs.getDate("currentdate");
   				String cdate=currentdate1.toString();
   				Date dod1=rs.getDate("dod");
   				String ddate=dod1.toString();
   				String status1=rs.getString("status");
   				ProductBean bean=new ProductBean(orderid1,mobile1,item1,measurement1,worker1,quantity1,price1,total1,cdate,ddate,status1);
				list.add(bean);
                 }  
   		     }
   			catch (SQLException e) 
   	   		{
   	   		
   	   			e.printStackTrace();
   	   		}
   	   		
   		tableView1.setItems(list);
    }
    String var="";
    @FXML
    void dofetch2(ActionEvent event) 
    {
         tableView1.getColumns().clear();
    	
        TableColumn<ProductBean, Integer> orderid=new TableColumn<ProductBean, Integer>("Order Id");
     	orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));//field name in bean
     	orderid.setMinWidth(100);
     	
    	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
    	mobile.setMinWidth(100);
    	
        TableColumn<ProductBean, String	> item=new TableColumn<ProductBean, String>("item");
    	item.setCellValueFactory(new PropertyValueFactory<>("item"));//field name in bean
    	item.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> measurement=new TableColumn<ProductBean, String>("Measurement");
      	measurement.setCellValueFactory(new PropertyValueFactory<>("measurement"));//field name in bean
      	measurement.setMinWidth(100);
    	
        TableColumn<ProductBean, String> worker=new TableColumn<ProductBean, String>("WORKER");
    	worker.setCellValueFactory(new PropertyValueFactory<>("worker"));//field name in bean
    	worker.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> quantity=new TableColumn<ProductBean, Integer>("QUANTITY");
    	  quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));//field name in bean
    	  quantity.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> price=new TableColumn<ProductBean, Integer>("PRICE");
    	  price.setCellValueFactory(new PropertyValueFactory<>("price"));//field name in bean
    	  price.setMinWidth(100);
    	 
    	  TableColumn<ProductBean, Integer> total=new TableColumn<ProductBean, Integer>("TOTAL");
    	  total.setCellValueFactory(new PropertyValueFactory<>("total"));//field name in bean
    	  total.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> currentdate=new TableColumn<ProductBean, String>("CURRENT DATE");
    	  currentdate.setCellValueFactory(new PropertyValueFactory<>("currentdate"));//field name in bean
    	  currentdate.setMinWidth(100);
    	
    	  TableColumn<ProductBean, String> dod=new TableColumn<ProductBean, String>("DATE OF DELIVERY");
    	  dod.setCellValueFactory(new PropertyValueFactory<>("dod"));//field name in bean
    	  dod.setMinWidth(100);
    	
    	  TableColumn<ProductBean, Integer> status=new TableColumn<ProductBean, Integer>("STATUS");
    	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
    	  status.setMinWidth(100);
    	
    	  tableView1.getColumns().addAll(orderid,mobile,item,measurement,worker,quantity,price,total,currentdate,dod,status);
    	   
    	
    	 list=FXCollections.observableArrayList();

     	System.out.println(list.size());
     	
   		
   		try {  
   			
   			  pst=con.prepareStatement("select * from order1 where mobile=? and status=?");
   			String mob=txtmobile.getText();
   			  pst.setString(1, mob);
   			if(rdfinish2.isSelected())
   				pst.setString(2, "0");
     	   else if(rdpending2.isSelected())
     		  pst.setString(2, "1");
     	   else
     	   {
     		   pst=con.prepareStatement("select * from order1 where mobile=?");
     		  pst.setString(1, mob);
     	   }
   			  
   			ResultSet rs=  pst.executeQuery();
   			while(rs.next())
   		     	{
   				int orderid1=rs.getInt("orderid");
   				
				String mobile1=rs.getString("mobile");
				String item1=rs.getString("item");
				String measurement1=rs.getString("measurement");
				String worker1=rs.getString("worker");
				int quantity1=rs.getInt("quantity");
				int price1=rs.getInt("price");
				int total1=rs.getInt("total");
				Date currentdate1=rs.getDate("currentdate");
   				String cdate=currentdate1.toString();
   				Date dod1=rs.getDate("dod");
   				String ddate=dod1.toString();
   				String status1=rs.getString("status");
   				ProductBean bean=new ProductBean(orderid1,mobile1,item1,measurement1,worker1,quantity1,price1,total1,cdate,ddate,status1);
				list.add(bean);
				System.out.println(mobile);
				}

   			
   			
   			} 
   		catch (SQLException e) 
   		{
   		
   			e.printStackTrace();
   		}
   		
   		tableView1.setItems(list);
    }

    @FXML
    void dofetch3(ActionEvent event) 
    {
    	 tableView1.getColumns().clear();
     	
         TableColumn<ProductBean, Integer> orderid=new TableColumn<ProductBean, Integer>("Order Id");
      	orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));//field name in bean
      	orderid.setMinWidth(100);
      	
     	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("Mobile");
     	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
     	mobile.setMinWidth(100);
     	
         TableColumn<ProductBean, String	> item=new TableColumn<ProductBean, String>("item");
     	item.setCellValueFactory(new PropertyValueFactory<>("item"));//field name in bean
     	item.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> measurement=new TableColumn<ProductBean, String>("Measurement");
       	measurement.setCellValueFactory(new PropertyValueFactory<>("measurement"));//field name in bean
       	measurement.setMinWidth(100);
     	
         TableColumn<ProductBean, String> worker=new TableColumn<ProductBean, String>("WORKER");
     	worker.setCellValueFactory(new PropertyValueFactory<>("worker"));//field name in bean
     	worker.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> quantity=new TableColumn<ProductBean, Integer>("QUANTITY");
     	  quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));//field name in bean
     	  quantity.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> price=new TableColumn<ProductBean, Integer>("PRICE");
     	  price.setCellValueFactory(new PropertyValueFactory<>("price"));//field name in bean
     	  price.setMinWidth(100);
     	 
     	  TableColumn<ProductBean, Integer> total=new TableColumn<ProductBean, Integer>("TOTAL");
     	  total.setCellValueFactory(new PropertyValueFactory<>("total"));//field name in bean
     	  total.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> currentdate=new TableColumn<ProductBean, String>("CURRENT DATE");
     	  currentdate.setCellValueFactory(new PropertyValueFactory<>("currentdate"));//field name in bean
     	  currentdate.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> dod=new TableColumn<ProductBean, String>("DATE OF DELIVERY");
     	  dod.setCellValueFactory(new PropertyValueFactory<>("dod"));//field name in bean
     	  dod.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> status=new TableColumn<ProductBean, Integer>("STATUS");
     	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
     	  status.setMinWidth(100);
     	
     	  tableView1.getColumns().addAll(orderid,mobile,item,measurement,worker,quantity,price,total,currentdate,dod,status);
     	 list=FXCollections.observableArrayList();

     	
     	System.out.println(list.size());
     	
    
    		try {  
    			
    			  pst=con.prepareStatement("select * from order1 where worker=?");
    			  String wor=comboworker.getValue();
    			  pst.setString(1, wor);
    			ResultSet rs=  pst.executeQuery();
    			while(rs.next())
    		     	{
    				int orderid1=rs.getInt("orderid");
    				
 				String mobile1=rs.getString("mobile");
 				String item1=rs.getString("item");
 				String measurement1=rs.getString("measurement");
 				String worker1=rs.getString("worker");
 				int quantity1=rs.getInt("quantity");
 				int price1=rs.getInt("price");
 				int total1=rs.getInt("total");
 				Date currentdate1=rs.getDate("currentdate");
    				String cdate=currentdate1.toString();
    				Date dod1=rs.getDate("dod");
    				String ddate=dod1.toString();
    				String status1=rs.getString("status");
    				ProductBean bean=new ProductBean(orderid1,mobile1,item1,measurement1,worker1,quantity1,price1,total1,cdate,ddate,status1);
 				list.add(bean);
 				System.out.println(mobile);
 				     }
    			}
    			catch (SQLException e) 
    	   		{
    	   		
    	   			e.printStackTrace();
    	   		}
    	   		
    		tableView1.setItems(list);
    }

    @FXML
    void doshowall(ActionEvent event) 
    {
    	 tableView1.getColumns().clear();
      	
         TableColumn<ProductBean, Integer> orderid=new TableColumn<ProductBean, Integer>("Order Id");
      	orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));//field name in bean
      	orderid.setMinWidth(100);
      	
     	TableColumn<ProductBean, String> mobile=new TableColumn<ProductBean, String>("Mobile");
     	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
     	mobile.setMinWidth(100);
     	
         TableColumn<ProductBean, String	> item=new TableColumn<ProductBean, String>("item");
     	item.setCellValueFactory(new PropertyValueFactory<>("item"));//field name in bean
     	item.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> measurement=new TableColumn<ProductBean, String>("Measurement");
       	measurement.setCellValueFactory(new PropertyValueFactory<>("measurement"));//field name in bean
       	measurement.setMinWidth(100);
     	
         TableColumn<ProductBean, String> worker=new TableColumn<ProductBean, String>("WORKER");
     	worker.setCellValueFactory(new PropertyValueFactory<>("worker"));//field name in bean
     	worker.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> quantity=new TableColumn<ProductBean, Integer>("QUANTITY");
     	  quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));//field name in bean
     	  quantity.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> price=new TableColumn<ProductBean, Integer>("PRICE");
     	  price.setCellValueFactory(new PropertyValueFactory<>("price"));//field name in bean
     	  price.setMinWidth(100);
     	 
     	  TableColumn<ProductBean, Integer> total=new TableColumn<ProductBean, Integer>("TOTAL");
     	  total.setCellValueFactory(new PropertyValueFactory<>("total"));//field name in bean
     	  total.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> currentdate=new TableColumn<ProductBean, String>("CURRENT DATE");
     	  currentdate.setCellValueFactory(new PropertyValueFactory<>("currentdate"));//field name in bean
     	  currentdate.setMinWidth(100);
     	
     	  TableColumn<ProductBean, String> dod=new TableColumn<ProductBean, String>("DATE OF DELIVERY");
     	  dod.setCellValueFactory(new PropertyValueFactory<>("dod"));//field name in bean
     	  dod.setMinWidth(100);
     	
     	  TableColumn<ProductBean, Integer> status=new TableColumn<ProductBean, Integer>("STATUS");
     	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
     	  status.setMinWidth(100);
     	
     	  tableView1.getColumns().addAll(orderid,mobile,item,measurement,worker,quantity,price,total,currentdate,dod,status);
     	 
     	
     	
     	
     	 list=FXCollections.observableArrayList();
     	
    		try {  
    			
    			  pst=con.prepareStatement("select * from order1");
    			  
    			ResultSet rs=  pst.executeQuery();
    			while(rs.next())
    		     	{
    				int orderid1=rs.getInt("orderid");
    				
 				String mobile1=rs.getString("mobile");
 				String item1=rs.getString("item");
 				String measurement1=rs.getString("measurement");
 				String worker1=rs.getString("worker");
 				int quantity1=rs.getInt("quantity");
 				int price1=rs.getInt("price");
 				int total1=rs.getInt("total");
 				Date currentdate1=rs.getDate("currentdate");
    				String cdate=currentdate1.toString();
    				Date dod1=rs.getDate("dod");
    				String ddate=dod1.toString();
    				String status1=rs.getString("status");
    				ProductBean bean=new ProductBean(orderid1,mobile1,item1,measurement1,worker1,quantity1,price1,total1,cdate,ddate,status1);
 				list.add(bean);
 				System.out.println(mobile);
 				     }
    			}
    			catch (SQLException e) 
    	   		{
    	   		
    	   			e.printStackTrace();
    	   		}
    	   		
    		tableView1.setItems(list);
    }

    @FXML
    void selectworker(ActionEvent event) 
    {
    	try {  
   			
   		       
   			  pst=con.prepareStatement("select * from order1 where worker=?");
   			  pst.setString(1, comboworker.getSelectionModel().getSelectedItem());
   			
   			ResultSet rs=  pst.executeQuery();
   			while(rs.next())
   	    	{
   	    	  String s=rs.getString("status");
   	    	  if(s.equals("0"))
   	    		  combostatus.getSelectionModel().select(1);
   	    	  else if(s.equals("1"))
   	    	  {
   	    		  combostatus.getSelectionModel().select(0);
   	    	  }
   	    	}
   		   }
    	
    	catch (SQLException e) 
   		{
   		   e.printStackTrace();
   		}
    }

    
    Connection con;
    PreparedStatement pst;
    void doConnection()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/javatailorproject","root","jashan");
			System.out.println("Connected");
			
    	}
      catch (ClassNotFoundException | SQLException e) 
		{
    	    System.out.println("Not connected");
			e.printStackTrace();
		}
    	
    }
    @FXML
    void initialize() {
    	 doConnection();
    	 ArrayList<String>items1=new ArrayList<>(Arrays.asList("select","chaman","harpreet","jashan","john","johnny","raman","yoy"));
         comboworker.getItems().addAll(items1);
         comboworker.getSelectionModel().select(0);
         ArrayList<String>items2=new ArrayList<>(Arrays.asList("stitched","Unstitched"));
         combostatus.getItems().addAll(items2);
        
    	 
    }
}
