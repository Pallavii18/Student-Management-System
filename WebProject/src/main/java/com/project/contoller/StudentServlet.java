package com.project.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.project.bean.Student;
import com.project.dao.SqlQueries;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String bdateStr = request.getParameter("bdate");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Convert bdate from String to java.sql.Date
        java.sql.Date bdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = sdf.parse(bdateStr);
            bdate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            pw.print("<h1>Invalid date format</h1>");
            return;
        }

        Student ob = new Student();
        ob.setFname(fname);
        ob.setLname(lname);
        ob.setBdate(bdate);
        ob.setMobile(mobile);
        ob.setEmail(email);
        ob.setPassword(password);

        int status = SqlQueries.insert(ob);

        if (status != 0) {
            pw.print("<h1>Data inserted successfully</h1>");
        } else {
            pw.print("<h1>Data not inserted successfully</h1>");
        }
    }
}