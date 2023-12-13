package servlet;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.admin;
import service.Admin_Service;

@WebServlet(name = "register_admin",value = "/register_admin")
public class Register_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 3099040771304704764L;
	private Admin_Service aService = new Admin_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		admin ad=null;
		String nameString=request.getParameter("UserName");
		String pwdString=request.getParameter("UserPwd");
		String emailString=request.getParameter("UserEmail");
		String phoneString=request.getParameter("UserPhone");
		int typeString=Integer.valueOf(request.getParameter("UserType"));
		
		admin tAdmin=aService.select(-1,nameString);
		if(tAdmin!=null) {
			request.setAttribute("msg", "登录名重复，请重新填写！");
            request.getRequestDispatcher("register_admin.jsp").forward(request, response);
		}else {
			ad=new admin();
			ad.setUserName(nameString);
			ad.setUserPwd(pwdString);
			ad.setUserEmail(emailString);
			ad.setUserPhone(phoneString);
			ad.setUserType(typeString);
			if(aService.register(ad)) {
				request.setAttribute("msg", "注册成功！");
	            request.getRequestDispatcher("select_all_admin").forward(request, response);
			}
		}
    }
}
