package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout_customer", value="/logout_customer")
public class Logout_Customer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1536187774000668062L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("type_user");
        request.setAttribute("msg","退出登录成功");
        response.sendRedirect("index.jsp");
    }

}
