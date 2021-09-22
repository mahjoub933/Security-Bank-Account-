package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Client;
import tn.esprit.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping("/auth/admin/disableaccount/{id}")
	public String DisableClient(@PathVariable long id){
		return service.disableClientById(id);
	}
	
	@PostMapping("/auth/admin/enableclient/{id}")
	public String EnableClient(@PathVariable long id){
		return service.EnableClientById(id);
	}
	
	@GetMapping("/auth/admin/All")
	public List<Client> AllClient(){
		return service.getallClient();
	}
	
	@GetMapping("/auth/admin/get/{id}")
	public Client GetClient(@PathVariable long id){
		return service.getClientById(id);
	}
	
	@DeleteMapping("/auth/admin/delete/{id}")
	public Boolean DeleteClient(@PathVariable long id){
		return service.deleteClient(id);
	}
	
	
	
	
	
	
}
