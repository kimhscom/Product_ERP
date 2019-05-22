package com.happy.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.erp.model.Account_IService;

@Controller
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private Account_IService account_IService;
	
	// loginForm.do 처음 로그인 화면
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("Controller loginForm");
		return "loginForm";
	}

}
