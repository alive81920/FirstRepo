package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import entity.good;
import entity.order;
import service.Good_Service;
import service.Order_Service;

@WebServlet(name = "add_order",value = "/add_order")
public class Add_Order_Servlet extends HttpServlet{
	private static final long serialVersionUID = 2088811790328388457L;
	private Order_Service oService=new Order_Service();
	private Good_Service gService=new Good_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_type=(String)request.getSession().getAttribute("tpye_user");
		if(user_type==null) {
			request.setAttribute("msg", "请先登录用户端再下单！");
            request.getRequestDispatcher("login_customer.jsp").forward(request, response);
		}
		if(user_type.equals("customer")) {
			order od=new order();
			customer user=(customer)request.getSession().getAttribute("user");
			int id=Integer.valueOf(request.getParameter("ID"));
			String name=request.getParameter("GoodName");
			
			
			good g=gService.select_good(id, name);
			String today=gService.getdate();
			od.setUserID(user.getID());
			od.setUserName(user.getUserName());
			od.setUserPhone(user.getUserPhone());
			od.setUserAdress(user.getUserAdress());
			od.setGoodID(g.getGoodID());
			od.setStoreID(g.getID());
			od.setGoodName(g.getGoodName());
			od.setGoodImage(g.getGoodImage());
			od.setTotal(g.getGoodPrice());
			od.setAmount(1);
			od.setPaystatus(0);
			od.setPaytype(0);
			od.setPaydate(today);
			od.setOrderstatus(0);
			
			
			if(oService.Add(od)) {
				request.setAttribute("msg", "添加购物车成功，快来下单吧！");
	            request.getRequestDispatcher("select_all_order_by_customer").forward(request, response);
			}else {
				request.setAttribute("msg", "服务器错误，添加购物车失败！");
	            request.getRequestDispatcher("index_good").forward(request, response);
			}
			
		}else {
			request.setAttribute("msg", "请先登录用户端再下单！");
            request.getRequestDispatcher("login_customer.jsp").forward(request, response);
		}
    }
}
