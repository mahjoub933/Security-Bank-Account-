package tn.esprit.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.config.WebsecurityConfig;
import tn.esprit.entities.Client;
import tn.esprit.entities.TypeClient;
import tn.esprit.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clients;
	
	
	@PostMapping("/addcompte")
	@ResponseBody
	public Client ajoutClient(@RequestBody Client c){
		return clients.ajouterClient(c);
	}
	
	@GetMapping("/auth/client/get/{id}")
	public Client getclient(@PathVariable long id){
		return clients.getClientById(id);
	}
	
	@PutMapping("/auth/client/update")
	@ResponseBody
	public Client updateclient (@RequestBody Client client){
		return clients.updateClient(client);
	}
	
	
}
