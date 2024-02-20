package customer;

public class Customer {

	private String customerId;
	private String customerName;
	private String emailId;
	private long mobile_No;
	private String city;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(long mobile_No) {
		this.mobile_No = mobile_No;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Customer(String customerId, String customerName, String emailId, long mobile_No, String city) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobile_No = mobile_No;
		this.city = city;
	}
	
	public Customer() {
		super();
	}
	
	@Override
	public String toString() {
		return "\n Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", mobile_No=" + mobile_No + ", city=" + city + "]";
	}
	
	
}
