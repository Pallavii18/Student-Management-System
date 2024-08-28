package com.project.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.dao.SqlQueries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
	        PrintWriter pw = response.getWriter();
	        int status = SqlQueries.delete(id);

	        if (status != 0) {
	            pw.print("<h1>Data Deleted Successfully...</h1>");
	            RequestDispatcher rd = request.getRequestDispatcher("datafetch");
	            rd.include(request, response);
	        } else {
	            pw.print("<h1>Data Not Deleted Successfully...</h1>");
	        }
	    }

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
