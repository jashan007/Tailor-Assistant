package workerdatabase;

public class ProductBean 
{
	String workername;
	String address;
	String city;
	String mobile;
	String experience;
	String specialist;
	String specializedfor;
	String status;
	String path;
	
	ProductBean()
	{}

	public ProductBean(String workername, String address, String city, String mobile, String experience,
			String specialist, String specializedfor, String status, String path) {
		super();
		this.workername = workername;
		this.address = address;
		this.city = city;
		this.mobile = mobile;
		this.experience = experience;
		this.specialist = specialist;
		this.specializedfor = specializedfor;
		this.status = status;
		this.path = path;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getSpecializedfor() {
		return specializedfor;
	}

	public void setSpecializedfor(String specializedfor) {
		this.specializedfor = specializedfor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
