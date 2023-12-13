package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import service.Customer_Service;

@WebServlet(name="cancel_customer",value = "/cancel_customer")
public class Cancel_Customer_Servlet extends HttpServlet {
	private static final long serialVersionUID = -364390791349112978L;
	private Customer_Service cService=new Customer_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			customer uCustomer=(customer) request.getSession().getAttribute("user");
			if (cService.delete(uCustomer)) {
				request.setAttribute("msg", "已注销该账户");
				request.getSession().removeAttribute("user");
				request.getSession().removeAttribute("type_user");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "注销账号失败！");
	            request.getRequestDispatcher("user_center.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
