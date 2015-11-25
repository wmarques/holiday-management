package labexam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import labexam.model.Conge;
import labexam.model.Employe;

/**
 * Servlet implementation class VerificationServlet
 */
@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int jour = Integer.parseInt(request.getParameter("day"));
		if(Conge.instance().verifierJour(jour)){
			Conge.instance().poserJour(jour);
			request.setAttribute("resultat","Congé posé avec succès.");

		}else{
			request.setAttribute("resultat","Impossible de poser le congé.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resultatDemande.jsp");
		dispatcher.forward( request, response );
	}
		
}
