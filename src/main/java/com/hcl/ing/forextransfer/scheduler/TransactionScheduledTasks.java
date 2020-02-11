package com.hcl.ing.forextransfer.scheduler;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.ing.forextransfer.service.TransactionService;

@Component
public class TransactionScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(TransactionScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	TransactionService transactionService;
	
	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() throws AccountNotFoundException {		
		log.info("The time is now {}", dateFormat.format(new Date()));
		transactionService.submitTransaction();		
	}
}
