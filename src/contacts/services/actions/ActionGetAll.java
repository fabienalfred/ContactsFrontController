package contacts.services.actions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;

@Stateless
public class ActionGetAll implements Action {
	
	@EJB private ContactDAO dao;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		ContactDAO dao = (ContactDAO) application.getAttribute("contactDAO");
		
		List<Contact> contacts = dao.getAll();
		request.setAttribute("contacts", contacts);
//		String test = dao.test();
//		request.setAttribute("test", test);
		return "/contacts.jsp";
	}

}
