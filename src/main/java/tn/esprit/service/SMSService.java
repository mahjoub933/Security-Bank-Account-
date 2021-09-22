package tn.esprit.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.entities.SMS;

import org.springframework.util.MultiValueMap;





@Component
public class SMSService {
	private static final Logger logger = LogManager.getLogger(SMS.class);
	    private String ACCOUNT_SID = "ACbacc70df9e5b985aa65b08c44824b520";

	    private String AUTH_TOKEN = "e4c31c1d422d41413b6daa908025f617";

	    private String FROM_NUMBER = "+14439988894";
	    
	    //pass fN!.EA^P?T3JjKY

	    public void send(SMS sms) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        logger.info("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
	