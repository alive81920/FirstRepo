package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.good;
import service.Good_Service;

@WebServlet(name = "delete_good",value = "/delete_good")
public class Delete_Good_Servlet extends HttpServlet{
	private static final long serialVersionUID = 985900137675567216L;
	Good_Service gService=new Good_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goodid=Integer.valueOf(request.getParameter("GoodID"));
		good g = gService.getGoodByGoodId(goodid);
		if(g!=null){
			if(gService.delete_good(g)) {
				request.setAttribute("msg", "商品下架成功");
				request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "商品下架失败");
				request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "服务端错误，找不到该商品");
			request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
}
