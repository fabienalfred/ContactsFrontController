package contacts.services.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;

public class ActionDelete implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		ContactDAO dao = (ContactDAO) application.getAttribute("contactDAO");
		
		String nom = request.getParameter("inputDeleteContact");
		dao.delete(nom);
		request.setAttribute("actionOnContact", "Contact supprimé");
		return "/contact_modified.jsp";
	}

}
