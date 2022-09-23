package com.demoservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demobeans.Registration;
import com.demodao.RegistrationDAO;
import com.probeans.Demojdbc;

@WebServlet("/ViewUsers")
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationDAO dao = new RegistrationDAO();
		List<Registration> list = dao.viewUsers();
		
		PrintWriter out = response.getWriter();
		
		out.println("<table cellspacing='0' width='200px' border='3px solid black' style='margin-left:auto; margin-right:auto'>");
		out.println("<tr>");
		out.println("<th> Employee Id </th>");
		out.println("<th> Employee Name </th>");
		out.println("<th> Employee Email </th>");
		out.println("</tr>");
		for (Registration user : list) {
			out.println("<tr>");
			out.println("<td>" + user.getEmpId() + "</td>");
			out.println("<td>" + user.getEmpName() + "</td>");
			out.println("<td>" + user.getEmpmail() + "</td>");
			out.println("<td> <a href = 'Delete?empId=" + user.getEmpId() + "'> &#10060" + "</td>");
//			Update?empId=704775&empName=vandana
			out.println("<td> <a href = 'Update?empId=" + user.getEmpId() + "&empName=" + user.getEmpName() + "'> &#9998 </a> </td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
