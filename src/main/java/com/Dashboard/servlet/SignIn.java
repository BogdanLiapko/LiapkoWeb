package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dashboard.db.Users;
import com.Dashboard.opdb.SelectUsers;


public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");
		SelectUsers selectUsers = new SelectUsers();
		ArrayList<Users> users = selectUsers.getUsersbylogin(login);
		HttpSession session = request.getSession();
		try {
			if (users.size()>0) {
				if (password.equals(users.get(0).getPassword())) {
					session.setAttribute("sessionLogin", login);
					response.sendRedirect("/Dashboard/SuccesfullLogin");
				}else {
				response.sendRedirect("/Dashboard/WrongLoginOrPassword");
				System.out.println("wrongPassword");
				}
			}else {
				response.sendRedirect("/Dashboard/WrongLoginOrPassword");
				System.out.println("wrongLogin");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
