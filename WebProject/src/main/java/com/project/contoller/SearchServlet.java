package com.project.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.project.bean.Student;
import com.project.dao.SqlQueries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String fname = request.getParameter("name");  // Assuming search is by first name
	        PrintWriter pw = response.getWriter();
	        List<Student> list = SqlQueries.search(fname);
	        response.setContentType("text/html");
	        
	        try {
	            pw.print("<html><head>");
	            pw.print("<link rel='stylesheet' type='text/css' href='CSS/search.css'>");
	            pw.print("</head><body>");
	            pw.print("<h1>Search Records</h1>");

	            if (list.isEmpty()) {
	                pw.print("<p>No students found with the name '" + fname + "'.</p>");
	            } else {
	                pw.print("<table>");
	                pw.print("<tr>");
	                pw.print("<th>ID</th>");
	                pw.print("<th>First Name</th>");
	                pw.print("<th>Last Name</th>");
	                pw.print("<th>Birth Date</th>");
	                pw.print("<th>Mobile</th>");
	                pw.print("<th>Email</th>");
	                pw.print("<th>Password</th>");
	                pw.print("<th>Update</th>");
	                pw.print("<th>Delete</th>");
	                pw.print("</tr>");

	                for (Student ob : list) {
	                    pw.print("<tr>");
	                    pw.print("<td>" + ob.getId() + "</td>");
	                    pw.print("<td>" + ob.getFname() + "</td>");
	                    pw.print("<td>" + ob.getLname() + "</td>");
	                    pw.print("<td>" + ob.getBdate() + "</td>");
	                    pw.print("<td>" + ob.getMobile() + "</td>");
	                    pw.print("<td>" + ob.getEmail() + "</td>");
	                    pw.print("<td>" + ob.getPassword() + "</td>");
	                    pw.print("<td><a href='UpdateServlet?id=" + ob.getId() + "' class='action-button'>Update</a></td>");
	                    pw.print("<td><a href='DeleteServlet?id=" + ob.getId() + "' class='action-button'>Delete</a></td>");
	                    pw.print("</tr>");
	                }

	                pw.print("</table>");
	                
	            }

	            // Go Back button
	            pw.print("<div style='text-align: center;'>");
	            pw.print("<form action='Insertion.html' method='get'>");
	            pw.print("<button type='submit' style='"
	                + "display: block; "
	                + "width: 200px; "
	                + "padding: 15px; "
	                + "margin: 20px auto; "
	                + "background-color: rgba(0, 0, 0, 0.1); "
	                + "border: 2px solid #3498db; "
	                + "border-radius: 10px; "
	                + "color: #3498db; "
	                + "font-size: 20px; "
	                + "text-align: center; "
	                + "cursor: pointer; "
	                + "transition: background-color 0.3s, color 0.3s;"
	                + "'>Go Back 😊</button>");
	            pw.print("</form>");
	            pw.print("</div>");

	            pw.print("</body></html>");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
