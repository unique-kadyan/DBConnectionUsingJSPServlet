package com.db.controller;

import java.io.IOException;
import java.security.DigestException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.db.entity.User;
import com.db.model.UsersModel;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequestWrapper;

//@WebServlet("/home")
public class HomeController extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
	@jakarta.annotation.Resource(name="jdbc/project")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequestWrapper request, HttpServletRequestWrapper response)
			throws DigestException, IOException, jakarta.servlet.ServletException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "home":
			request.getRequestDispatcher("index.jsp").forward(request, (ServletResponse) response);
			break;
		case "listusers":
			List<User> listUsers = new ArrayList<>();
			listUsers = new UsersModel().listUsers(dataSource);
			request.setAttribute("listUsers", listUsers);
			request.getRequestDispatcher("listUser.jsp").forward(request, (ServletResponse) response);
			break;
//		default:
//			request.getRequestDispatcher("error.jsp").forward(request, (ServletResponse) response);
		}

	}

}
