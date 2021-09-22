package tn.esprit.entities;

import javax.persistence.Entity;

@Entity
public class CompteEpargne extends Compte {

	private float taux;
	

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getTauxInteret() {
		return taux;
	}

	public void setTauxInteret(float taux) {
		this.taux = taux;
	}
	 
}
