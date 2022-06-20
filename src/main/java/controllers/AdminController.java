package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AllAvailableProductQuery;
import dbHelpers.AllClaimsQuery;
import dbHelpers.AllRegisteredProductQuery;
import dbHelpers.AllUserQuery;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
		//admin controller called when admin logs in
		try {
			String condition = request.getParameter("condition");
			//when admin wants to see all user
			if (condition.equals("allUser")) {

				AllUserQuery auq = new AllUserQuery();
				String table = auq.getHTMLTable();
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllUser.jsp");
				dispatcher.forward(request, response);
			} else if (condition.equals("allRegisterProduct")) {  //when admin wants to see all registered product by a user
				AllRegisteredProductQuery arq = new AllRegisteredProductQuery();
				String username = request.getParameter("username");
				String table = arq.getHTMLTable(username);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllRegisterProduct.jsp");
				dispatcher.forward(request, response);
			} else if (condition.equals("allClaims")) { //when admin wants to see all claims made by user 
				String username = request.getParameter("username");
				AllClaimsQuery auq = new AllClaimsQuery();
				String table = auq.getHTMLTable(username);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllClaims.jsp");
				dispatcher.forward(request, response);
			} else if (condition.equals("allProducts")) { //when admin wants to see all products in the database
				AllAvailableProductQuery aapq = new AllAvailableProductQuery();
				String table = aapq.getHTMLTable();
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllAvailableProducts.jsp");
				dispatcher.forward(request, response);
			}else if (condition.equals("accepted")) {//when admin accept a claim
				String username = request.getParameter("username");
				String claimdate = request.getParameter("claimdate");
				AllClaimsQuery auq = new AllClaimsQuery();
				String table = auq.getNewHTMLTable(username,condition,claimdate);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllClaims.jsp");
				dispatcher.forward(request, response);
			}else if (condition.equals("rejected")) {//when admin reject a claim
				String username = request.getParameter("username");
				String claimdate = request.getParameter("claimdate");
				AllClaimsQuery auq = new AllClaimsQuery();
				String table = auq.getNewHTMLTable(username,condition,claimdate);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AllClaims.jsp");
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
