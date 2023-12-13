package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import service.Good_Service;

@WebServlet(name = "select_good_in_store",value = "/select_good_in_store")
public class Select_Good_In_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = -2374805432872506800L;
	private Good_Service gService=new Good_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("ID"));
		String name=request.getParameter("searchgood");
		if(name.equals(""))
			name=null;
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
        page p = gService.getGoodByIDName(id, pageNumber,name);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = gService.getGoodByIDName(id, pageNumber,name);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
    }
}
