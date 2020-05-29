package com.Dashboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import com.Dashboard.db.*;
import com.Dashboard.opdb.*;
@WebServlet("")
public class OnMainLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		if(sessionLogin != null) {
		request.setAttribute("sessionLogin", sessionLogin);
		SelectUsers selectUsers = new SelectUsers();
		ArrayList<Users> users = selectUsers.getUsersbylogin(sessionLogin);
		int permission = users.get(0).getPermission();
		request.setAttribute("permission", permission);
	}else {
		
	}
		SelectAdvertisment selectAdvertisment = new SelectAdvertisment();
		ArrayList<Advertisment> sAdvertisments = selectAdvertisment.getAdvertisment();
		request.setAttribute("sAdvertisments", sAdvertisments);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
