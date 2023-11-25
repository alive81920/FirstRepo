package dao;

import java.util.List;
import entity.customer;

public interface CustomerDao {
	public boolean register(customer user);// 新用户注册

	public boolean login(String name, String pwd);// 用户登录

	public List<customer> getCustomersAll();// 返回用户信息集合

	public boolean delete(String name);// 删除用户

	public boolean updateNotName(String name, String pwd, String email, String phone, String adress);// 更新用户资料
	
	public boolean updateName(String name, String pwd, String email, String phone, String adress);// 更新用户登录名
}
