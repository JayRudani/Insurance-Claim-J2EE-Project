package models;

public class Claim {
	private String userName, serialno, status, description, claimDate;

	//constructor to initialize values
	public Claim(String userName,String serialno, String claimDate, String description, String status) {
		
		this.userName = userName;
		this.serialno = serialno;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
		
	}

	public Claim(String serialno,String claimDate, String description, String status) {
		
		this.serialno = serialno;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
	}

	public Claim() {
		this.userName = "";
		this.serialno="";
		this.claimDate = "";
		this.description = "";
		this.status = "";
	}

	//All getter and setter methods for all variables
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSerialNo() {
		return serialno;
	}

	public void setSerialNo(String serialno) {
		this.serialno = serialno;
	}
	
	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description= description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Claims [userName=" + userName + ",claimDate=" + claimDate + ",description="
				+ description + ", status=" + status + "]";
	}
}
