package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dashboard.db.Advertisment;
import com.Dashboard.opdb.SelectAdvertisment;

public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		SelectAdvertisment selectAdvertisment = new SelectAdvertisment();
		ArrayList<Advertisment> advertisments = selectAdvertisment.getAdvertismentbyCategories(category);
		request.setAttribute("sAdvertisments", advertisments);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
