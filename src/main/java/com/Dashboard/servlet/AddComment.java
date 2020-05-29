package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dashboard.db.Users;
import com.Dashboard.opdb.InsertComments;
import com.Dashboard.opdb.InsertCommentsAdvertismentUsers;
import com.Dashboard.opdb.SelectUsers;

public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		SelectUsers selectUsers = new SelectUsers();
		ArrayList<Users> users = selectUsers.getUsersbylogin(sessionLogin);
		int userId = users.get(0).getUserId();
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		String comment = request.getParameter("comment");
		InsertComments insertComments = new InsertComments();
		int commId = insertComments.create(comment);
		InsertCommentsAdvertismentUsers insertCommentsAdvertismentUsers = new InsertCommentsAdvertismentUsers();
		insertCommentsAdvertismentUsers.create(commId, userId, prodId);
		response.sendRedirect("/Dashboard/Show?prodId="+prodId);
	}

}
