package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.config.TokenUtil;
import tn.esprit.entities.JwtResponse;
import tn.esprit.entities.SignInRequest;
import tn.esprit.service.ClientService;
import tn.esprit.service.UserDetailsServiceImpl;

@RestController
public class AuthController {

	    @Autowired
	    private TokenUtil tokenUtil;

	    @Autowired
	    private ClientService userService;

	    @Autowired
	    private AuthenticationManager authenticationManager;
	
	    @PostMapping(value = "/login")
	    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
	        String token = tokenUtil.generateToken(userDetails);
	        JwtResponse response = new JwtResponse(token);
	        return response;
	    }

	    
}
