package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import service.Admin_Service;

@WebServlet(name = "select_all_admin",value = "/select_all_admin")
public class Select_All_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = 2936242425009887046L;
	private Admin_Service aService=new Admin_Service();
	
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
        String nameString=null;
        if(pageNumber<=0)
            pageNumber=1;
        page p = aService.SelectAll(nameString, pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = aService.SelectAll(nameString, pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("index_admin2.jsp").forward(request, response);
    }
	
}
