package models;

public class Product {
	int claims;
	private String userName, serialNumber, productName, purchaseDate;

	//constructor to initialize values 
	public Product(String userName, String serialNumber, String productName, String purchaseDate, int claims) {
		
		this.userName = userName;
		this.serialNumber = serialNumber;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.claims=claims;
		
	}

	public Product(String serialNumber, String productName, String purchaseDate, int claims) {
		
		this.serialNumber = serialNumber;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.claims = claims;
	}
	
	public Product(String serialNumber, String productName) {
		this.serialNumber = serialNumber;
		this.productName = productName;
	}
	
	public Product(String productName) {
		this.productName=productName;
	}

	public Product() {
		this.userName = "";
		this.serialNumber = "";
		this.productName = "";
		this.purchaseDate = "";
		this.claims=0;
	}

	//All getter and setter methods for all variables
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public int getClaims() {
		return claims;
	}

	public void setClaims(int claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "Products [userName=" + userName + ",serialNumber=" + serialNumber + ",productName="
				+ productName + ", purchaseDate=" + purchaseDate + "]";
	}
}
