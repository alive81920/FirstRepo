package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import entity.store;
import service.Order_Service;

@WebServlet(name = "select_no_confirm_in_store",value = "/select_no_confirm_in_store")
public class Select_NoConfirm_In_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = -5337886761186583636L;
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
        store user=(store)request.getSession().getAttribute("user");
        String nameString=null;
        if(pageNumber<=0)
            pageNumber=1;
        page p = oService.getOrderStatus(nameString,user.getID(), pageNumber,1);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = oService.getOrderStatus(nameString,user.getID(), pageNumber,1);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("order_store3.jsp").forward(request, response);
    }
}
