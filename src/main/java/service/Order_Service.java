package service;

import java.util.List;

import dao.Impl.OrderImpl;
import entity.good;
import entity.order;
import entity.page;

public class Order_Service {
	private OrderImpl oImpl=new OrderImpl();
	
	public boolean Add(order od) {
		return oImpl.Add(od);
	}
	
	public order Select(int id) {
		return oImpl.Select(id);
	}
	
	public boolean Update(order od) {
		return oImpl.Update(od);
	}
	
	public boolean Delete(order od) {
		return oImpl.Delete(od);
	}
	
	public page getAllOrder(String username,int id,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = oImpl.SelectALL(username,id, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
	
	public page getNoPayOrder(String username,int id,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = oImpl.SelectByPayStatus(username,id,0, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
	
	public page getOrderStatus(String username,int id,int pageNumber,int status) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = oImpl.SelectByOrderStatus(username,id,status, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
}
