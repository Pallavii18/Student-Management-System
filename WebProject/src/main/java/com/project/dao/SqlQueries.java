package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Student;
public class SqlQueries {

    public static int insert(Student ob) {
        Connection con = getConnection.connect();
        String sql = "INSERT INTO Student (fname, lname, bdate, mobile, email, password) VALUES (?, ?, ?, ?, ?, ?)";
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ob.getFname());
            ps.setString(2, ob.getLname());
            ps.setDate(3, ob.getBdate());
            ps.setString(4, ob.getMobile());
            ps.setString(5, ob.getEmail());
            ps.setString(6, ob.getPassword());
            
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> datafetch() {
        List<Student> al = new ArrayList<>();
        Connection con = getConnection.connect();
        String sql = "SELECT * FROM Student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student ob = new Student();
                ob.setId(rs.getInt("id"));
                ob.setFname(rs.getString("fname"));
                ob.setLname(rs.getString("lname"));
                ob.setBdate(rs.getDate("bdate"));
                ob.setMobile(rs.getString("mobile"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                
                al.add(ob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

    public static int delete(int id) {
        Connection con = getConnection.connect();
        String sql = "DELETE FROM Student WHERE id = ?";
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Student getInfo(int id) {
        Connection con = getConnection.connect();
        String sql = "SELECT * FROM Student WHERE id = ?";
        Student ob = new Student();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ob.setId(rs.getInt("id"));
                ob.setFname(rs.getString("fname"));
                ob.setLname(rs.getString("lname"));
                ob.setBdate(rs.getDate("bdate"));
                ob.setMobile(rs.getString("mobile"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ob;
    }

    public static int update(Student ob) {
        Connection con = getConnection.connect();
        String sql = "UPDATE Student SET fname = ?, lname = ?, bdate = ?, mobile = ?, email = ?, password = ? WHERE id = ?";
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ob.getFname());
            ps.setString(2, ob.getLname());
            ps.setDate(3, ob.getBdate());
            ps.setString(4, ob.getMobile());
            ps.setString(5, ob.getEmail());
            ps.setString(6, ob.getPassword());
            ps.setInt(7, ob.getId());
            
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> search(String name) {
        List<Student> al = new ArrayList<>();
        Connection con = getConnection.connect();
        String sql = "SELECT * FROM Student WHERE fname = ? OR lname = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student ob = new Student();
                ob.setId(rs.getInt("id"));
                ob.setFname(rs.getString("fname"));
                ob.setLname(rs.getString("lname"));
                ob.setBdate(rs.getDate("bdate"));
                ob.setMobile(rs.getString("mobile"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                al.add(ob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}