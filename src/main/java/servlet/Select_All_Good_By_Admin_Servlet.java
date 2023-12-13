package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import service.Good_Service;

@WebServlet(name = "select_all_good_by_admin",value = "/select_all_good_by_admin")
public class Select_All_Good_By_Admin_Servlet extends HttpServlet{
	private static final long serialVersionUID = -7723179350288267500L;
	private Good_Service gService=new Good_Service();
	
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
        page p = gService.SelectAll(nameString, pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = gService.SelectAll(nameString, pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("index_admin5.jsp").forward(request, response);
    }
}
