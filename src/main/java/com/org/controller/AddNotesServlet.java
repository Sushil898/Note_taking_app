package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/add_notes")
public class AddNotesServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		
		Notes notes = new Notes();
		
		notes.setTitle(title);
		notes.setDescription(description);
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userObj");
		
		List<Notes> list =new ArrayList<Notes>();
		list.add(notes);
		
		user.setNotes(list);
		notes.setUser(user);
		
		UserDao dao = new UserDao();
		dao.saveAndUpdateUser(user);
		
		session.setAttribute("success", "Notes Added Successfully");
		resp.sendRedirect("home.jsp");
		
	}
}
