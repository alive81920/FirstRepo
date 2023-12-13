package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import service.Customer_Service;

@WebServlet(name = "login_customer", value="/login_customer")
public class Login_Customer_Servlet extends HttpServlet {
	private static final long serialVersionUID = -5247364569526847365L;
	private Customer_Service cService=new Customer_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    customer user=new customer(); 
		try {
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("UserName");
			String pwd=request.getParameter("UserPwd");
			user=cService.login(name, pwd);
			if(user!=null) {
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("tpye_user", "customer");
				request.setAttribute("msg", "登录成功！");
	            request.getRequestDispatcher("user_center.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "用户名或者密码错误，请重新登录！");
	            request.getRequestDispatcher("login_customer.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
}
