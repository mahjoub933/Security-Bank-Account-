package tn.esprit.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.entities.Facture;
import tn.esprit.repository.FactureRepository;

@Component("pdfGenerator")
public class PDFGenerator {
	
	private static final Logger logger = LogManager.getLogger(PDFGenerator.class);
	@Value("${pdfDir}")
	private String pdfDir;
	
	@Value("${reportFileName}")
	private String reportFileName;
	
	@Value("${reportFileNameDateFormat}")
	private String reportFileNameDateFormat;
	
	@Value("${localDateFormat}")
	private String localDateFormat;
	
	@Value("${logoImgPath}")
	private String logoImgPath;
	
	@Value("${logoImgScale}")
	private Float[] logoImgScale;
	
	@Value("${currencySymbol:}")
	private String currencySymbol;
	
	@Value("${table_noOfColumns}")
	private int noOfColumns;
	
	@Value("${table.columnNames}")
	private List<String> columnNames;
	
	@Autowired
	FactureRepository eRepo;

	private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
	private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

	public void generateFilePDF(){
		
		for (Facture facture : eRepo.findAll()) {
			try {
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate(facture.getRef())));
				document.open();
				addLogo(document);
				addDocTitle(document, facture);
				createTable(document,facture);
				addFooter(document);
				document.close();
				logger.info("------------------Votre rapport PDF est prêt!-------------------------");

			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void addLogo(Document document) {
		try {	
			Image img = Image.getInstance(logoImgPath);
			img.scalePercent(logoImgScale[0], logoImgScale[1]);
			img.setAlignment(Element.ALIGN_RIGHT);
			document.add(img);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addDocTitle(Document document, Facture facture) throws DocumentException {
		
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));
		Paragraph p1 = new Paragraph();
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph(reportFileName , COURIER));
		p1.setAlignment(Element.ALIGN_CENTER);
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph("Rapport généré le " + localDateString, COURIER_SMALL));
		p1.add(new Paragraph("NOM CLIENT:"+facture.getClient().getNomClient()+"\n" +"PRENOM CLIENT:"+""+facture.getClient().getPrenomClient()+"\n"+"CARTE IDENTITE NATIONAL:"+""+facture.getClient().getCin(), COURIER_SMALL));
         
		document.add(p1);
       
	}

	public void createTable(Document document, Facture facture) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		leaveEmptyLine(paragraph, 3);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(noOfColumns);
		
		for(int i=0; i<noOfColumns; i++) {
			PdfPCell cell = new PdfPCell(new Phrase(columnNames.get(i)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.CYAN);
			table.addCell(cell);
		}

		table.setHeaderRows(1);
		getDbData(table, facture);
		document.add(table);
	}
	
	
	public void getDbData(PdfPTable table, Facture fact) {
		
	
			
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			table.addCell(fact.getRef().toString());
			table.addCell(fact.getTitre());
		
			table.addCell(currencySymbol + fact.getMontant());
			table.addCell(fact.getDateDebut().toGMTString());
			table.addCell(fact.getDateValidite().toGMTString());
			logger.info(fact.getTitre());
		
		
	}
	
	public void addFooter(Document document) throws DocumentException {
		Paragraph p2 = new Paragraph();
		leaveEmptyLine(p2, 3);
		p2.setAlignment(Element.ALIGN_MIDDLE);
		p2.add(new Paragraph(
				"------------------------Fin de " +reportFileName+"------------------------", 
				COURIER_SMALL_FOOTER));
		
		document.add(p2);
	}

	public static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	public String getPdfNameWithDate(Long refFacture) {
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(reportFileNameDateFormat));
		return pdfDir+reportFileName+"-"+refFacture+localDateString+".pdf";
	}
}
