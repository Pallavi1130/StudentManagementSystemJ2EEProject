package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Admin;
import com.model.Student;

public class AdminDao {
	String url="jdbc:mysql://localhost:3306/pallavi";
	String username="root";
	String password="3011";
	Connection cn=null;
	Statement stm=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
public String checkLogin(Admin a) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	cn=	DriverManager.getConnection(url, username, password);
	stm=cn.createStatement();
	rs=stm.executeQuery("select * from admin");
	while(rs.next()) {
		String demail=rs.getString("email");
		String dpassword=rs.getString("pw");
		if(demail.equals(a.getEmail()) && dpassword.equals(a.getPassword())) {
			return "success";
		}
	}
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		try {
			rs.close();
			stm.close();
			cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	return "failure";
	
}
// inserting student data into database
public void insertStudentDetails(Student s) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	cn=	DriverManager.getConnection(url, username, password);
	ps=cn.prepareStatement("insert into student(sname, email,sub, gender,education)values(?,?,?,?,?)");
	      ps.setString(1, s.getSname());
	      ps.setString(2, s.getSemail());
	      ps.setString(3, s.getSub());
	      ps.setString(4, s.getGender());
	      ps.setString(5, s.getEducation());
	      ps.executeUpdate();     
	
	}
      catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		try {

			ps.close();
			cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}	
}

//extract data present in db
public ArrayList<Student> display() {
	ArrayList<Student> al=new ArrayList<Student>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	cn=	DriverManager.getConnection(url, username, password);
	stm=cn.createStatement();
	rs=stm.executeQuery("select * from student");
	  while(rs.next()) {
		  int id=rs.getInt("sid");
		  String name=rs.getString("sname");
		  String email=rs.getString("email");
		  String sub=rs.getString("sub");
		  String gender=rs.getString("gender");
		  String education=rs.getString("education");
		  Student s=new Student(id, name, email, sub, gender, education);
		  al.add(s);
	  }
	
	}
      catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		try {

            rs.close();
			stm.close();
			cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	return al;	
}

}
