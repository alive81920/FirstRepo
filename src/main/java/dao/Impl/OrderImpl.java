package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entity.order;
import util.DBSQL;

public class OrderImpl implements OrderDao{

	@Override
	public boolean Add(order od) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBSQL.init();
		String sql="insert into GoodOrder(UserID,UserName, UserPhone, UserAdress, GoodID, StoreID, GoodName, GoodImage, total, amount, paystatus, paytype, paydate, orderstatus) values('"
			+ od.getUserID()+"','"
			+ od.getUserName()+"','"
			+ od.getUserPhone()+"','" 
			+ od.getUserAdress()+"','"
			+ od.getGoodID()+"','"
			+ od.getStoreID()+"','"
			+ od.getGoodName()+"','"
			+ od.getGoodImage()+"','"
			+ od.getTotal()+"','"
			+ od.getAmount()+"','"
			+ od.getPaystatus()+"','"
			+ od.getPaytype()+"','"
			+ od.getPaydate()+"','"
			+ od.getOrderstatus()+"');";
		int i = 0;
		i = DBSQL.AddDelUp(sql);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}

	@Override
	public boolean Update(order od) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBSQL.init();
		String sql="update GoodOrder set "
			+ " UserPhone='" + od.getUserPhone()+"'," 
			+ " UserAdress='" + od.getUserAdress()+"',"
			+ " total='" + od.getTotal()+"',"
			+ " amount='" + od.getAmount()+"',"
			+ " paystatus='" + od.getPaystatus()+"',"
			+ " paydate='" + od.getPaydate()+"',"
			+ " orderstatus='" + od.getOrderstatus()+"' "
			+ " where ID="+od.getID()+";";
		int i = 0;
		i = DBSQL.AddDelUp(sql);
		if(i>0)
			flag=true;
		DBSQL.closeSQL();
		return flag;
	}

	@Override
	public boolean Delete(order od) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DBSQL.init();
		String sql="delete from GoodOrder where ID="+od.getID()+";";
		int i = 0;
		i=DBSQL.AddDelUp(sql);
		if (i>0) {
			flag=true;
		}
		DBSQL.closeSQL();
		return flag;
	}

	@Override
	public List<order> SelectALL(String username,int storeID, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		List<order> list=new ArrayList<order>();
		try {
			DBSQL.init();
			String sql="";
			if(username!=null&&storeID==0)
				sql="select * from GoodOrder where UserName='"+username+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if (username==null&&storeID!=0) 
				sql="select * from GoodOrder where StoreID='"+storeID+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sql);
			while (rSet.next()) {
				order od=new order();
				od.setID(rSet.getInt("ID"));
				od.setUserID(rSet.getInt("UserID"));
				od.setUserName(rSet.getString("UserName"));
				od.setUserPhone(rSet.getString("UserPhone"));
				od.setUserAdress(rSet.getString("UserAdress"));
				od.setGoodID(rSet.getInt("GoodID"));
				od.setStoreID(rSet.getInt("StoreID"));
				od.setGoodName(rSet.getString("GoodName"));
				od.setGoodImage(rSet.getString("GoodImage"));
				od.setTotal(rSet.getInt("total"));
				od.setAmount(rSet.getInt("amount"));
				od.setPaystatus(rSet.getInt("paystatus"));
				od.setPaytype(rSet.getInt("paytype"));
				od.setPaydate(rSet.getString("paydate"));
				od.setOrderstatus(rSet.getInt("orderstatus"));
				list.add(od);
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
	public List<order> SelectByPayStatus(String username, int storeID,int status, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		List<order> list=new ArrayList<order>();
		try {
			DBSQL.init();
			String sql="";
			if(username!=null&&storeID==0)
				sql="select * from GoodOrder where UserName='"+username+"' and paystatus='"+status+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if (username==null&&storeID!=0) 
				sql="select * from GoodOrder where StoreID='"+storeID+"' and paystatus='"+status+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sql);
			while (rSet.next()) {
				order od=new order();
				od.setID(rSet.getInt("ID"));
				od.setUserID(rSet.getInt(("UserID")));
				od.setUserName(rSet.getString("UserName"));
				od.setUserPhone(rSet.getString("UserPhone"));
				od.setUserAdress(rSet.getString("UserAdress"));
				od.setGoodID(rSet.getInt("GoodID"));
				od.setStoreID(rSet.getInt("StoreID"));
				od.setGoodName(rSet.getString("GoodName"));
				od.setGoodImage(rSet.getString("GoodImage"));
				od.setTotal(rSet.getInt("total"));
				od.setAmount(rSet.getInt("amount"));
				od.setPaystatus(rSet.getInt("paystatus"));
				od.setPaytype(rSet.getInt("paytype"));
				od.setPaydate(rSet.getString("paydate"));
				od.setOrderstatus(rSet.getInt("orderstatus"));
				list.add(od);
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
	public List<order> SelectByOrderStatus(String username, int storeID,int status, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		List<order> list=new ArrayList<order>();
		try {
			DBSQL.init();
			String sql="";
			if(username!=null&&storeID==0)
				sql="select * from GoodOrder where UserName='"+username+"' and orderstatus='"+status+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			else if (username==null&&storeID!=0) 
				sql="select * from GoodOrder where StoreID='"+storeID+"' and orderstatus='"+status+"' limit "+(pageNumber-1)*pageSize+","+pageSize+";";
			ResultSet rSet=DBSQL.SelectSQL(sql);
			while (rSet.next()) {
				order od=new order();
				od.setID(rSet.getInt("ID"));
				od.setUserID(rSet.getInt("UserID"));
				od.setUserName(rSet.getString("UserName"));
				od.setUserPhone(rSet.getString("UserPhone"));
				od.setUserAdress(rSet.getString("UserAdress"));
				od.setGoodID(rSet.getInt("GoodID"));
				od.setStoreID(rSet.getInt("StoreID"));
				od.setGoodName(rSet.getString("GoodName"));
				od.setGoodImage(rSet.getString("GoodImage"));
				od.setTotal(rSet.getInt("total"));
				od.setAmount(rSet.getInt("amount"));
				od.setPaystatus(rSet.getInt("paystatus"));
				od.setPaytype(rSet.getInt("paytype"));
				od.setPaydate(rSet.getString("paydate"));
				od.setOrderstatus(rSet.getInt("orderstatus"));
				list.add(od);
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
	public order Select(int id) {
		order od=null;
		try {
			DBSQL.init();
			String sql="select * from GoodOrder where ID = '"+id+"';";
			ResultSet rSet=DBSQL.SelectSQL(sql);
			if(rSet.next()) {
				od=new order();
				od.setID(rSet.getInt("ID"));
				od.setUserID(rSet.getInt("UserID"));
				od.setUserName(rSet.getString("UserName"));
				od.setUserPhone(rSet.getString("UserPhone"));
				od.setUserAdress(rSet.getString("UserAdress"));
				od.setGoodID(rSet.getInt("GoodID"));
				od.setStoreID(rSet.getInt("StoreID"));
				od.setGoodName(rSet.getString("GoodName"));
				od.setGoodImage(rSet.getString("GoodImage"));
				od.setTotal(rSet.getInt("total"));
				od.setAmount(rSet.getInt("amount"));
				od.setPaystatus(rSet.getInt("paystatus"));
				od.setPaytype(rSet.getInt("paytype"));
				od.setPaydate(rSet.getString("paydate"));
				od.setOrderstatus(rSet.getInt("orderstatus"));
			}
			rSet.close();
			DBSQL.closeSQL();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return od;
	}
}
