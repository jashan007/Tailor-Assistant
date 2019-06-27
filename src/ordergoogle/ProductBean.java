package ordergoogle;

public class ProductBean 
{
	int orderid;
	String mobile;
	String item;
	String measurement;
	String worker;
	int quantity;
	int price;
	int total;
	String currentdate;
	String dod;
	String status;
	
	ProductBean()
	{}

	public ProductBean(int orderid, String mobile, String item, String measurement, String worker, int quantity,
			int price, int total, String currentdate, String dod, String status) {
		super();
		this.orderid = orderid;
		this.mobile = mobile;
		this.item = item;
		this.measurement = measurement;
		this.worker = worker;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.currentdate = currentdate;
		this.dod = dod;
		this.status = status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	public String getDod() {
		return dod;
	}

	public void setDod(String dod) {
		this.dod = dod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
	
}
