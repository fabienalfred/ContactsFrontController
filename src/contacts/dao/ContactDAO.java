package contacts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import contacts.entities.Contact;


public class ContactDAO {

	private EntityManagerFactory emf;
	
	public ContactDAO() {
		emf = Persistence.createEntityManagerFactory("contacts");
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Contact.getAll");
		List<Contact> contacts = query.getResultList();
		em.close();
		return contacts;
	}

	public void create(Contact c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		em.close();
		et.commit();
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
		em.close();
		et.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContactByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createNamedQuery("Contact.getContactByNom")
						.setParameter("nom", nom);
		List<Contact> contacts = query.getResultList();
		em.close();
		et.commit();
		return contacts;
	}
	

}
