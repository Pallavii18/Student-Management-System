package com.project.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.bean.Student;
import com.project.dao.SqlQueries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
         PrintWriter pw = response.getWriter();
         Student ob = SqlQueries.getInfo(id);
         pw.print("<html><head>");
         pw.print("<link rel='stylesheet' type='text/css' href='CSS/update.css'>");  // Linking the CSS file
         pw.print("</head><body>");
         pw.print("<h1>Update Student Info</h1>");
         pw.print("<form action='EditServlet' method='post'>");
         pw.print("<input type='hidden' name='id' value='" + ob.getId() + "'><br><br>");
         pw.print("First Name: <input type='text' name='fname' value='" + ob.getFname() + "'><br><br>");
         pw.print("Last Name: <input type='text' name='lname' value='" + ob.getLname() + "'><br><br>");
         pw.print("Birth Date: <input type='date' name='bdate' value='" + ob.getBdate() + "'><br><br>");
         pw.print("Mobile No: <input type='text' name='mobile' value='" + ob.getMobile() + "'><br><br>");
         pw.print("Email: <input type='email' name='email' value='" + ob.getEmail() + "'><br><br>");
         pw.print("Password: <input type='password' name='password' value='" + ob.getPassword() + "'><br><br>");
         pw.print("<button type='submit'>Update</button>");  // Add a submit button
         pw.print("</form>");
         pw.print("</body></html>");
     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
