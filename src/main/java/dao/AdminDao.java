package dao;

import java.util.List;

import entity.admin;

public interface AdminDao {
	public boolean Add(admin ad);
	public boolean Delete(admin ad);
	public admin Select(int id,String name);
	public boolean Update(admin ad);
	public List<admin> SelectAll(String name,int pageNumber,int pageSize);
}
