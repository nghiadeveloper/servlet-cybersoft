package baitap130125.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var userName = req.getParameter("username");
		var password = req.getParameter("password");
		if (userName.equals("admin@gmail.com") && password.equals("123456")) {
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}