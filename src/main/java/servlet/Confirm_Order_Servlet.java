package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import entity.email;
import entity.order;
import service.Order_Service;

@WebServlet(name = "confirm_order",value = "/confirm_order")
public class Confirm_Order_Servlet extends HttpServlet{
	private static final long serialVersionUID = -7037741425344158081L;
	private Order_Service oService=new Order_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	order od=(order)request.getAttribute("od");
    	customer user=(customer)request.getSession().getAttribute("user");
    	od.setPaystatus(1);
    	od.setOrderstatus(1);
    	if(oService.Update(od)) {
    		Session session = email.createSession();
    		MimeMessage message = new MimeMessage(session);
    		
    		String cemail=user.getUserEmail();
    		String orderString="订单信息："+ od;
    		
    		try {
				message.setSubject("购物");
				message.setText(orderString);
				message.setFrom(new InternetAddress("17819857749@163.com"));
				message.setRecipient(RecipientType.TO, new InternetAddress(cemail));
				
				Transport.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		request.setAttribute("msg", "付款成功");
    		request.getRequestDispatcher("order_customer.jsp").forward(request, response);
    	}else {
    		request.setAttribute("msg", "获取订单信息失败");
    		request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
    }
	
}
