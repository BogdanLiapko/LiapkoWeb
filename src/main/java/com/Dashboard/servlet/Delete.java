package com.Dashboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dashboard.opdb.DeleteAdvertisment;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteAdvertisment deleteAdvertisment = new DeleteAdvertisment();
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		deleteAdvertisment.delete(prodId);
		response.sendRedirect("/Dashboard/");
	}

}
