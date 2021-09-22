package tn.esprit.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Banque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomBanque;
	private String adresseBanque;
	private int telephone;
	
	
	@OneToMany(mappedBy="banque")
	private List<PackProduit> packproduits;
	
	@OneToMany(mappedBy="banque")
	private List<Agence> LesAgences;
	
	
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomBanque() {
		return nomBanque;
	}


	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}


	public String getAdresseBanque() {
		return adresseBanque;
	}


	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public List<PackProduit> getPackproduits() {
		return packproduits;
	}


	public void setPackproduits(List<PackProduit> packproduits) {
		this.packproduits = packproduits;
	}


	public List<Agence> getLesAgences() {
		return LesAgences;
	}


	public void setLesAgences(List<Agence> lesAgences) {
		LesAgences = lesAgences;
	}

	
}
