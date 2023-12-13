package service;

import java.sql.SQLException;
import java.util.List;

import dao.Impl.CustomerImpl;
import entity.customer;
import entity.page;

public class Customer_Service {
	private CustomerImpl cImpl=new CustomerImpl();
	
	public boolean register(customer user) {
		try {
			if(cImpl.Add(user)) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public customer login(String name,String pwd) {
		customer userCustomer=null;
		userCustomer = cImpl.select(name);
		if(userCustomer!=null) {
			if(userCustomer.getUserPwd().equals(pwd))
				return userCustomer;
		}
		return null;
	}
	
	public boolean updata_login(customer user,String name) throws SQLException {
		boolean flag = cImpl.updata_login(name, user.getUserPwd(), user.getUserPhone(), user.getUserEmail(),user.getUserAdress());
		return flag;
	}
	
	public boolean updata(customer user) {
		boolean flag =cImpl.updata(user.getUserName(), user.getUserPwd(), user.getUserPhone(), user.getUserEmail(), user.getUserAdress());
		return flag;
	}
	
	public boolean delete(customer user) {
		boolean flag = cImpl.delete(user.getUserName());
		return flag;
	}
	
	public customer select(String name) {
		return cImpl.select(name);
	}
	
	public customer select(int name) {
		return cImpl.select(name);
	}
	
	public page SelectAll(String name,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = cImpl.SelectAll(name, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
	
}
