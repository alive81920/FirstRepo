package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import service.Good_Service;

@WebServlet(name = "index_good",value = "/index_good")
public class Index_Good_Servlet extends HttpServlet{
	private static final long serialVersionUID = 9085357348190388775L;
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
        
        if(pageNumber<=0)
            pageNumber=1;
        page p = gService.getGoodIndex(pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = gService.getGoodIndex(pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("indextoshop.jsp").forward(request, response);
    }
	
}
