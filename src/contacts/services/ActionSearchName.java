package contacts.services;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;
import contacts.services.actions.Action;

public class ActionSearchName implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		ContactDAO dao = (ContactDAO) application.getAttribute("contactDAO");
		
		String nom = request.getParameter("inputName");
		List<Contact> contacts = dao.getContactByNom(nom);
		request.setAttribute("contacts", contacts);
		return "/contacts.jsp";
	}

}
