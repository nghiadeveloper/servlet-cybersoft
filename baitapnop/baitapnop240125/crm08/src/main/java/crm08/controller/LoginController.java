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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm08.config.MysqlConfig;
import crm08.entity.UserEntity;

@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
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

		// Tạo mảng rỗng
		List<UserEntity> listUser = new ArrayList<UserEntity>();

		// Bước 1: Chuẩn bị câu truy vấn tương ứng với tính năng đang làm
		String query = "SELECT u.email, u.password\r\n" + "FROM users u\r\n" + "WHERE u.email = ? AND u.password = ?";

		// Bước 2: Mở kết nối với CSDL
		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			// truyền giá trị tham số cho các dấu ? ở câu truy vấn
			statement.setString(1, email);
			statement.setString(2, password);

			// executeQuery(): dùng cho câu SELECT
			// executeUpdate(): không phải câu SELECT
			ResultSet result = statement.executeQuery();

			// duyệt từng dòng dữ liệu đã truy vấn được và gán vào listUser
			while (result.next()) {
				UserEntity entity = new UserEntity();
				entity.setEmail(result.getString("email"));

				listUser.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listUser.size() > 0) {
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
