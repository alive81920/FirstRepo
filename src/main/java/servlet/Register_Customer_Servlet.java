package servlet;

import entity.customer;
import service.Customer_Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "register_customer",value = "/register_customer")
public class Register_Customer_Servlet extends HttpServlet {
	private static final long serialVersionUID = -1101342855376607484L;
	private Customer_Service uService = new Customer_Service();
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		customer user=new customer();
		try {
			user.setUserName(request.getParameter("UserName"));
			user.setUserPwd(request.getParameter("UserPwd"));
			user.setUserPhone(request.getParameter("UserPhone"));
			user.setUserEmail(request.getParameter("UserEmail"));
			user.setUserAdress(request.getParameter("UserAdress"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		if(uService.register(user)) {
			request.setAttribute("msg", "注册成功，请登录！");
			request.getRequestDispatcher("login_customer.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "账号重复，请重新填写！");
            request.getRequestDispatcher("register_customer.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
}
