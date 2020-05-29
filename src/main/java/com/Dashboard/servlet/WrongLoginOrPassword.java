package com.Dashboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WrongLoginOrPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean wrongLoginOrPassword = true;
		request.setAttribute("wrongLoginOrPassword", wrongLoginOrPassword);
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}
}
