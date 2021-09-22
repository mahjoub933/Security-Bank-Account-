package tn.esprit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Reclamation {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReclamation;
	
	private String decription;
	
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne
	private Client client;
	
	public long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	
	
	
	
}
