package entity;

public class good {
	private int GoodID;
	private int ID;
	private String GoodName;
	private String GoodImage;
	private float GoodPrice;
	private String GoodIntrodution;
	private int GoodStock;
	private int GoodNum;
	private String GoodCreateTime;
	private String GoodUpdateTime;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getGoodName() {
		return GoodName;
	}
	public void setGoodName(String goodName) {
		GoodName = goodName;
	}
	public String getGoodImage() {
		return GoodImage;
	}
	public void setGoodImage(String goodImage) {
		GoodImage = goodImage;
	}
	public float getGoodPrice() {
		return GoodPrice;
	}
	public void setGoodPrice(float goodPrice) {
		GoodPrice = goodPrice;
	}
	public String getGoodIntrodution() {
		return GoodIntrodution;
	}
	public void setGoodIntrodution(String goodIntrodution) {
		GoodIntrodution = goodIntrodution;
	}
	public int getGoodStock() {
		return GoodStock;
	}
	public void setGoodStock(int goodStock) {
		GoodStock = goodStock;
	}
	public String getGoodCreateTime() {
		return GoodCreateTime;
	}
	public void setGoodCreateTime(String goodCreateTime) {
		GoodCreateTime = goodCreateTime;
	}
	public String getGoodUpdateTime() {
		return GoodUpdateTime;
	}
	public void setGoodUpdateTime(String goodUpdateTime) {
		GoodUpdateTime = goodUpdateTime;
	}

	public good() {
		
	}
	
	public good(int GoodID,int ID,String GoodName,String GoodImage,float GoodPrice,String GoodIntrodution,int GoodStock,int GoodNum,String GoodCreateTime,String GoodUpdateTime) {
		this.GoodID=GoodID;
		this.ID=ID;
		this.GoodName=GoodName;
		this.GoodImage=GoodImage;
		this.GoodPrice=GoodPrice;
		this.GoodIntrodution=GoodIntrodution;
		this.GoodStock=GoodStock;
		this.GoodNum=GoodNum;
		this.GoodCreateTime=GoodCreateTime;
		this.GoodUpdateTime=GoodUpdateTime;
	}
	
	@Override
	public String toString() {
		return "good[GoodID="+GoodID+",ID="+ID+",GoodName="+GoodName+",GoodImage="+GoodImage+",GoodPrice="+GoodPrice+",GoodIntrodution="+GoodIntrodution+",GoodStock="+GoodStock+",GoodNum="+GoodNum+",GoodCreateTime="+GoodCreateTime+",GoodUpdateTime="+GoodUpdateTime+"]";
	}
	public int getGoodNum() {
		return GoodNum;
	}
	public void setGoodNum(int goodNum) {
		GoodNum = goodNum;
	}
	public int getGoodID() {
		return GoodID;
	}
	public void setGoodID(int goodID) {
		GoodID = goodID;
	}
}
