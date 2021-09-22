package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Compte;

public interface ICompteService {

	public Compte ajouterCompte(Compte compte);

	public Compte supprimerCompte(int idCptCourant);

	public Compte trouverCompteById(int idCptCourant);

	public List<Compte> trouverToutCompteCourant();
	
	public List<Compte> trouverToutCompteEPARGNE();
	
	public long retournerNombreCompteCourants();
	
	public long retournerNombreCompteEPARGNE();
	
	
}
