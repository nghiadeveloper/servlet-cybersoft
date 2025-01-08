package crm.controller;

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
		Cookie[] cookies = req.getCookies();
		String email = "";
		String password = "";

		for (Cookie item : cookies) {
			if (item.getName().equals("email")) {
				email = item.getValue();
			}

			if (item.getName().equals("password")) {
				password = item.getValue();
			}
		}

		req.setAttribute("email", email);
		req.setAttribute("password", password);

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember-me");

		if (email.equals("admin@gmail.com") & password.equals("12345")) {
			if (remember != null) {
				Cookie ckEmail = new Cookie("email", email);
				Cookie ckPassword = new Cookie("password", password);
				resp.addCookie(ckEmail);
				resp.addCookie(ckPassword);
			}
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath);
		} else {
			req.setAttribute("message", "Đăng nhập thất bại");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}