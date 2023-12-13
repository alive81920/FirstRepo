package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.customer;
import entity.page;
import service.Order_Service;

@WebServlet(name = "select_nopay_order",value = "/select_nopay_order")
public class Select_NoPay_Order_Servlet extends HttpServlet{
	private static final long serialVersionUID = 6823408403069581818L;
	private Order_Service oService=new Order_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = 1;
        if(request.getParameter("pageNumber") != null) {
            try {
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
            }
        }
        customer user=(customer)request.getSession().getAttribute("user");
        if(pageNumber<=0)
            pageNumber=1;
        page p = oService.getNoPayOrder(user.getUserName(),0, pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = oService.getNoPayOrder(user.getUserName(),0, pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("order_customer2.jsp").forward(request, response);
    }
	
}
