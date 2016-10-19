package org.killpack.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServlettExample
 */
//the URL tells Tomcat to run the java class when /ServlettExample is accessed
@WebServlet("/ServlettExample")
public class ServlettExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//default method is the doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
		
		//Post method to pass parameters
		//to create a post request we need an html form (dataFile.html)
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			//Create a PrintWriter to write to Servlett
			PrintWriter write = response.getWriter();
			
			//passing parameters to a servlett
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			Long number = Long.parseLong(request.getParameter("number"));
			
			//stores the status of the customer (preferred or regular)
			String status = request.getParameter("status");
			
			//Create session to save data in browser
			HttpSession session = request.getSession();
			
			//Set values to the session
			session.setAttribute("sessionFirst", firstName);
			session.setAttribute("sessionLast", lastName);
			session.setAttribute("sessionAddress", address);
			session.setAttribute("sessionCity", city);
			session.setAttribute("sessionState", state);
			session.setAttribute("sessionNumber", number);
			session.setAttribute("sessionStatus", status);
			
			//print out results of the form for verification
			write.println("<h2>Customer created successful!!!</h2> <br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<h3>Printing out form results for verification......</h3> <br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's First Name is " + (String) session.getAttribute("sessionFirst"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Last Name is " + (String) session.getAttribute("sessionLast"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Street Address is " + (String) session.getAttribute("sessionAddress"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("City is " + (String) session.getAttribute("sessionCity"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("State is " + (String) session.getAttribute("sessionState"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Phone Number is " + (long) session.getAttribute("sessionNumber"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer is a " + (String) session.getAttribute("sessionStatus"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}

}
