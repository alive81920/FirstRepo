package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.good;
import entity.order;
import service.Good_Service;
import service.Order_Service;

@WebServlet(name = "modify_order_msg",value = "/modify_order_msg")
public class Modify_Order_By_Customer_msg_Servelet extends HttpServlet{
	private static final long serialVersionUID = -448379719237138297L;
	private Order_Service oService=new Order_Service();
	private Good_Service gService=new Good_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int ID = Integer.valueOf(request.getParameter("OrderID"));
			String phoneString=request.getParameter("UserPhone");
			String adString=request.getParameter("UserAdress");
			int am=Integer.valueOf(request.getParameter("amount"));
			
			order od=oService.Select(ID);
			good g=gService.getGoodByGoodId(od.getGoodID());
			
			if((g.getGoodStock()-od.getAmount())<0) {
				request.setAttribute("msg", "商品库存不足,修改失败！");
	            request.getRequestDispatcher("modify_order.jsp").forward(request, response);
			}
			
			if(phoneString.equals(od.getUserPhone()))
				od.setUserPhone(phoneString);
			if(adString.equals(od.getUserAdress()))
				od.setUserAdress(adString);
			if(am!=od.getAmount()) {
				float f=(od.getTotal()/(float)od.getAmount())*am;
				od.setAmount(am);
				od.setTotal(f);
			}
			if(oService.Update(od)) {
				request.setAttribute("msg", "修改成功！");
	            request.getRequestDispatcher("order_customer.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "修改失败！");
	            request.getRequestDispatcher("modify_order.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
