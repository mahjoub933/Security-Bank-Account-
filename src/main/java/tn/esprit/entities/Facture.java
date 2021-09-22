package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Facture implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refFacture")
	private Long ref;

	private String titre;

	private double montant;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dateValidite;
	 
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@ManyToOne
	private Client client;

	public Long getRef() {
		return ref;
	}


	public void setRef(Long ref) {
		this.ref = ref;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateValidite() {
		return dateValidite;
	}


	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	

	
	
	
	 
}
