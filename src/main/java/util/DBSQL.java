package util;

import java.sql.*;

public class DBSQL {
	static String driverName = "com.mysql.cj.jdbc.Driver";// 连接参数
	static String dbURL = "jdbc:mysql://localhost:3306/webshopping";
	static String usernameString = "root";
	static String userPwd = "251314";
	static Connection dbCom = null;// 数据库连接
	static ResultSet rSet = null;
	static PreparedStatement pStatement = null;

	public static void init() { // 初始化，连接数据库
		try {
			Class.forName(driverName);
			//System.out.print("驱动加载成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//System.out.print("驱动加载失败");
		}
		try {
			dbCom = DriverManager.getConnection(dbURL, usernameString, userPwd);
			//System.out.println("SQL连接数据库成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//System.out.print("SQL连接数据库失败");
		}
	}

	public static void closeSQL() {// 关闭数据库连接
		try {
			dbCom.close();
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.print("SQL数据库关闭异常");
		}
	}

	public static int AddDelUp(String s) {// 数据库的增删改操作
		int i = 0;
		try {
			pStatement = dbCom.prepareStatement(s);
			i = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			//System.out.print("SQL数据库增删改操作异常");
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet SelectSQL(String s) {// 数据库查找操作
		try {
			pStatement = dbCom.prepareStatement(s);
			rSet = pStatement.executeQuery(s);
		} catch (SQLException e) {
			// TODO: handle exception
			//System.out.print("SQL数据库查询操作异常");
			e.printStackTrace();
		}
		return rSet;
	}
	
	public static int SelectToNum(String s) {
		int i = 0;
		try {
			pStatement = dbCom.prepareStatement(s);
			rSet=pStatement.executeQuery();
			if(rSet.next())
				i = rSet.getInt("totalCount");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
}
