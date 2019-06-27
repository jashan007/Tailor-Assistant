package orderdelivery;

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
import orderdelivery.orderdeliveryBean;


public class orderdeliveryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<orderdeliveryBean> tableView;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtprice;

    ObservableList<orderdeliveryBean> list;
    
    @FXML
    void doclose(ActionEvent event) 
    {
            System.exit(0);
    }
   
    @FXML
    void dodeliver(ActionEvent event) 
    {
    	try 
    	{  
   			
    		pst=con.prepareStatement("update order1 set status=? where mobile=?");//prepare query
       		
       		pst.setString(2,txtmobile.getText());//fill data
       		
       		pst.setString(1, "1");
       	
       		   int count=pst.executeUpdate();//fire query-saving data in table
       		  if(count!=0)
       		    {
       	   		System.out.println("Record updated...");
       	        }
       	   		else
       			{
       	   			System.out.println("Invalid mobile");
       	   		}
    	    }
       		 catch (SQLException e)
        	   {
         		
         		e.printStackTrace();
         	   }
       		 
    }

    int total2=0;
    @FXML
    void dofetch(ActionEvent event) 
    {

   	 tableView.getColumns().clear();
     	
        TableColumn<orderdeliveryBean, Integer> orderid=new TableColumn<orderdeliveryBean, Integer>("Order Id");
     	orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));//field name in bean
     	orderid.setMinWidth(100);
     	
    	TableColumn<orderdeliveryBean, String> mobile=new TableColumn<orderdeliveryBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//field name in bean
    	mobile.setMinWidth(100);
    	
        TableColumn<orderdeliveryBean, String	> item=new TableColumn<orderdeliveryBean, String>("item");
    	item.setCellValueFactory(new PropertyValueFactory<>("item"));//field name in bean
    	item.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, String> measurement=new TableColumn<orderdeliveryBean, String>("Measurement");
      	measurement.setCellValueFactory(new PropertyValueFactory<>("measurement"));//field name in bean
      	measurement.setMinWidth(100);
    	
        TableColumn<orderdeliveryBean, String> worker=new TableColumn<orderdeliveryBean, String>("WORKER");
    	worker.setCellValueFactory(new PropertyValueFactory<>("worker"));//field name in bean
    	worker.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, Integer> quantity=new TableColumn<orderdeliveryBean, Integer>("QUANTITY");
    	  quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));//field name in bean
    	  quantity.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, Integer> price=new TableColumn<orderdeliveryBean, Integer>("PRICE");
    	  price.setCellValueFactory(new PropertyValueFactory<>("price"));//field name in bean
    	  price.setMinWidth(100);
    	 
    	  TableColumn<orderdeliveryBean, Integer> total=new TableColumn<orderdeliveryBean, Integer>("TOTAL");
    	  total.setCellValueFactory(new PropertyValueFactory<>("total"));//field name in bean
    	  total.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, String> currentdate=new TableColumn<orderdeliveryBean, String>("CURRENT DATE");
    	  currentdate.setCellValueFactory(new PropertyValueFactory<>("currentdate"));//field name in bean
    	  currentdate.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, String> dod=new TableColumn<orderdeliveryBean, String>("DATE OF DELIVERY");
    	  dod.setCellValueFactory(new PropertyValueFactory<>("dod"));//field name in bean
    	  dod.setMinWidth(100);
    	
    	  TableColumn<orderdeliveryBean, Integer> status=new TableColumn<orderdeliveryBean, Integer>("STATUS");
    	  status.setCellValueFactory(new PropertyValueFactory<>("status"));//field name in bean
    	  status.setMinWidth(100);
    	
    	  tableView.getColumns().addAll(orderid,mobile,item,measurement,worker,quantity,price,total,currentdate,dod,status);
    	 
    	
    	
    	
    	 list=FXCollections.observableArrayList();
    	
   		try {  
   			
   			  pst=con.prepareStatement("select * from order1 where mobile=? and status=0 and current_date>=dod");
   			  pst.setString(1, txtmobile.getText());
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
				total2=total2+total1;
				Date currentdate1=rs.getDate("currentdate");
   				String cdate=currentdate1.toString();
   				Date dod1=rs.getDate("dod");
   				String ddate=dod1.toString();
   				String status1=rs.getString("status");
   				orderdeliveryBean bean=new orderdeliveryBean(orderid1,mobile1,item1,measurement1,worker1,quantity1,price1,total1,cdate,ddate,status1);
				list.add(bean);
				System.out.println(mobile1);
				     }
   			}
   			catch (SQLException e) 
   	   		{
   	   		
   	   			e.printStackTrace();
   	   		}
   	   		
   		tableView.setItems(list);
   		
   		txtprice.setText(String.valueOf(total2));
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
    }
}
