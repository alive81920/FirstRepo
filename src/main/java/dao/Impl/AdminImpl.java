package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;
import entity.admin;
import util.DBSQL;

public class AdminImpl implements AdminDao{

	@Override
	public boolean Add(admin ad) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into adm(UserName, UserPwd, UserEmail, UserPhone, UserType) values('"
				+ad.getUserName()+"', '"
				+ad.getUserPwd()+"', '"
				+ad.getUserEmail()+"', '"
				+ad.getUserPhone()+"', '"
				+ad.getUserType()+"');";
		int i = 0;
		DBSQL.init();
		i=DBSQL.AddDelUp(sql);
		DBSQL.closeSQL();
		if(i>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean Delete(admin ad) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="delete from adm where ID='"+ad.getID()+"';";
		int i = 0;
		DBSQL.init();
		i=DBSQL.AddDelUp(sql);
		DBSQL.closeSQL();
		if(i>0)
			flag=true;
		return flag;
	}

	@Override
	public admin Select(int id,String name) {
		// TODO Auto-generated method stub
		admin ad=null;
		String sql="";
		if(id==-1&&name!=null)
			sql="select * from adm where UserName='"+name+"';";
		else if (id!=-1&&name==null) {
			sql="select * from adm where ID='"+id+"';";
		}else if(id!=-1&&name!=null){
			sql="seect * from adm where ID='"+id+"' and UserName='"+name+"';";
		}
		try {
			DBSQL.init();
			ResultSet rSet=DBSQL.SelectSQL(sql);
			if(rSet.next()) {
				ad=new admin();
				ad.setID(rSet.getInt("ID"));
				ad.setUserName(rSet.getString("UserName"));
				ad.setUserPwd(rSet.getString("UserPwd"));
				ad.setUserPhone(rSet.getString("UserPhone"));
				ad.setUserEmail(rSet.getString("UserEmail"));
				ad.setUserType(rSet.getInt("UserType"));
			}
			rSet.close();
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ad;
	}

	@Override
	public boolean Update(admin ad) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="update adm set "
				+ "UserName='"+ad.getUserName()+"', "
				+ "UserPwd='"+ad.getUserPwd()+"', "
				+ "UserEmail='"+ad.getUserEmail()+"', "
				+ "UserPhone='"+ad.getUserPhone()+"', "
				+ "UserType='"+ad.getUserType()+"' "
				+ "where ID='"+ad.getID()+"';";
		int i = 0;
		DBSQL.init();
		i=DBSQL.AddDelUp(sql);
		DBSQL.closeSQL();
		if(i>0)
			flag=true;
		return flag;
	}

	@Override
	public List<admin> SelectAll(String name,int pageNumber,int pageSize){
		List<admin> list = new ArrayList<admin>();
		String sql="";
		admin ad=null;
		if(name!=null)
			sql="select * from adm where UserName='"+name+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
		else 
			sql="select * from adm limit "+(pageNumber-1)*pageSize+","+pageSize+";";
		try {
			DBSQL.init();
			ResultSet rSet=DBSQL.SelectSQL(sql);
			while (rSet.next()) {
				ad=new admin();
				ad.setID(rSet.getInt("ID"));
				ad.setUserName(rSet.getString("UserName"));
				ad.setUserPwd(rSet.getString("UserPwd"));
				ad.setUserEmail(rSet.getString("UserEmail"));
				ad.setUserPhone(rSet.getString("UserPhone"));
				ad.setUserType(rSet.getInt("UserType"));
				list.add(ad);
			}
			rSet.close();
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
