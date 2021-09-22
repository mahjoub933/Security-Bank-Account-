package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Facture;
import tn.esprit.service.FactureService;

@RestController

public class FactureRestController {

	@Autowired
	FactureService pDFGenerator;
	

	@PostMapping("/auth/client/generatepdf")
	@ResponseBody
	public void generatepdf(@RequestBody Facture facture) {
		pDFGenerator.generatePdfReport();
		long x = 1;
		pDFGenerator.ajouterFactureAffecterClients(facture, x);
	}
	
}
