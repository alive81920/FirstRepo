package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.store;
import service.Store_Service;

@WebServlet(name = "register_store",value = "/register_store")
public class Register_Store_Servlet extends HttpServlet{
	private static final long serialVersionUID = -123074711430059579L;
	private Store_Service sService=new Store_Service();
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		store user=new store();
		try {
			user.setUserName(request.getParameter("UserName"));
			user.setUserPwd(request.getParameter("UserPwd"));
			user.setUserPhone(request.getParameter("UserPhone"));
			user.setUserEmail(request.getParameter("UserEmail"));
			user.setUserAdress(request.getParameter("UserAdress"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		if(sService.register(user)) {
			request.setAttribute("msg", "注册成功，请登录！");
			request.getRequestDispatcher("login_store.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "账号重复，请重新填写！");
            request.getRequestDispatcher("register_store.jsp").forward(request, response);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }

}
