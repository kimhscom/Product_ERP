package com.happy.erp;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happy.erp.dto.Account_DTO;
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
	
	// loginCheck.do
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST, 
			produces="application/text; charset=UTF-8")
	@ResponseBody
	public String logingCheck(Account_DTO dto) {
		logger.info("요청 받은 값 {} {} ", dto.getAccount_id(), dto.getAccount_pw());
		Account_DTO ldto = account_IService.getLogin(dto);
		logger.info("Welcome loginCheck");
		return (ldto==null)?"실패":"성공/"+ldto.getAuth();
	}
	
	// login.do
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, Account_DTO dto) {
		Account_DTO ldto = account_IService.getLogin(dto);
		logger.info("Controller login {}", ldto);
		session.setAttribute("acc", ldto);
		return "redirect:/mainPage.do";
	}
	
	// logOut.do
	@RequestMapping(value="/logOut.do", method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		Account_DTO dto = (Account_DTO)session.getAttribute("acc");
		if (dto != null) {
			session.removeAttribute("acc");
			session.invalidate();
		}
		return "redirect:/loginForm.do";
	}
	
	// signUpForm.do
	@RequestMapping(value="/signUpForm.do", method=RequestMethod.GET)
	public String signUpForm() {
		logger.info("Controller signUpForm");
		return "signUpForm";
	}
	
	// idCheck.do
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST,
			produces="application/text; charset=UTF-8")
	@ResponseBody
	public String idCheck(String account_id) {
		String regex = "^[a-zA-Z0-9]*$";
		boolean isc = account_id.matches(regex);
		
		// 중복이면 True 나옴
		boolean isc2 = account_IService.idCheck(account_id);
		System.out.println(isc2);
		logger.info("Controller signUp {} // {}", isc, new Date());
		return (isc2==false)?"사용가능한 아이디 입니다.":"중복된 아이디 입니다.";
	}
	
	// mainPage.do
	@RequestMapping(value="/mainPage.do", method=RequestMethod.GET)
	public String mainPage(HttpSession session, Model model) {
		logger.info("Controller mainPage {}", (Account_DTO)session.getAttribute("acc"));
		return "mainPage";
	}

}
