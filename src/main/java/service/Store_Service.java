package service;

import java.sql.SQLException;
import java.util.List;

import dao.Impl.StoreImpl;
import entity.page;
import entity.store;

public class Store_Service {
	private StoreImpl sImpl=new StoreImpl();
	
	public boolean register(store user) {
		try {
			if(sImpl.Add(user)) {
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
	
	public store login(String name,String pwd) {
		store userCustomer=null;
		userCustomer = sImpl.select(name);
		if(userCustomer!=null) {
			if(userCustomer.getUserPwd().equals(pwd))
				return userCustomer;
		}
		return null;
	}
	
	public boolean updata_login(store user,String name) throws SQLException {
		boolean flag = sImpl.updata_login(name, user.getUserPwd(), user.getUserPhone(), user.getUserEmail(),user.getUserAdress());
		return flag;
	}
	
	public boolean updata(store user) {
		boolean flag =sImpl.updata(user.getUserName(), user.getUserPwd(), user.getUserPhone(), user.getUserEmail(), user.getUserAdress());
		return flag;
	}
	
	public boolean delete(store user) {
		boolean flag = sImpl.delete(user.getUserName());
		return flag;
	}
	public store select(String name) {
		return sImpl.select(name);
	}
	
	public page SelectAll(String name,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = sImpl.SelectAll(name, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
	public store selectStore(int id) {
		return sImpl.selectbyid(id);
	}
}
