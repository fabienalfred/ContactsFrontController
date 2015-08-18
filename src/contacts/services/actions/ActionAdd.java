package contacts.services.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.dao.ContactDAO;
import contacts.entities.Adresse;
import contacts.entities.Contact;

public class ActionAdd implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext apllication = request.getServletContext();
		ContactDAO dao = (ContactDAO) apllication.getAttribute("contactDAO");
		
		Long id = (long) 0;
		String civ = request.getParameter("contactCiv");
		String nom = (request.getParameter("contactName")).toUpperCase();
		String prenom = request.getParameter("contactPrenom");
		Contact c = new Contact();
//		c.setId(id);
		c.setCivilite(civ);
		c.setNom(nom);
		c.setPrenom(prenom);
		List<Adresse> adresses = new ArrayList<>();
		Adresse a1 = new Adresse();
		a1.setVille(request.getParameter("ville1"));
		Adresse a2 = new Adresse();
		a2.setVille(request.getParameter("ville2"));
		adresses.add(a1);
		adresses.add(a2);
		c.setAdresses(adresses);
		dao.create(c);
		request.setAttribute("actionOnContact", "Contact ajouté");
		return "/contact_modified.jsp";
		
	}

}
