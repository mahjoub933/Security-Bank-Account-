package tn.esprit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import tn.esprit.repository.ClientRepository;

@Component("userSecurity")
public class UserSecurity {

	@Autowired
	ClientRepository clientrep;
	
	
	public boolean hasUserId(Authentication authentication, Long userId) {
		
		Long userID=clientrep.findByUsername(authentication.getName()).getIdClient();
            if(userID==userId)
            	return true;
            
            return false;
       
    }
}
