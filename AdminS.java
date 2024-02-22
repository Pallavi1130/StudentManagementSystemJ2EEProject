package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.model.Admin;
import com.model.Student;


@WebServlet("/")
public class AdminS extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path) {
		case "/validate": adminValidate(request, response);
		break;
		case "/studentpage":getStudentPage(request,response);
		break;
		case "/insert": insertStudentDetails(request, response);
		break;
		case "/display": displayStudentDetails(request,response);
		break;
		default: getLoginPage(request, response);
		}

	}

	
	private void displayStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		AdminDao ad=new AdminDao();
		ArrayList<Student> al=ad.display();
		request.setAttribute("display", al);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
		
	}


	private void insertStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		String sname=request.getParameter("sname");
		String sub=request.getParameter("sub");
		String gender=request.getParameter("gender");
		String semail=request.getParameter("semail");
		String education=request.getParameter("education");
		Student s1=new Student(sname,semail, sub, gender, education);
		AdminDao ad=new AdminDao();
		    ad.insertStudentDetails(s1);
		
	}


	private void getStudentPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
		
	}


	private void adminValidate(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Admin a=new Admin(email,password);
		AdminDao ad=new AdminDao();
		String status=ad.checkLogin(a);
		if(status.equals("success")) {
			RequestDispatcher rd=request.getRequestDispatcher("administration.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		
		try {
			doGet(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}

	

}
