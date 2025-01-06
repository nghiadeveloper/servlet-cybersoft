package demoservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cardServlet", urlPatterns = "/card")
public class CardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Biến code HTML thành code Java và hiển thị giao diện lên trình duyệt
		req.getRequestDispatcher("card.html").forward(req, resp);
	}

}
