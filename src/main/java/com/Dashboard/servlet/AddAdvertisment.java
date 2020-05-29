package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dashboard.db.Users;
import com.Dashboard.opdb.InsertAdvertisment;
import com.Dashboard.opdb.SelectUsers;

public class AddAdvertisment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("sessionLogin");
		SelectUsers selectUsers = new SelectUsers();
		if (login!=null) {
			ArrayList<Users> users = selectUsers.getUsersbylogin(login);
			int userId = users.get(0).getUserId();
			String header = request.getParameter("header");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			String address = request.getParameter("address");
			String categories = request.getParameter("categories");
			InsertAdvertisment insertAdvertisment = new InsertAdvertisment();
			insertAdvertisment.create(userId, header, description, price, address, categories);
			response.sendRedirect("/Dashboard/");
		}else {
			response.sendRedirect("/Dashboard/login.jsp");
		}
		
	}

}
