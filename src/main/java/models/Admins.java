package models;

public class Admins {

	private int adminID;
	private String adminName, password, phoneNumber, emailAddress, address;
	//constructors to initialize values
	public Admins(int adminID, String adminName, String password, String phoneNumber, String emailAddress,
			String address) {
		this.adminID = adminID;
		this.adminName = adminName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Admins(String adminName, String password, String phoneNumber, String emailAddress, String address) {
		this.adminName = adminName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Admins() {
		this.adminID = 0;
		this.adminName = "";
		this.password = "";
		this.phoneNumber = "";
		this.emailAddress = "";
		this.address = "";
	}
	
	
	//All getter and setter methods for all variables
	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admins [adminID=" + adminID + ", adminName=" + adminName + ",password=" + password + ",phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", address=" + address + "]";
	}

}