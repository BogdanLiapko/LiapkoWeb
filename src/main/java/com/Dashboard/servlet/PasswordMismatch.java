package com.Dashboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PasswordMismatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean passwordMismatch = true;
		request.setAttribute("passwordMismatch", passwordMismatch);
		request.getRequestDispatcher("/register.jsp").forward(request,response);
	}
}

