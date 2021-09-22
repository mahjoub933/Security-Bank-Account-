package tn.esprit.entities;

import javax.persistence.Entity;


@Entity
public class CompteCourant extends Compte{
	private float decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public float getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
