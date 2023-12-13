package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout_admin",value = "/logout_admin")
public class Logout_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = -3167445417651383657L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("tpye_admin");
		request.setAttribute("msg", "成功退出登录！");
		request.getRequestDispatcher("login_admin.jsp").forward(request, response);
	}
}
