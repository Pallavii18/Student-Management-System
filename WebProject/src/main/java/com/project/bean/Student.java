package com.project.bean;

import java.sql.Date;

public class Student {
	 private int id;
	    private String fname;
	    private String lname;
	    private Date bdate;
	    private String mobile; // Added type for mobile
	    private String email;
	    private String password;

	    // Getter and Setter for id
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    // Getter and Setter for fname
	    public String getFname() {
	        return fname;
	    }

	    public void setFname(String fname) {
	        this.fname = fname;
	    }

	    // Getter and Setter for lname
	    public String getLname() {
	        return lname;
	    }

	    public void setLname(String lname) {
	        this.lname = lname;
	    }

	    // Getter and Setter for bdate
	    public Date getBdate() {
	        return bdate;
	    }

	    public void setBdate(Date bdate) {
	        this.bdate = bdate;
	    }

	    // Getter and Setter for mobile
	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }

	    // Getter and Setter for email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter and Setter for password
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // Override toString method
	    @Override
	    public String toString() {
	        return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + 
	               ", bdate=" + bdate + ", mobile=" + mobile + ", email=" + email + 
	               ", password=" + password + "]";
	    }

	    // Parameterized constructor
	    public Student(int id, String fname, String lname, Date bdate, String mobile, String email, String password) {
	        super();
	        this.id = id;
	        this.fname = fname;
	        this.lname = lname;
	        this.bdate = bdate;
	        this.mobile = mobile;
	        this.email = email;
	        this.password = password;
	    }

	    // Default constructor
	    public Student() {
	        super();
	    }
	}