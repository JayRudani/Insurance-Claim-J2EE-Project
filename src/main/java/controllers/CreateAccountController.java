package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.CreateAccountQuery;
import dbHelpers.CreateTableQuery;

/**
 * Servlet implementation class CreateAccountController
 */
@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//when user create a new account
			String username = request.getParameter("usrname");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			
			request.setAttribute("username", username);
			
			CreateAccountQuery caq = new CreateAccountQuery();
			
			if(caq.doRead(username, password, phoneNumber, email, address)) {
				
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
