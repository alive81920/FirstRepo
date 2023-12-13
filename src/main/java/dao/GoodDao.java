package dao;

import java.util.List;

import entity.good;

public interface GoodDao {
	public boolean Add(good g);//增加新商品
	public boolean Update(good g);//更新商品信息
	public boolean Delete(int id, String name);//删除商品
	public good Select(int id, String name);//查询单个商品
	public good SelectID(int goodid);//通过商品ID查询
	public List<good> getAllGood();//返回所有商品
	public List<good> getGoodByID(int ID,int pageNumber,int pageSize);//以商家为分类返回该商家所有商品
	public List<good> getGoodByIDStock(int ID,int pageNumber,int pageSize);//以商家的库存的顺序为分类返回该商家所有商品
	public List<good> getGoodByIDNum(int ID,int pageNumber,int pageSize);//以商家的季度的顺序为分类返回该商家所有商品
	public List<good> getGoodByIDName(int ID,int pageNumber,int pageSize,String name);//以商家的商品名字匹配返回该商家的所有商品
	public List<good> getGoodByPrice(float a,float b);//根据价格区间返回商品
	public List<good> getGoodByName(String name);//根据名字返回商品
	public List<good> getGoodByCreateTime(String a,int pageNumber,int pageSize);//根据商品上架时间返回商品
	public List<good> getGoodByNum();//根据商品卖出数量，选取前20名，每月1号重置
	public int getGoodCountByID(int id);//根据商家ID返回商品数量
	public int getGoodCountByIDname(int id,String name);//根据商家搜索名字返回商品数量
	public int getGoodCountByCreateTime(String a);//根据上架时间返回商品数量
	public List<good> getGoodIndex(int pageNumber,int pageSize);//随机返回10条商品
	public List<good> getAllGood(String name,int pageNumber,int pageSize);
}
