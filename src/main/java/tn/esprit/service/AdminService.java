package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.repository.ClientRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	ClientRepository rep;
	
	@Override
	public String disableClientById(long id) {
		// TODO Auto-generated method stub
		Client c = rep.findById(id).get();
		c.setIsenabled(false);
		rep.save(c);
		return "Disable Account";
	}

	@Override
	public String EnableClientById(long id) {
		// TODO Auto-generated method stub
		Client c = rep.findById(id).get();
		c.setIsenabled(true);
		rep.save(c);
		return "Enable Account";
	}

	@Override
	public List<Client> getallClient() {
		// TODO Auto-generated method stub
		return (List<Client>) rep.findAll();
	}

	@Override
	public Client getClientById(long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).get();
	}

	@Override
	public boolean deleteClient(long id) {
		// TODO Auto-generated method stub
		rep.deleteById(id);
		return rep.existsById(id);
	}

}
