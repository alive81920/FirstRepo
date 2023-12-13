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

@WebServlet(name = "select_all_order_by_store",value = "/select_all_order_by_store")
public class Select_All_Order_By_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = -7778298617185011546L;
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
        page p = oService.getAllOrder(nameString,user.getID(), pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = oService.getAllOrder(nameString,user.getID(), pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("order_store.jsp").forward(request, response);
    }
	
	
}
