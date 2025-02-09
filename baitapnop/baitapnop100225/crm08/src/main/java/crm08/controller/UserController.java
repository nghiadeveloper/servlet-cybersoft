package crm08.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm08.config.MysqlConfig;
import crm08.entity.RoleEntity;
import crm08.entity.UserEntity;
import crm08.services.UserServices;

@WebServlet(name = "userController", urlPatterns = { "/user", "/user-add" })
public class UserController extends HttpServlet {
	
	private UserServices userServices = new UserServices();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/user":
			// logic code liên quan đến /user
			getUser(req, resp);
			break;

		case "/user-add":
			// logic code liên quan đến /user-add
			addUser(req, resp);
			break;
		}
	}

	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> roles = userServices.getRoles();
		
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}

	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<UserEntity> users = new ArrayList<UserEntity>();
		
		req.setAttribute("users", users);
		req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}
}
