package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/login")
public class Login  extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	UserService service1=new UserService();
	if(service1.login(email,password))
	{
		resp.getWriter().print("<h1 align='center' style='color:green'>login sucess<h1>");
    	req.getRequestDispatcher("login.html").include(req, resp);
	}else {
		resp.getWriter().print("<h1 align='center' style='color:red'>invalid details<h1>");
        req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
