package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Facture;


@Repository
public interface FactureRepository  extends CrudRepository<Facture,Long> {
	
	@Query("SELECT count(*) FROM Facture")
    public long countfact();
	
}
