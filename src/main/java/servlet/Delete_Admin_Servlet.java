package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.admin;
import service.Admin_Service;

@WebServlet(name = "delete_admin",value = "/delete_admin")
public class Delete_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 6031059420823085510L;
	private Admin_Service aService=new Admin_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("ID"));
		admin ad=aService.select(id, null);
		if(ad!=null) {
			if(ad.getUserType()==0) {
				request.setAttribute("msg", "你无权删除该管理员！");
				request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
			}else {
				if(aService.delete(ad)) {
					request.setAttribute("msg", "删除成功！");
					request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "删除失败！");
					request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
				}
			}
		}else {
			request.setAttribute("msg", "获取信息失败！");
			request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
		}
    }
	
}
