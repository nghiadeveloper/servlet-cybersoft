package demoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "demoServlet", urlPatterns = { "/demo" })
public class DemoServlet extends HttpServlet {

	// Xử lý logic code khi người dùng gọi đường dẫn với phương thức GET
	// Mặc định nếu người dùng gọi đường dẫn mà không chỉ định được phương thức gọi đường dẫn đó 
	// thì mặc định là phương thức GET
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.append("Hello world");
		writer.close();
	}

}
