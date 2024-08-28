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
 * Servlet implementation class datafetch
 */
@WebServlet("/datafetch")
public class datafetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public datafetch() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 List<Student> studentList = SqlQueries.datafetch();

         try (PrintWriter pw = response.getWriter()) {
             response.setContentType("text/html");
             pw.print("<html><head>");
             pw.print("<link rel='stylesheet' type='text/css' href='CSS/style.css'>");  // Linking the CSS file
             pw.print("</head><body>");
             pw.print("<h1>Student All Data</h1>");
             pw.print("<table border='1' style='width: 100%; border-collapse: collapse;'>");
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

             for (Student student : studentList) {
                 pw.print("<tr>");
                 pw.print("<td>" + student.getId() + "</td>");
                 pw.print("<td>" + student.getFname() + "</td>");
                 pw.print("<td>" + student.getLname() + "</td>");
                 pw.print("<td>" + student.getBdate() + "</td>");
                 pw.print("<td>" + student.getMobile() + "</td>");
                 pw.print("<td>" + student.getEmail() + "</td>");
                 pw.print("<td>" + student.getPassword() + "</td>");
                 pw.print("<td><a href='UpdateServlet?id=" + student.getId() + "' class='action-button'>Update</a></td>");
                 pw.print("<td><a href='DeleteServlet?id=" + student.getId() + "' class='action-button'>Delete</a></td>");
                 pw.print("</tr>");
             }

             pw.print("</table>");
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
                 + "'>Go Back</button>");
             pw.print("</form>");
             pw.print("</div>");
             pw.print("<div style='text-align: center;'>");
             pw.print("Thank You.... &#128578;");
             pw.print("</div>");
             pw.print("</body></html>");
         }
     }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
