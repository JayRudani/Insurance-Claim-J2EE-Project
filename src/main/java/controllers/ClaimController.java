package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ClaimQuery;
import dbHelpers.CreateTableQuery;

/**
 * Servlet implementation class ClaimController
 */
@WebServlet("/ClaimController")
public class ClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			//when user made a claim this controller is called 
			String serialno = request.getParameter("serno");
			String username = request.getParameter("usrname");
			String claimdate = request.getParameter("claimdate");
			String description = request.getParameter("description");
			
			
			request.setAttribute("username", username);
			
			ClaimQuery cq = new ClaimQuery();
			if(cq.doRead(username,serialno,claimdate, description)) {
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
