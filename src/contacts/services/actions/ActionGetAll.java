package contacts.services.actions;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;

public class ActionGetAll implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		ContactDAO dao = (ContactDAO) application.getAttribute("contactDAO");
		
		List<Contact> contacts = dao.getAll();
//		for(Contact c : contacts) {
//			c.setAdresses(dao.getAdresses(c.getId()));
//		}
		request.setAttribute("contacts", contacts);
		return "/contacts.jsp";
	}

}
