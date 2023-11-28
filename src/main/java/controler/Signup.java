package controler;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Userdto;
import service.UserService;
@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		String gender=req.getParameter("gender");
		int age=LocalDate.now().getYear()-dob.getYear();
		Userdto dto=new Userdto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setMobile(mobile);
        dto.setDob(dob);
        dto.setGender(gender);
        dto.setAge(age);
        UserService service=new UserService();
        if(service.saveUser(dto))
        {
        	resp.getWriter().print("<h1 align='center' style='color:green'>account created success<h1>");
        	req.getRequestDispatcher("login.html").include(req, resp);
        }else {
        resp.getWriter().print("<h1 align='center' style='color:red'>sorry!! Account cannotbe created<h1>");
        req.getRequestDispatcher("login.html").include(req, resp);
        }
		resp.getWriter().print("<h1>");
		resp.getWriter().print("name: "+ name+"<br>");
		resp.getWriter().print("email: "+ email+"<br>");
		resp.getWriter().print("password: "+ password+"<br>");
		resp.getWriter().print("mobile: "+ mobile+"<br>");
		resp.getWriter().print("dob: "+ dob+"<br>");
		resp.getWriter().print("gender: "+ gender+"<br>");
		resp.getWriter().print("age: "+ age+"<br>");
	}

}
