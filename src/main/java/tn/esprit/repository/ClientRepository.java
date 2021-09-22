package tn.esprit.repository;


import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	Client findByUsername(String username);
}
