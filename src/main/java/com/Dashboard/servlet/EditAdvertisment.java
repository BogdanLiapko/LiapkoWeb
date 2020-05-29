package com.Dashboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dashboard.opdb.UpdateAdvertisment;

public class EditAdvertisment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateAdvertisment updateAdvertisment = new UpdateAdvertisment();
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		String address = request.getParameter("address");
		updateAdvertisment.edit(prodId, description, price, address);
		response.sendRedirect("/Dashboard/Show?prodId=" + prodId);
	}

}
