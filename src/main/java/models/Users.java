package models;

public class Users {

	private int userID;
	private String userName, password, phoneNumber, emailAddress, address;

	//constructors to initialize values
	
	public Users(int userID, String userName, String password, String phoneNumber, String emailAddress,
			String address) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Users(String userName, String password, String phoneNumber, String emailAddress, String address) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Users() {
		this.userID = 0;
		this.userName = "";
		this.password = "";
		this.phoneNumber = "";
		this.emailAddress = "";
		this.address = "";
	}
	
	//All getter and setter methods for all variables
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Users [userID=" + userID + ", userName=" + userName + ",password=" + password + ",phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", address=" + address + "]";
	}

}
