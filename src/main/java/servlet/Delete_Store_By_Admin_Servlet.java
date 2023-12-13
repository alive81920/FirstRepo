package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.store;
import service.Store_Service;

@WebServlet(name = "delete_store_by_admin",value = "/delete_store_by_admin")
public class Delete_Store_By_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = -4069767761278153258L;
	private Store_Service sService=new Store_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id=Integer.valueOf(request.getParameter("ID"));
			store user=sService.selectStore(id);
			if (sService.delete(user)) {
				request.setAttribute("msg", "已注销该账户");
				request.getRequestDispatcher("index_admin4.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "注销账号失败！");
	            request.getRequestDispatcher("index_admin4.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
