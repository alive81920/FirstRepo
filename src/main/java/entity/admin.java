package entity;

public class admin {
	private int ID;
	private String UserName;
	private String UserPwd;
	private String UserEmail;
	private String UserPhone;
	private int UserType;
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
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	public admin() {}
	public admin(int ID,String UserName,String UserPwd,String UserEmail,String UserPhone,int UserType) {
		this.ID=ID;
		this.UserName=UserName;
		this.UserPwd=UserPwd;
		this.UserEmail=UserEmail;
		this.UserPhone=UserPhone;
		this.UserType=UserType;
	}
	
}
