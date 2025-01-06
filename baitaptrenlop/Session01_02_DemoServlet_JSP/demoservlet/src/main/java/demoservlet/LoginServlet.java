package demoservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	/**
	 * Buổi 02: JSP 
	 * 
	 * Quy định tham số khi gọi đường dẫn (Truyền và nhận tham số từclient) 
	 * 
	 * - GET: Tham số sẽ truyền trực tiếp trên đường dẫn (url). Có giới hạn 2048 ký tự trên trình duyệt
	 * 	 Ví dụ: http://localhost?tenthamso=giatri&tenthamso=giatri...
	 * 
	 * - POST: Tham số sẽ truyền ngầm. Không giới hạn
	 * 	 Các cách truyền ngầm:
	 * 	 	+ Thẻ form (html) 
	 * 		+ Tự code 
	 * 
	 * Handle Exception: Xử lý ngoại lệ (try - catch)
	 * 
	 * Cách xử lý logic code
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Lấy tham số từ client (front-end) truyền lên
		String username = req.getParameter("username");

		// Ép kiểu từ kiểu dữ liệu tham chiếu sang kiểu dữ liệu nguyên thủy
		// int age = Integer.parseInt(req.getParameter("age"));

		// Xử lý ngoại lệ
		int age = 0;
		try {
			age = Integer.parseInt(req.getParameter("age"));
		} catch (Exception e) {
			System.out.println("Vui lòng nhập số cho tuổi!");
			System.out.println("Kiểm tra lỗi: " + e.getMessage());
		}

		System.out.println("Kiểm tra: " + username + " - Age: " + age);

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Sẽ kích hoạt khi người dùng gọi đường dẫn với phương thức POST

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println("Kiểm tra: " + username + " - Password: " + password);

		// Trả giá trị ra cho file JSP
		// req.setAttribute(key, value);
		req.setAttribute("giatri1", username);
		req.setAttribute("giatri2", password);

		String color = password.equals("123") ? "red" : "blue";
		req.setAttribute("color", color);

		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
}
