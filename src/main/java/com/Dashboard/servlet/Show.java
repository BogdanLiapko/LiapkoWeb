package com.Dashboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dashboard.db.Advertisment;
import com.Dashboard.db.Comments;
import com.Dashboard.db.CommentsAdvertismentUsers;
import com.Dashboard.db.Users;
import com.Dashboard.opdb.SelectAdvertisment;
import com.Dashboard.opdb.SelectComments;
import com.Dashboard.opdb.SelectCommentsAdvertismentUsers;
import com.Dashboard.opdb.SelectUsers;
import com.Dashboard.other.CommUser;

public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		SelectUsers selectUsers = new SelectUsers();
		ArrayList<Users> users = selectUsers.getUsersbylogin(sessionLogin);
		if (users.size() > 0) {
		int permission = users.get(0).getPermission();
		int userId = users.get(0).getUserId();
		request.setAttribute("userId", userId);
		request.setAttribute("permission", permission);
		} else {
			request.setAttribute("userId", 0);
			request.setAttribute("permission", 0);
		}
		SelectAdvertisment selectAdvertisment = new SelectAdvertisment();
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		ArrayList<Advertisment> sAdvertisments = selectAdvertisment.getAdvertismentbyId(prodId);
		int advUserId = sAdvertisments.get(0).getUserId();
		request.setAttribute("sAdvertisments", sAdvertisments);
		ArrayList<CommUser> commUsers = new ArrayList<CommUser>();
		SelectCommentsAdvertismentUsers selectCommentsAdvertismentUsers = new SelectCommentsAdvertismentUsers();
		ArrayList<CommentsAdvertismentUsers> commentsAdvertismentUsers = selectCommentsAdvertismentUsers.getCommentsAdvertismentUsersByProdId(prodId);
		int[] commId = new int[commentsAdvertismentUsers.size() + 1] ;
		String[] userName = new String[commentsAdvertismentUsers.size() + 1];
		for (int i = 0; i < commentsAdvertismentUsers.size(); i++) {
			commId[i] = commentsAdvertismentUsers.get(i).getCommId();
			userName[i] = selectUsers.getUsersbyId(commentsAdvertismentUsers.get(i).getUserId()).get(0).getUserName();
		}
		ArrayList<Comments> comments = new ArrayList<Comments>();
		ArrayList<Comments> tempComments = new ArrayList<Comments>();
		SelectComments selectComments = new SelectComments();
		for (int i = 0; i < commId.length; i++) {
			tempComments = selectComments.getCommentsbycommId(commId[i]);
			comments.addAll(tempComments);
		}
		for (int i = 0; i < userName.length - 1; i++) {
			CommUser commUser = new CommUser(comments.get(i).getComm(), userName[i]);
			commUsers.add(commUser);
		}
		request.setAttribute("advUserId", advUserId);
		request.setAttribute("commUsers", commUsers);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
}
}
