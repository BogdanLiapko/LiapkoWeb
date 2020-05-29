package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dashboard.db.Advertisment;
import com.Dashboard.opdb.SelectAdvertisment;

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isEdit = true;
		request.setAttribute("isEdit", isEdit);
		SelectAdvertisment selectAdvertisment = new SelectAdvertisment();
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		ArrayList<Advertisment> sAdvertisments = selectAdvertisment.getAdvertismentbyId(prodId);
		request.setAttribute("sAdvertisments", sAdvertisments);
		request.getRequestDispatcher("/Show?prodId=" + prodId).forward(request, response);
	}

}
