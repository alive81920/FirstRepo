package entity;

public class customer {
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String adress;

	public String GetName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public String GetPwd() {
		return pwd;
	}

	public void SetPwd(String pwd) {
		this.pwd = pwd;
	}

	public String GetEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}

	public String GetPhone() {
		return phone;
	}

	public void SetPhone(String phone) {
		this.phone = phone;
	}

	public String GetAdress() {
		return adress;
	}

	public void SetAdress(String adress) {
		this.adress = adress;
	}
}
