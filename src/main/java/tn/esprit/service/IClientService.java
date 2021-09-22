package tn.esprit.service;

import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;

@Service
public interface IClientService {

	public Client ajouterClient(Client client);
	
	public Client getClientById(Long id);
	
	public Client updateClient(Client client);
	
	public boolean resetpassword(String currentpass , String newpass);
	
}
