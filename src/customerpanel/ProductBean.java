package customerpanel;

public class ProductBean 
{
	String mobile;
	String name;
	String address;
	String city;
	String gender;
	
	ProductBean()
	{}

	public ProductBean(String mobile, String name, String address, String city, String gender) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.address = address;
		this.city = city;
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
