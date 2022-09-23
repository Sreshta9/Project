package com.demoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demobeans.Registration;
import com.demodao.RegistrationDAO;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.valueOf(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		
		if (empId == 448 && empName.equals("Sreshta")) {
			
			RegistrationDAO dao = new RegistrationDAO();
			String empEmail = request.getParameter("empEmail");
			Registration employee = new Registration(empId, empName, empEmail);
			
			int uid = dao.userLogin(employee);
			session.setAttribute("uid", uid);
			
			session.setAttribute("empName", empName);
			
			RequestDispatcher req = request.getRequestDispatcher("mainPage.jsp");
			req.forward(request, response);
		}
		
		else {
			String html = "<h1 style='color:red'> <center> Invalid credentials! </center> </h1>";
			writer.println(html);
			
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.include(request, response);
		}
	}
}
