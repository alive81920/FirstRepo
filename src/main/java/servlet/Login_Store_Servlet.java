package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.store;
import service.Store_Service;

@WebServlet(name = "login_store",value = "/login_store")
public class Login_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = 2095094396492402800L;
	private Store_Service sService=new Store_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    store user=new store(); 
		try {
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("UserName");
			String pwd=request.getParameter("UserPwd");
			user=sService.login(name, pwd);
			if(user!=null) {
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("tpye_user", "store");
				request.setAttribute("msg", "登录成功！");
	            request.getRequestDispatcher("user_center.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "用户名或者密码错误，请重新登录！");
	            request.getRequestDispatcher("login_store.jsp").forward(request, response);
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
