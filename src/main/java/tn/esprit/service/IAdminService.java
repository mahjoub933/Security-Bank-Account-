package tn.esprit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
@Service
public interface IAdminService {

	public String disableClientById(long id);
	
	public String EnableClientById(long id);
	
	public List<Client> getallClient();
	
	public Client getClientById(long id);
	
	public boolean deleteClient(long id);
	
}
