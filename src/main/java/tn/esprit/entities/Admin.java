package tn.esprit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long idAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	private int telAdmin;
	private String emailAdmin;
	
	@JsonIgnore
	@Column(name="username")
	private String username;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	@Value("ADMIN")
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Client> client;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long idAdmin, String username, String password) {
		super();
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
	}

	public Admin(long idAdmin, String nomAdmin, String prenomAdmin, int telAdmin, String emailAdmin, String username,
			String password, String role, List<Client> client) {
		super();
		this.idAdmin = idAdmin;
		this.nomAdmin = nomAdmin;
		this.prenomAdmin = prenomAdmin;
		this.telAdmin = telAdmin;
		this.emailAdmin = emailAdmin;
		this.username = username;
		this.password = password;
		this.role = role;
		this.client = client;
	}

	public long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getPrenomAdmin() {
		return prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}

	public int getTelAdmin() {
		return telAdmin;
	}

	public void setTelAdmin(int telAdmin) {
		this.telAdmin = telAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
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

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}
	
	
}