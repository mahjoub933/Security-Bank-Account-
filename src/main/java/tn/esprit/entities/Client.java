package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long idClient;
	private String nomClient;
	private String prenomClient;
	private int cin;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dateDeNaissance;
	private int telephone;
	private String email;
	private String adresseClient;
	@Enumerated(EnumType.STRING)
	private TypeClient type ;
	
	@Column(name="username")
	private String username;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	@Value("CLIENT")
	private String role;
	
	private boolean isenabled;
	
	public boolean isIsenabled() {
		return isenabled;
	}


	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}


	@OneToOne(mappedBy="client")
	private Credit credit;
	
	@OneToMany(mappedBy="client")
	private List<Reclamation> reclamation;
	
	@ManyToMany(mappedBy="client")
	private List<Intervention> intervention;

	
	@OneToMany(mappedBy="client")
	private List<Facture> factures;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(long idClient, String username, String password) {
		super();
		this.idClient = idClient;
		this.username = username;
		this.password = password;
	}


	public Client(String nomClient, String prenomClient, int cin, int telephone,
			String email, String adresseClient, TypeClient type, String username, String password, String role) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.cin = cin;
		this.telephone = telephone;
		this.email = email;
		this.adresseClient = adresseClient;
		this.type = type;
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public long getIdClient() {
		return idClient;
	}


	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public int getCin() {
		return cin;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresseClient() {
		return adresseClient;
	}


	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}


	public TypeClient getType() {
		return type;
	}


	public void setType(TypeClient type) {
		this.type = type;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Credit getCredit() {
		return credit;
	}


	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	
	
	
}