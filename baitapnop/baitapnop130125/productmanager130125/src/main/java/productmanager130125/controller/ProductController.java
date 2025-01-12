package productmanager130125.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productmanager130125.model.Product;

@WebServlet(name = "productController", urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	private List<Product> mProducts = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var product = new Product();
		product.setName(req.getParameter("name"));
		product.setQuantity(parseInt(req.getParameter("quantity")));
		product.setPrice(parseDouble(req.getParameter("price")));
		mProducts.add(product);
		req.setAttribute("list", mProducts);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

}
