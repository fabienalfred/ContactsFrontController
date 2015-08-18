package contacts.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personnes")
@NamedQueries({
	@NamedQuery(name="Contact.getContactByNom",
				query="SELECT c FROM Contact c WHERE c.nom = :nom"),
	@NamedQuery(name="Contact.getAll",
				query="FROM Contact"),
	@NamedQuery(name="Contact.getContactsByCivilite",
				query="SELECT c FROM Contact c WHERE c.civilite = :civ ORDER BY c.nom"),
	@NamedQuery(name="Contact.getContactsByNom",
				query="SELECT c FROM Contact c WHERE c.nom = :nom"),
	@NamedQuery(name="Contact.getContactsByNomPrenom",
				query="SELECT c FROM Contact c WHERE c.nom = :nom AND c.prenom = :prenom ORDER BY c.nom")
})
public class Contact {

	@Id
	@Column(name = "pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String civilite;
	private String nom;
	private String prenom;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_contact")
	private List<Adresse> adresses; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
