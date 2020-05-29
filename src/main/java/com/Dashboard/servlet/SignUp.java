package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dashboard.db.Users;
import com.Dashboard.opdb.InsertUsers;
import com.Dashboard.opdb.SelectUsers;


public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		SelectUsers selectUsers = new SelectUsers();
		InsertUsers insertUsers = new InsertUsers();
		ArrayList<Users> usersByLogin = selectUsers.getUsersbylogin(login);
		ArrayList<Users> userByPhone = selectUsers.getUsersbyphone(phone);
		try {
			if (login.length()>=5) {
				if (password.length()>=5) {
					if (userByPhone.size()==0) {
						if (password.equals(repeatPassword)) {
							if (usersByLogin.size()==0) {
								insertUsers.create(login,password,city,phone,address);
									response.sendRedirect("/Dashboard/SucessfullRegistration");
							}else {
								response.sendRedirect("/Dashboard/UserExist");
							}
						}else {
							response.sendRedirect("/Dashboard/PasswordMismatch");
						}
					}else {
						response.sendRedirect("/Dashboard/PhoneExist");
					}
				}else {
					response.sendRedirect("/Dashboard/PasswordLenght");
				}
			}else {
				response.sendRedirect("/Dashboard/LoginLenght");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
