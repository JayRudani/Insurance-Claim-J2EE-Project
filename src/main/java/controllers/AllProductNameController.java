package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.GetProductsNameQuery;

/**
 * Servlet implementation class AllProductNameController
 */
@WebServlet("/AllProductNameController")
public class AllProductNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProductNameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//to create a drop down list which has all the product name 
			String username = request.getParameter("username");
			GetProductsNameQuery gpnq = new GetProductsNameQuery();
			String selectList=gpnq.getSelectList();
			request.setAttribute("username", username);
			request.setAttribute("selectList", selectList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Register_Product.jsp?selectList="+selectList+"");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
