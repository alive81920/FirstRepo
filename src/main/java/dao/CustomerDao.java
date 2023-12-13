package dao;

import java.sql.SQLException;
import java.util.List;

import entity.customer;

public interface CustomerDao {
	public boolean Add(customer user) throws SQLException;//添加用户
	public boolean delete(String name);//删除用户
	public boolean updata(String name,String pwd,String phone,String email,String adress);//修改用户信息
	public boolean updata_login(String name,String pwd,String phone,String email,String adress) throws SQLException;//修改用户登录名
	public customer select(String name);//查找用户
	public int selectCount();//返回用户数量
	public List<customer> SelectAll(String name,int pageNumber,int pageSize);
}
