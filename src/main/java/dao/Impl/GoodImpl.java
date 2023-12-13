package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dao.GoodDao;
import entity.good;
import util.DBSQL;

public class GoodImpl implements GoodDao {

	@Override
	public boolean Add(good g){
		// TODO Auto-generated method stub
		boolean flag=false;
		DBSQL.init();
		String sqlString="insert into good(ID,GoodName,GoodImage,GoodPrice,GoodIntrodution,GoodStock,GoodNum,GoodCreateTime,GoodUpdateTime) "
				+ "values('"
				+g.getID()+"','"
				+g.getGoodName()+"','"
				+g.getGoodImage()+"','"
				+g.getGoodPrice()+"','"
				+g.getGoodIntrodution()+"','"
				+g.getGoodStock()+"','"
				+g.getGoodNum()+"','"
				+g.getGoodCreateTime()+"','"
				+g.getGoodUpdateTime()+"');";
		int i=0;
		i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}

	@Override
	public boolean Update(good g){
		// TODO Auto-generated method stub
		boolean flag=false;
		DBSQL.init();
		String sqlString="update good set "
				+"GoodName='"+g.getGoodName()+"', "
				+"GoodImage='"+g.getGoodImage()+"', "
				+"GoodPrice='"+g.getGoodPrice()+"', "
				+"GoodIntrodution='"+g.getGoodIntrodution()+"', "
				+"GoodStock='"+g.getGoodStock()+"', "
				+"GoodNum='"+g.getGoodNum()+"', "
				+"GoodUpdateTime='"+g.getGoodUpdateTime()+"' "
				+"where GoodID="+g.getGoodID()+";";
		int i=0;
		i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}

	@Override
	public boolean Delete(int id, String name){
		// TODO Auto-generated method stub
		boolean flag=false;
		DBSQL.init();
		String sqlString="delete from good where ID='"+id+"' and GoodName='"+name+"';";
		int i=0;
		i=DBSQL.AddDelUp(sqlString);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}
	
	@Override
	public good Select(int id, String name) {
		// TODO Auto-generated method stub
		good g=null;
		try {
			DBSQL.init();
			String sqlString="select * from good where ID='"+id+"' and GoodName='"+name+"';";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			if(rSet.next()) {
				g=new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
			}
			rSet.close();
			DBSQL.closeSQL();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return g;
	}

	@Override
	public List<good> getAllGood(){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getGoodByID(int ID,int pageNumber,int pageSize){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good where ID='"+ID+"' order by GoodID desc"+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getGoodByIDStock(int ID,int pageNumber,int pageSize){
		// TODO Auto-generated method stub
				List<good> list=new ArrayList<good>();
				try {
					DBSQL.init();
					String sqlString="select * from good where ID='"+ID+"' order by GoodStock asc"+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
					ResultSet rSet=DBSQL.SelectSQL(sqlString);
					
					while (rSet.next()) {
						good g = new good();
						g.setGoodID(rSet.getInt("GoodID"));
						g.setID(rSet.getInt("ID"));
						g.setGoodName(rSet.getString("GoodName"));
						g.setGoodImage(rSet.getString("GoodImage"));
						g.setGoodPrice(rSet.getFloat("GoodPrice"));
						g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
						g.setGoodStock(rSet.getInt("GoodStock"));
						g.setGoodNum(rSet.getInt("GoodNum"));
						g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
						g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
						list.add(g);
					}
					rSet.close();
					DBSQL.closeSQL();
					return list;
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return null;
	}
	
	@Override
	public List<good> getGoodByIDNum(int ID,int pageNumber,int pageSize){
		// TODO Auto-generated method stub
				List<good> list=new ArrayList<good>();
				try {
					DBSQL.init();
					String sqlString="";
					if(ID==0)
						sqlString="select * from good order by GoodNum desc limit "+(pageNumber-1)*pageSize+","+pageSize+";";
					else
						sqlString="select * from good where ID='"+ID+"' order by GoodNum desc"+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
					ResultSet rSet=DBSQL.SelectSQL(sqlString);
					
					while (rSet.next()) {
						good g = new good();
						g.setGoodID(rSet.getInt("GoodID"));
						g.setID(rSet.getInt("ID"));
						g.setGoodName(rSet.getString("GoodName"));
						g.setGoodImage(rSet.getString("GoodImage"));
						g.setGoodPrice(rSet.getFloat("GoodPrice"));
						g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
						g.setGoodStock(rSet.getInt("GoodStock"));
						g.setGoodNum(rSet.getInt("GoodNum"));
						g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
						g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
						list.add(g);
					}
					rSet.close();
					DBSQL.closeSQL();
					return list;
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return null;
	}
	
	@Override
	public List<good> getGoodByIDName(int ID,int pageNumber,int pageSize,String name){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="";
			if(name==null&&ID!=0)
				sqlString="select * from good where ID="+ID+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if(name!=null&&ID!=0)
				sqlString="select * from good where ID="+ID+" and POSITION('"+name+"' IN `GoodName`) > 0 "+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if(name==null&&ID==0)
				sqlString="select * from good limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if (name!=null&&ID==0) {
				sqlString="select * from good where POSITION('"+name+"' IN `GoodName`) > 0 "+" limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			}
			
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public List<good> getGoodByPrice(float a, float b){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good where GoodPrice <='"+b+"' and GoodPrice >='"+a+"';";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			list.sort(Comparator.comparing(good::getGoodPrice));
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getGoodByName(String name){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good where position('"+name+"' in GoodName;";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			while (rSet.next()) {
				good g = new good();
				g.setID(rSet.getInt("ID"));
				g.setGoodID(rSet.getInt("GoodID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getGoodByCreateTime(String a,int pageNumber,int pageSize){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good where GoodCreateTime >= '"+a+"' order by GoodCreateTime limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			list.sort(Comparator.comparing(good::getGoodCreateTime).reversed());
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getGoodByNum(){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good where GoodNum > '0';";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
				if(list.size()>20) {
					list.sort(Comparator.comparing(good::getGoodNum).reversed());
					list.remove(list.size() - 1);
				}
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public int getGoodCountByID(int id) {
		int i = 0;
		String sql="";
		if(id==0){
            sql="select count(*) totalCount from good;";
        }
        else{
            sql="select count(*) totalCount from good where ID='"+id+"';";
        }
		try {
			DBSQL.init();
			i=DBSQL.SelectToNum(sql);
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public int getGoodCountByCreateTime(String a) {
		int i = 0;
		String sql="select count(*) totalCount from good where GoodCreateTime >= '"+a+"';";
		try {
			DBSQL.init();
			i=DBSQL.SelectToNum(sql);
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public int getGoodCountByIDname(int id,String name) {
		int i = 0;
		String sql="";
		if(id==0 && name ==null){
            sql="select count(*) totalCount from good;";
        }
        else if(id!=0 && name ==null){
            sql="select count(*) totalCount from good where ID='"+id+"';";
        }
		else if (id == 0&& name !=null) {
			sql="select count(*) totalCount from good where POSITION('"+name+"' IN `GoodName`) > 0";
		}else {
			sql="select count(*) totalCount from good where ID="+id+" and POSITION('"+name+"' IN `GoodName`) > 0";
		}
		try {
			DBSQL.init();
			i=DBSQL.SelectToNum(sql);
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	
	@Override
	public good SelectID(int goodid) {
		// TODO Auto-generated method stub
		good g=null;
		try {
			DBSQL.init();
			String sqlString="select * from good where GoodID="+goodid+";";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
			if(rSet.next()) {
				g=new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
			}
			rSet.close();
			DBSQL.closeSQL();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return g;
	}
	
	@Override
	public List<good> getGoodIndex(int pageNumber,int pageSize){
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="select * from good order by rand() limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
					
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<good> getAllGood(String name, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		List<good> list=new ArrayList<good>();
		try {
			DBSQL.init();
			String sqlString="";
			if(name==null)
				sqlString="select * from good limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else 
				sqlString="select * from good where POSITION('"+name+"' IN `GoodName`) > 0 limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sqlString);
					
			while (rSet.next()) {
				good g = new good();
				g.setGoodID(rSet.getInt("GoodID"));
				g.setID(rSet.getInt("ID"));
				g.setGoodName(rSet.getString("GoodName"));
				g.setGoodImage(rSet.getString("GoodImage"));
				g.setGoodPrice(rSet.getFloat("GoodPrice"));
				g.setGoodIntrodution(rSet.getString("GoodIntrodution"));
				g.setGoodStock(rSet.getInt("GoodStock"));
				g.setGoodNum(rSet.getInt("GoodNum"));
				g.setGoodCreateTime(rSet.getString("GoodCreateTime"));
				g.setGoodUpdateTime(rSet.getString("GoodUpdateTime"));
				list.add(g);
			}
			rSet.close();
			DBSQL.closeSQL();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
}
