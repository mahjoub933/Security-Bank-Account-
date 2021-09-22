package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Client;
import tn.esprit.entities.UserDetailsImpl;
import tn.esprit.repository.ClientRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ClientRepository clientrep;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		Client user = clientrep.findByUsername(username);
		if(user==null && !user.isIsenabled() ) {
			throw new UsernameNotFoundException(username + "not found");
		}
		return new UserDetailsImpl(user);
	}
	
	

}
