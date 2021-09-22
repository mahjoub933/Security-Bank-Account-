package tn.esprit.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class PackProduit {
	@Id
	private long idPack;
	private String typePack;
	
	@ManyToOne
	private Banque banque;
	
	
	public PackProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdPack() {
		return idPack;
	}
	public void setIdPack(long idPack) {
		this.idPack = idPack;
	}
	public String getTypePack() {
		return typePack;
	}
	public void setTypePack(String typePack) {
		this.typePack = typePack;
	}
}
