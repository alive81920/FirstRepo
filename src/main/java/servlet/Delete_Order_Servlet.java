package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.order;
import service.Order_Service;

@WebServlet(name = "delete_order_by_customer",value = "/delete_order_by_customer")
public class Delete_Order_Servlet extends HttpServlet{
	private static final long serialVersionUID = 5005739251773817795L;
	private Order_Service oService=new Order_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		order od=(order)request.getAttribute("od");
		if (oService.Delete(od)) {
			request.setAttribute("msg", "删除成功！");
            request.getRequestDispatcher("order_customer.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "，服务器错误，删除失败！");
            request.getRequestDispatcher("order_customer.jsp").forward(request, response);
		}
    }
	
	
}
