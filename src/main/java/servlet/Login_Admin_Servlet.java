package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.admin;
import service.Admin_Service;

@WebServlet(name = "login_admin",value = "/login_admin")
public class Login_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 872759310079922957L;
	private Admin_Service aService=new Admin_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("UserName");
		String pwd=request.getParameter("UserPwd");
		admin ad=aService.login(-1, name);
		if(ad!=null) {
			if(pwd.equals(ad.getUserPwd())) {
				request.setAttribute("msg", "登录成功！");
				request.getSession().setAttribute("admin", ad);
				request.getSession().setAttribute("tpye_admin", ad.getUserType());
	            request.getRequestDispatcher("index_admin.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "密码错误！");
	            request.getRequestDispatcher("login_admin.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "找不到该管理员账号！");
            request.getRequestDispatcher("login_admin.jsp").forward(request, response);
		}
    }
}
