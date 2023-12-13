package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import service.Customer_Service;

@WebServlet(name = "delete_customer_by_admin",value = "/delete_customer_by_admin")
public class Delete_Customer_By_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 293329817210681957L;
	private Customer_Service cService=new Customer_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id=Integer.valueOf(request.getParameter("ID"));
			customer uCustomer=cService.select(id);
			if (cService.delete(uCustomer)) {
				request.setAttribute("msg", "已注销该账户");
				request.getRequestDispatcher("index_admin3.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "注销账号失败！");
	            request.getRequestDispatcher("index_admin3.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
