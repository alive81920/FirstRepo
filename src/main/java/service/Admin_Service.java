package service;

import java.util.List;

import dao.Impl.AdminImpl;
import entity.admin;
import entity.page;

public class Admin_Service {
	private AdminImpl aImpl=new AdminImpl();
	
	public admin login(int id,String name) {
		return aImpl.Select(id, name);
	}
	
	public admin select(int id,String name) {
		return aImpl.Select(id, name);
	}
	public boolean update(admin ad) {
		return aImpl.Update(ad);
	}
	
	public boolean delete(admin ad) {
		return aImpl.Delete(ad);
	}
	
	public boolean register(admin ad) {
		return aImpl.Add(ad);
	}
	
	public page SelectAll(String name,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = aImpl.SelectAll(name, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
}
