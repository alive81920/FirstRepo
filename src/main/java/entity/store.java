package entity;

public class store {
	private int ID;
	private String UserName;
	private String UserPwd;
	private String UserEmail;
	private String UserPhone;
	private String UserAdress;
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

	public store() {
	}
	
	@Override
	public String toString() {
		return "customer[ID="+ID+"UserName="+UserName+",UserPwd="+UserPwd+",UserPhone="+UserPhone+",UserEmail="+UserEmail+",UserAdress="+UserAdress+"]";
	}
	public store(int id, String name,String pwd,String email,String phone,String adress) {
		this.ID=id;
		this.UserName=name;
		this.UserPwd=pwd;
		this.UserPhone=phone;
		this.UserEmail=email;
		this.UserAdress=adress;
	}
	
}
