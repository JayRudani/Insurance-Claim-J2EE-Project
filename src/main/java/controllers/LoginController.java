package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AdminQuery;
import dbHelpers.CreateTableQuery;
import dbHelpers.LoginQuery;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//when user login into the website
			String username=request.getParameter("usrname");
			String password=request.getParameter("password");
			String admin = request.getParameter("admin");
			//check if the user is admin or not
			if(admin == null) {
				request.setAttribute("username", username);
				
				LoginQuery lq= new LoginQuery();
				if(lq.doRead(username, password))
				{
					CreateTableQuery ctq = new CreateTableQuery();
					String table=ctq.getHTMLTable(username);
					request.setAttribute("table", table);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("username", username);
				
				AdminQuery aq= new AdminQuery();
				if(aq.doRead(username, password))
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminIndex.jsp");
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
					dispatcher.forward(request, response);
				}
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
