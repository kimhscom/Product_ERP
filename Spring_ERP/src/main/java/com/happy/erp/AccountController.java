package com.happy.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.happy.erp.model.Account_IService;

@Controller
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private Account_IService account_IService;

}
