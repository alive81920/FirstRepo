package entity;

public class order {
	private int ID;
	private String UserName;
	private String UserPhone;
	private String UserAdress;
	private int UserID;
	private int GoodID;
	private int StoreID;
	private String GoodName;
	private float total;
	private int amount;
	private int paystatus;
	private int paytype;
	private String paydate;
	private int orderstatus;
	private String GoodImage;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPhone() {
		return UserPhone;
	}
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	public String getUserAdress() {
		return UserAdress;
	}
	public void setUserAdress(String userAdress) {
		UserAdress = userAdress;
	}
	public int getGoodID() {
		return GoodID;
	}
	public void setGoodID(int goodID) {
		GoodID = goodID;
	}
	public String getGoodName() {
		return GoodName;
	}
	public void setGoodName(String goodName) {
		GoodName = goodName;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	
	public order() {
		
	}
	public order(int ID,String UserName,String UserPhone,String UserAdress,int UserID,int GoodID,String GoodName,int total,int amount,int paystatus,int paytype,String paydate,int orderstaus,int storeid,String goodimage) {
		this.ID=ID;
		this.UserName=UserName;
		this.UserPhone=UserPhone;
		this.UserAdress=UserAdress;
		this.UserID=UserID;
		this.GoodID=GoodID;
		this.GoodName=GoodName;
		this.total=total;
		this.amount=amount;
		this.paydate=paydate;
		this.paystatus=paystatus;
		this.paytype=paytype;
		this.orderstatus=orderstaus;
		this.StoreID=storeid;
		this.GoodImage=goodimage;
	}
	@Override
	public String toString() {
		return "order[ID="+ID+"UserName="+UserName+",UserPhone="+UserPhone+",UserAdress="+UserAdress+",GoodID="+GoodID+",StoreID="+StoreID+",GoodName="+GoodName
				+",GoodImage="+GoodImage+",total="+total+",amount="+amount+",paydate="+paydate+",paystatus="+paystatus+",paytype="+paytype+",orderstatus="+orderstatus+"]";
	}
	
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeid) {
		StoreID = storeid;
	}
	public String getGoodImage() {
		return GoodImage;
	}
	public void setGoodImage(String goodImage) {
		GoodImage = goodImage;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
}
