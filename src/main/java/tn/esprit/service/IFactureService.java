package tn.esprit.service;

import org.springframework.stereotype.Service;

import tn.esprit.entities.Facture;

@Service
public interface IFactureService {

	public void generatePdfReport();
	public void ajouterFactureAffecterClients( Facture fact, Long idclient);
	
}
