package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.admin;
import service.Admin_Service;

@WebServlet(name = "get_admin_servlet",value = "/get_admin_servlet")
public class Get_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 2614645838154957002L;
	private Admin_Service aService=new Admin_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=Integer.valueOf(request.getParameter("ID"));
    	admin ad=aService.select(id, null);
    	if(ad!=null) {
    		request.setAttribute("ad", ad);
    		request.getRequestDispatcher("modify_admin.jsp").forward(request, response);
    	}else {
			request.setAttribute("msg", "服务端错误，获取信息失败！");
			request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
		}
    }
}
