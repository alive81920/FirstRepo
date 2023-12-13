package service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dao.Impl.GoodImpl;
import entity.good;
import entity.page;

public class Good_Service {
	private GoodImpl gImpl=new GoodImpl();
	
	public boolean add_good(good g) {
		return gImpl.Add(g);
	}
	
	public boolean update_good(good g) {
		return gImpl.Update(g);
	}
	
	public boolean delete_good(good g) {
		return gImpl.Delete(g.getID(), g.getGoodName());
	}
	
	public good select_good(int id,String name) {
		return gImpl.Select(id, name);
	}
	
	public String getdate(){
		Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
	}
	
	public void deletefilepicture(String f) {
		File file = new File(f);
		if(file.exists()) {
			file.delete();
		}
	}
	
	public page getGoodByID(int id,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByID(id);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodByID(id, pageNumber, 10);
        p.setList(list);
        return p;
	}
	
	public good getGoodByGoodId(int id) {
		return gImpl.SelectID(id);
	}
	
	public page getGoodByIDStock(int id,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByID(id);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodByIDStock(id, pageNumber, 10);
        p.setList(list);
        return p;
	}
	
	public page getGoodByIDNum(int id,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByID(id);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodByIDNum(id, pageNumber, 10);
        p.setList(list);
        return p;
	}
	
	public page getGoodByIDName(int id,int pageNumber,String name) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByIDname(id,name);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodByIDName(id, pageNumber, 10,name);
        p.setList(list);
        return p;
	}
	
	public page getGoodIndex(int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByIDname(0,null);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodIndex(pageNumber, 10);
        p.setList(list);
        return p;
	}
	
	public String lastyear() {
		Date today= new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.YEAR, -1);
		String lastyearDate=format.format(cal.getTime());
		return lastyearDate;
	}
	
	public page getGoodIndexCreate(String a,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        totalCount = gImpl.getGoodCountByCreateTime(a);
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list=null;
        list = gImpl.getGoodByCreateTime(a, pageNumber, 10);
        p.setList(list);
        return p;
	}
	
	public page SelectAll(String name,int pageNumber) {
		page p = new page();
        p.setPageNumber(pageNumber);
        List list=null;
        list = gImpl.getAllGood(name, pageNumber, 10);
        int totalCount = list.size();
        p.SetPageSizeAndTotalCount(8, totalCount);
        p.setList(list);
        return p;
	}
}
