package labexam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import labexam.model.Employe;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Employe> employes;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        employes = new ArrayList<Employe>();
        
        //testing
        employes.add(new Employe(1234,"test"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int login = Integer.parseInt(request.getParameter("login"));
		String pwd = request.getParameter("password");
		boolean ok = false;
		
		for (Employe employe : employes) {	
			if(employe.getLogin() == login && employe.getPassword().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", String.valueOf(employe.getLogin()));
				session.setMaxInactiveInterval(50);
				Cookie logged = new Cookie("userID",String.valueOf(employe.getLogin()));
				logged.setMaxAge(345600);
				response.addCookie(logged);
				ok = true;
			}
		}
		
		if(ok) response.sendRedirect("demandeConge.jsp");
		else response.sendRedirect("error.jsp");
	}

}
