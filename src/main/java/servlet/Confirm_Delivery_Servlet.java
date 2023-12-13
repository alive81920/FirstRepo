package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.good;
import entity.order;
import service.Good_Service;
import service.Order_Service;

@WebServlet(name = "confirm_delivery",value = "/confirm_delivery")
public class Confirm_Delivery_Servlet extends HttpServlet{
	private static final long serialVersionUID = 8123679884079051451L;
	private Order_Service oService=new Order_Service();
	private Good_Service gService=new Good_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	order od=(order)request.getAttribute("od");
    	good g=gService.getGoodByGoodId(od.getGoodID());
    	g.setGoodStock((g.getGoodStock()-od.getAmount()));
    	g.setGoodNum(g.getGoodNum()+od.getAmount());
    	od.setOrderstatus(2);
    	if(oService.Update(od)&&gService.update_good(g)) {
    		request.setAttribute("msg", "发货成功");
    		request.getRequestDispatcher("order_store.jsp").forward(request, response);
    	}else {
    		request.setAttribute("msg", "获取订单信息失败");
    		request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
    }
	
}
