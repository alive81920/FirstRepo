package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.admin;
import service.Admin_Service;

@WebServlet(name = "modify_admin_in",value = "/modify_admin_in")
public class Modify_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = -4045409655522246621L;
	private Admin_Service aService=new Admin_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID=Integer.valueOf(request.getParameter("ID"));
		String userName=request.getParameter("UserName");
		String reuserPwd=request.getParameter("ReUserPwd");
		String userPwd=request.getParameter("UserPwd");
		String userEmail=request.getParameter("UserEmail");
		String userPhone=request.getParameter("UserPhone");
		int userType=Integer.valueOf(request.getParameter("UserType"));
		
		admin ad=aService.select(ID, null);
		
		if(reuserPwd.equals(userPwd)) {
			if(!ad.getUserName().equals(userName)) {
				admin aa=aService.select(-1, userName);
				if(aa!=null) {
					request.setAttribute("msg", "登录名重复！");
					request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
				}else {
					ad.setUserName(userName);
				}
			}
			ad.setUserPwd(userPwd);
			ad.setUserEmail(userEmail);
			ad.setUserPhone(userPhone);
			ad.setUserType(userType);
		
			if(aService.update(ad)) {
				request.setAttribute("msg", "修改成功！");
				request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "服务器错误，修改失败！");
				request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "密码不一样！");
			request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
		}

    }

}
