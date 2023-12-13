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

@WebServlet(name = "select_customernoconfirmreceive_by_store",value = "/select_customernoconfirmreceive_by_store")
public class Select_CustomerNoConformReceive_By_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = 4728269813520595220L;
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
        String nString=null;
        if(pageNumber<=0)
            pageNumber=1;
        page p = oService.getOrderStatus(nString,user.getID(), pageNumber,2);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = oService.getOrderStatus(nString,user.getID(), pageNumber,2);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("order_store3.jsp").forward(request, response);
    }
}
