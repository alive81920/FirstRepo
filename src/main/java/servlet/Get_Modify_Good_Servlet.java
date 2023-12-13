package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.good;
import service.Good_Service;

@WebServlet(name = "get_modify_good",value = "/get_modify_good")
public class Get_Modify_Good_Servlet extends HttpServlet{

	private static final long serialVersionUID = 6658064798596512362L;
	private Good_Service gService = new Good_Service();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("ID"));
        String nameString=request.getParameter("GoodName");
        good g = gService.select_good(id,nameString);
        if(g!=null) {
        	request.setAttribute("g", g);
        	request.getRequestDispatcher("modify_good.jsp").forward(request, response);
        }
        else {
			request.setAttribute("msg", "获取商品详情失败！请重试！");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
	
}