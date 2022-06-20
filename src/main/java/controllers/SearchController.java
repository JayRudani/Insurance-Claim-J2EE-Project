package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AllAvailableProductQuery;
import dbHelpers.AllRegisteredProductQuery;
import dbHelpers.AllUserQuery;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//called when admin makes a search
			String search = request.getParameter("search");
			//admin search for a particular user
			if (search.equals("user")) {
				String username = request.getParameter("username");
				AllUserQuery auq = new AllUserQuery();
				String table = auq.getUserTable(username);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllUser.jsp");
				dispatcher.forward(request, response);
			} else if (search.equals("registerProduct")) { ///admin search for a product
				String registerProduct = request.getParameter("registerProduct");
				String username=request.getParameter("username");
				AllRegisteredProductQuery arq = new AllRegisteredProductQuery();
				String table = arq.getProductTable(username,registerProduct);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllRegisterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (search.equals("availableProduct")) { //admin search for a product from al available product
				String availableProduct = request.getParameter("availableProduct");
				AllAvailableProductQuery aapq = new AllAvailableProductQuery();
				String table = aapq.getProductTable(availableProduct);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllRegisterProduct.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
