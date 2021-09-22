package tn.esprit.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Intervention {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIntervention;
	
	@Enumerated(EnumType.STRING)
	private TypeIntervention typeintervention ;
	
	@ManyToMany
	private List<Client> client;

	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdIntervention() {
		return idIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}

	public TypeIntervention getTypeintervention() {
		return typeintervention;
	}

	public void setTypeintervention(TypeIntervention typeintervention) {
		this.typeintervention = typeintervention;
	}
	
	
}
