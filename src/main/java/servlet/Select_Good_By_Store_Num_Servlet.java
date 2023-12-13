package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.page;
import entity.store;
import service.Good_Service;

@WebServlet(name = "select_good_by_store_num",value = "/select_good_by_store_num")
public class Select_Good_By_Store_Num_Servlet extends HttpServlet{
	private static final long serialVersionUID = 869878959670596348L;
	private Good_Service gService=new Good_Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		store userStore=(store)request.getSession().getAttribute("user");
		
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
        page p = gService.getGoodByIDNum(userStore.getID(), pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = gService.getGoodByIDNum(userStore.getID(), pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("select_all_good_by_store.jsp").forward(request, response);
    }
	
}
