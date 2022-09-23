package com.demoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demobeans.Registration;
import com.demodao.RegistrationDAO;

/**
 * Servlet implementation class Servletdao
 */
@WebServlet("/Servletdao")
public class Servletdao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String empid=request.getParameter("empid");
		int empid1=Integer.parseInt(empid);
		String empname=request.getParameter("empname");
		String empmail=request.getParameter("empmail");
		Registration reg=new Registration(empid1,empname,empmail);
		reg.setEmpId(empid1);
		reg.setEmpName(empname);
		reg.setEmpmail(empmail);
		RegistrationDAO r=new RegistrationDAO();
		boolean d=r.insert(reg);
		if(d)
		{
			out.println("Registration Succesful");
		}
		else
		{
			out.println("Registeration Unsuccessful");
		}
	}

}
