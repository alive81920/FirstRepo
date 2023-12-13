package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.order;
import service.Order_Service;

@WebServlet(name = "confirm_receive_servlet",value = "/confirm_receive_servlet")
public class Confirm_Receive_Servlet extends HttpServlet{
	private static final long serialVersionUID = -8201514177391934022L;
	private Order_Service oService=new Order_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	order od=(order)request.getAttribute("od");
    	od.setOrderstatus(3);
    	if (oService.Update(od)) {
    		request.setAttribute("msg", "收货成功");
    		request.getRequestDispatcher("order_customer.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "获取订单信息失败");
    		request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
    }
}
