package dao.Impl;

import dao.CustomerDao;
import util.DBSQL;
import entity.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDao {
	public boolean register(customer user) {
		boolean flag = false;
		DBSQL.init();
		int i = 0;
		i = DBSQL.AddDelUp("insert into customer(UserName,UserPwd,UaerEmail,UserPhone,UserAdress) " + "values('"
				+ user.GetName() + "','" + user.GetPwd() + "','" + user.GetEmail() + "','" + user.GetPhone() + "','"
				+ user.GetAdress() + "')");
		if (i > 0)
			flag = true;
		DBSQL.closeSQL();
		return flag;
	}

	public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			DBSQL.init();
			ResultSet rSet = DBSQL
					.SelectSQL("select * from customer where UserName='" + name + "' and UserPwd='" + pwd + "'");
			while (rSet.next())
				if (rSet.getString("UserName").equals(name) && rSet.getString("UserPwd").equals(pwd))
					flag = true;
			DBSQL.closeSQL();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public List<customer> getCustomersAll() {
		List<customer> list=new ArrayList<customer>();
		try {
			DBSQL.init();
			ResultSet rSet=DBSQL.SelectSQL("select * from customer");
			while (rSet.next()) {
				customer cu=new customer();
				cu.SetName(rSet.getString("UserName"));
				cu.SetPwd(rSet.getString("UserPwd"));
				cu.SetEmail(rSet.getString("UserEmial"));
				cu.SetPhone(rSet.getString("UserPhone"));
				cu.SetAdress(rSet.getString("UserAdress"));
				list.add(cu);
			}
			DBSQL.closeSQL();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	public boolean delete(String name) {
		boolean flag = false;
		DBSQL.init();
		String sqlString="delete from customer where UserName='"+name+"'";
		int i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}

	public boolean updateNotName(String name, String pwd, String email, String phone, String adress) {
		boolean flag = false;
		DBSQL.init();
		String sqlString="update customer set UserPwd='"+pwd+"', "
				+"UserEmail='"+email+"', "
				+"UserPhone='"+phone+"', "
				+"UserAdress='"+adress+"' "
				+"where UserName='"+name+"'";
		int i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}
	
	public boolean updateName(String name, String pwd, String email, String phone, String adress) {
		boolean flag = false;
		DBSQL.init();
		String sqlString="update customer set UserName='"+name+"' where "
				+"UserPwd='"+pwd+"' and "
				+"UserEmail='"+email+"' and "
				+"UserPhone='"+phone+"' and "
				+"UserAdress='"+adress+"'";
		int i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}
}
