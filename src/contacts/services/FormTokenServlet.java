package contacts.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "<h2>Formulaire non traité</h2>";
		HttpSession session = request.getSession();
		if(request.getParameter("token")==null)
		{
			String token = getToken(session);
			session.setAttribute("token", token);
		}
		else if(session.getAttribute("token")!=null && session.getAttribute("token").equals(request.getParameter("token")))
		{
			session.removeAttribute("token");
			message = "<h2>Traitement du formulaire</h2>";
		}
		else
		{
			message = "<h2>Formulaire déjà traité</h2>";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/form.jsp");
		rd.forward(request, response);
	}
	
	private String getToken(HttpSession session)
	{
		return session.getId()+System.currentTimeMillis();
	}
}
