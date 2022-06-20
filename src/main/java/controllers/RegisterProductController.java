package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.CreateTableQuery;
import dbHelpers.RegisterProductQuery;

/**
 * Servlet implementation class RegisterProductController
 */
@WebServlet("/RegisterProductController")
public class RegisterProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//when user registered a product
			String username = request.getParameter("usrname");
			String productname = request.getParameter("productname");
			String serialno = request.getParameter("serialno");
			String purchasedate = request.getParameter("purchasedate");
			
			request.setAttribute("username", username);
			
			RegisterProductQuery rpq = new RegisterProductQuery();
			if(rpq.doRead(username, productname,serialno,purchasedate)) {
				
				CreateTableQuery ctq = new CreateTableQuery();
				String table=ctq.getHTMLTable(username);
				request.setAttribute("table", table);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
				dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
					dispatcher.forward(request, response);
				}
			
			
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
