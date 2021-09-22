package tn.esprit.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.config.PDFGenerator;
import tn.esprit.entities.Facture;
import tn.esprit.repository.ClientRepository;
import tn.esprit.repository.FactureRepository;
import tn.esprit.service.IFactureService;
import tn.esprit.entities.Client;
@Service
public class FactureService implements IFactureService {

	private static final Logger logger = LogManager.getLogger(PDFGenerator.class);
	@Autowired
	PDFGenerator fact;
	
	@Autowired
	FactureRepository eRepo;
	
	@Autowired
	ClientRepository clientrep;
	
	@Override
	public void generatePdfReport() {
		// TODO Auto-generated method stub
		fact.generateFilePDF();
	}

	@Override
	public void ajouterFactureAffecterClients(Facture fact, Long idclient) {
		// TODO Auto-generated method stub
		Client client = clientrep.findById(idclient).get();
		fact.setClient(client);
		eRepo.save(fact);
	}

}
