package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.order;
import service.Order_Service;

@WebServlet(name = "get_modify_order",value = "/get_modify_order")
public class Get_Order_Servlet extends HttpServlet{
	private static final long serialVersionUID = -2803167389082968767L;
	private Order_Service oService=new Order_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int op=Integer.valueOf(request.getParameter("op"));
    	int id=Integer.valueOf(request.getParameter("ID"));
    	order od=oService.Select(id);
    	if(od!=null&&op==1) {
    		request.setAttribute("od", od);
    		request.getRequestDispatcher("confirm_order").forward(request, response);
    	}else if (od!=null&&op==2) {
    		request.setAttribute("od", od);
    		request.getRequestDispatcher("confirm_receive_servlet").forward(request, response);
		}else if(od!=null&&op==3) {
    		request.setAttribute("g", od);
    		request.getRequestDispatcher("modify_order.jsp").forward(request, response);
    	}else if (od!=null&&op==4) {
    		request.setAttribute("od", od);
    		request.getRequestDispatcher("delete_order_by_customer").forward(request, response);
		}else if (od!=null&&op==5) {
			request.setAttribute("od", od);
    		request.getRequestDispatcher("confirm_delivery").forward(request, response);
		}
    	else {
    		request.setAttribute("msg", "获取订单信息失败");
    		request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
    }
}
