package contacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import contacts.entities.Adresse;
import contacts.entities.Contact;
import contacts.entities.ContactTO;


public class ContactDAO {

	private EntityManagerFactory emf;
	
	public ContactDAO() {
		emf = Persistence.createEntityManagerFactory("contacts");
	}
	
	public Contact getContactById(long id) {
		EntityManager em = emf.createEntityManager();
		Contact c = em.find(Contact.class, id);
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Contact.getAll");
		List<Contact> contacts = query.getResultList();
		for(Contact c : contacts) {
			c.setAdresses(getAdresses(c.getId()));
		}
		em.close();
		return contacts;
	}

	public void create(Contact c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
	}

	public void delete(String nom) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Contact> contacts = getContactByNom(nom);
		for(Contact c : contacts){
			Contact contact = em.find(c.getClass(), c.getId());
			em.remove(contact);
		}
		et.commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Contact.getContactByNom")
						.setParameter("nom", nom);
		List<Contact> contacts = query.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Adresse> getAdresses(long id) {
		EntityManager em = emf.createEntityManager();
		Contact c = em.merge(em.find(Contact.class, id));
		List<Adresse> adresses = new ArrayList<>(c.getAdresses());
		em.close();
		return adresses;
	}
	

}
