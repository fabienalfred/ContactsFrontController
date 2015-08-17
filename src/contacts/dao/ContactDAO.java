package contacts.dao;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import contacts.entities.Contact;


@Stateless
public class ContactDAO {

	@PersistenceContext(unitName="contacts") private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		Query query = em.createNamedQuery("Contact.getAll");
		List<Contact> contacts = query.getResultList();
		return contacts;
	}
	
	public String test() {
		return "test ok";
	}

}
