package dao;

import java.util.List;

import entity.order;

public interface OrderDao {
	public boolean Add(order od);//添加订单
	public boolean Update(order od);//修改订单
	public boolean Delete(order od);//删除订单
	public List<order> SelectALL(String username,int storeID,int pageNumber,int pageSize);//根据用户或商家ID选择商品
	public List<order> SelectByPayStatus(String username,int storeID,int status,int pageNumber,int pageSize);//根据支付状态选择商品
	public List<order> SelectByOrderStatus(String username,int storeID,int status,int pageNumber,int pageSize);//根据订单状态选择商品
	public order Select(int id);//根据订单ID选择订单
}
