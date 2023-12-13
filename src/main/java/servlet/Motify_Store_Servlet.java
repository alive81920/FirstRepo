package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.store;
import service.Store_Service;

@WebServlet(name = "motify_store",value = "/motify_store")
public class Motify_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = 378566501024946603L;
	private Store_Service sService=new Store_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String aString=request.getParameter("ReUserPwd");
			String bString=request.getParameter("UserPwd");
			if(aString.equals(bString))
			{
				try {
					store old_Customer=(store)request.getSession().getAttribute("user");
					store new_Customer=new store();
					new_Customer.setUserName(request.getParameter("UserName"));
					new_Customer.setUserPwd(request.getParameter("UserPwd"));
					new_Customer.setUserEmail(request.getParameter("UserEmail"));
					new_Customer.setUserPhone(request.getParameter("UserPhone"));
					new_Customer.setUserAdress(request.getParameter("UserAdress"));
					if(!(old_Customer.getUserName().equals(new_Customer.getUserName()))) {
						if(sService.updata_login(old_Customer, new_Customer.getUserName())) {
							request.setAttribute("msg", "登录名修改成功");
							request.getSession().setAttribute("user", new_Customer);
						}else {
							request.setAttribute("msg", "登录名修改失败，登录名已存在，请重新填写！");
							request.getRequestDispatcher("motify_store.jsp").forward(request, response);
						}
					}
					if(sService.updata(new_Customer)) {
						request.setAttribute("msg", "修改成功");
						request.getSession().setAttribute("user", new_Customer);
						request.getRequestDispatcher("motify_store.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "修改失败，请重新填写！");
						request.getRequestDispatcher("motify_store.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}else {
				request.setAttribute("msg", "两次密码不一样，请重新填写！");
				request.getRequestDispatcher("motify_store.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();;
		}
	}
}
