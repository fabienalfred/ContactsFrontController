package contacts.services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;
import contacts.services.actions.Action;

public class ActionAdd implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext apllication = request.getServletContext();
		ContactDAO dao = (ContactDAO) apllication.getAttribute("contactDAO");
		
		Long id = (long) 0;
		String civ = request.getParameter("contactCiv");
		String nom = request.getParameter("contactName");
		String prenom = request.getParameter("contactPrenom");
		Contact c = new Contact();
//		c.setId(id);
		c.setCivilite(civ);
		c.setNom(nom);
		c.setPrenom(prenom);
		dao.create(c);
		request.setAttribute("actionOnContact", "Contact ajouté");
		return "/contact_modified.jsp";
		
	}

}
