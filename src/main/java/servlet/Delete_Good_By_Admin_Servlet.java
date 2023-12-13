package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.good;
import service.Good_Service;

@WebServlet(name = "delete_good_by_admin",value = "/delete_good_by_admin")
public class Delete_Good_By_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 7074636533463913478L;
	private Good_Service gService=new Good_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int goodid=Integer.valueOf(request.getParameter("GoodID"));
			good g=gService.getGoodByGoodId(goodid);
			if (gService.delete_good(g)) {
				request.setAttribute("msg", "已下架该商品");
				request.getRequestDispatcher("index_admin5.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "下架商品失败！");
	            request.getRequestDispatcher("index_admin5.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
