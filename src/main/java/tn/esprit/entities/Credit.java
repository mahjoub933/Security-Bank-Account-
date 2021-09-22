package tn.esprit.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


@Entity

public class Credit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numeroCarte;
	private float SoldeActuel;
	private Date dureeCredit;
	private int tauxRisque;
	
	@Enumerated(EnumType.STRING)
	private TypeCredit typecredit;
	@OneToOne
	private Client client;
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public float getSoldeActuel() {
		return SoldeActuel;
	}
	public void setSoldeActuel(float soldeActuel) {
		SoldeActuel = soldeActuel;
	}
	public Date getDureeCredit() {
		return dureeCredit;
	}
	public void setDureeCredit(Date dureeCredit) {
		this.dureeCredit = dureeCredit;
	}
	public int getTauxRisque() {
		return tauxRisque;
	}
	public void setTauxRisque(int tauxRisque) {
		this.tauxRisque = tauxRisque;
	}
	public TypeCredit getTypecredit() {
		return typecredit;
	}
	public void setTypecredit(TypeCredit typecredit) {
		this.typecredit = typecredit;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
