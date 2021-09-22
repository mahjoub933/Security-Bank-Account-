package tn.esprit.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;
	private float soldeCompte;
	private Date dateCreationCompte;
	private int Rib;
	private String typeCompte;
	
	@ManyToOne
	private Agence agence;
	
	   
		@OneToMany(mappedBy="compte")
		private List<Transaction> transactions;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

	public int getRib() {
		return Rib;
	}

	public void setRib(int rib) {
		Rib = rib;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
