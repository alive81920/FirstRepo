package entity;

public class customer {
	private int ID;
	private String UserName;
	private String UserPwd;
	private String UserEmail;
	private String UserPhone;
	private String UserAdress;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPwd() {
		return UserPwd;
	}
	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserAdress() {
		return UserAdress;
	}
	public void setUserAdress(String userAdress) {
		UserAdress = userAdress;
	}
	public String getUserPhone() {
		return UserPhone;
	}
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public customer() {
	}
	
	@Override
	public String toString() {
		return "customer[ID="+ID+",UserName="+UserName+",UserPwd="+UserPwd+",UserPhone="+UserPhone+",UserEmail="+UserEmail+",UserAdress="+UserAdress+"]";
	}
	public customer(int ID,String name,String pwd,String email,String phone,String adress) {
		this.ID=ID;
		this.UserName=name;
		this.UserPwd=pwd;
		this.UserPhone=phone;
		this.UserEmail=email;
		this.UserAdress=adress;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
}
