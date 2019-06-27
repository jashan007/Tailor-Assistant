package tailor;

import java.net.URL;
import javafx.scene.image.ImageView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.MotionBlurBuilder;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class tailorController {

	@FXML
	private ImageView picmobile;

	@FXML
	private ImageView picname;

	@FXML
	private ImageView picaddress;

	@FXML
	private ImageView piccity;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtmobile;

	@FXML
	private TextField txtname;

	@FXML
	private TextField txtaddress;

	@FXML
	private TextField txtcity;

	@FXML
	private RadioButton rdmale;

	@FXML
	private ToggleGroup gender;

	@FXML
	private RadioButton rdfemale;
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

	@FXML
	void doclose(ActionEvent event) 
	{
		System.exit(0); 	

	}

	@FXML
	void dofetch(ActionEvent event) 
	{
		try
		{
			pst=con.prepareStatement("select name,address,city,gender from customerprofile where mobile=?");
			pst.setString(1,txtmobile.getText());
			ResultSet rs=pst.executeQuery();
			boolean jasus=false;
			while(rs.next())
			{ 
				txtname.setText(rs.getString("name"));
				txtaddress.setText(rs.getString("address"));
				txtcity.setText(rs.getString("city"));
				String s=rs.getString("gender");
				if(s.equals("male"))
				{
					rdmale.setSelected(true);
				}
				if(s.equals("female"))
				{
					rdfemale.setSelected(true);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void donew(ActionEvent event) 
	{
		txtmobile.setText("");
		txtname.setText("");
		txtaddress.setText("");
		txtcity.setText("");
		rdmale.setSelected(false);
		rdfemale.setSelected(false);
	}
   
	
	@FXML
	void dosave(ActionEvent event)
	{
		try
		{
			 boolean rd1;
			 boolean rd2;
				
			rd1=rdfemale.isSelected();
			rd2=rdmale.isSelected();
			String r1=String.valueOf(rd1);
			String r2=String.valueOf(rd2);
			
			if(txtmobile.getText().equals("")||txtname.getText().equals("")||txtaddress.getText().equals("")||txtcity.getText().equals(""))
			{ 
				showAlert("Data error");
			}
			else if(r1.equals("false")&&r2.equals("false"))
			{
			   	showAlert("selection error");
			}
			else{
				pst=con.prepareStatement("insert into customerprofile values(?,?,?,?,?)");
				pst.setString(1,txtmobile.getText());
				pst.setString(2,txtname.getText());
				pst.setString(3,txtaddress.getText());
				pst.setString(4,txtcity.getText() );
				String var;
				if(rdmale.isSelected())
					var="male";
				else
					var="female";
				pst.setString(5,var);
				pst.executeUpdate();
				System.out.println("inserted");
				showAlert("Record inserted");}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void doupdate(ActionEvent event) 
	{
		try {
			//?: in parameters
			pst=con.prepareStatement("update customerprofile set name=?, address=?, city=? where mobile=?");//prepare query

			pst.setString(4,txtmobile.getText());//fill data

			pst.setString(1, txtname.getText());
			pst.setString(2, txtaddress.getText());
			pst.setString(3, txtcity.getText());
			int count=pst.executeUpdate();//fire query-saving data in table
			if(count!=0)
			{
				System.out.println("Record updated...");
                showAlert("Record updated");
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

	void showAlert(String msg)
	{
		Alert alert=new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Status");
		alert.setContentText(msg);
		alert.show();

	}
	@FXML
	void mob(KeyEvent event) 
	{
		/*if(txtmobile.getLength()<1)
		{
			picmobile.setVisible(true);
		}
		else
		{
			picmobile.setVisible(false);
		}*/
		String n=txtmobile.getText();
		if(n.equals(""))
		   picmobile.setVisible(true);
		else
			picmobile.setVisible(false);
        String regexp=("^[6-9]{1}[0-9]{9}$");
        if(n.matches(regexp))
        	picmobile.setVisible(false);
        else
        	picmobile.setVisible(true);
	}
	 

	    @FXML
	    void name(KeyEvent event) {
	    	if(txtname.getLength()<1)
			{
				picname.setVisible(true);
			}
			else
			{
				picname.setVisible(false);
			}

	    }

	    @FXML
	    void address(KeyEvent event) {
	    	if(txtaddress.getLength()<1)
			{
				picaddress.setVisible(true);
			}
			else
			{
				picaddress.setVisible(false);
			}

	    }

	    @FXML
	    void city(KeyEvent event) {
      	    	if(txtcity.getLength()<1)
			{
				piccity.setVisible(true);
			}
			else
			{
				piccity.setVisible(false);
			}
	    	


	    }
	
	@FXML
	void initialize() {
		doConnection();
		picmobile.setVisible(false);
		picaddress.setVisible(false);
		piccity.setVisible(false);
		picname.setVisible(false);

	}
}
