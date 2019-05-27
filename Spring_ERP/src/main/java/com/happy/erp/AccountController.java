package com.happy.erp;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	
	// signUp.do
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(Account_DTO dto) {
		boolean isc = account_IService.insertAccount(dto);
		logger.info("Controller signUp {} // {}", isc, new Date());
		return isc?"redirect:/loginForm.do":"redirect:/signUpForm.do";
	}
	
	// findPwForm.do
	@RequestMapping(value="/findPwForm.do", method=RequestMethod.GET)
	public String findPwForm() {
		logger.info("Controller findPwForm");
		return "findPwForm";
	}
	
	// findPw.do
	@RequestMapping(value="/findPw.do", method=RequestMethod.POST)
	public String findPw(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String account_email = request.getParameter("account_email");
		
		// 임시 비밀번호 생성
		String temp_pw = "";
		
		int length = 8;
		
		char[] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		
		StringBuffer buffer = new StringBuffer();
		Random rnd = new Random();
		
		for (int i = 0; i < length; i++) {
			buffer.append(c[rnd.nextInt(c.length)]);
		}
		
		temp_pw = buffer.toString();
		
		// map타입 생성
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_email", account_email);
		map.put("temp_pw", temp_pw);
		
		boolean isc = account_IService.findAccountPw(map);
		logger.info("Controller findPw {} // {}", isc, new Date());		
		
		if (isc == true) {
			// 메일 전송
			
			String setFrom = "kimhscom@gmail.com"; // 보내는 사람
			String toMail = account_email; // 받는 사람
			String title = "임시 비밀번호 발송 메일입니다."; // 메일 제목
			String content = "임시 비밀번호는 "+temp_pw+" 입니다."; // 메일 내용
						
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				messageHelper.setFrom(setFrom); // 보내는 사람 주고 생략하거나 입력을 하지 않으면 작동이 되지 않는다.
				messageHelper.setTo(toMail); // 받는 사람의 주소
				messageHelper.setSubject(title); // 제목 생략해도 됨
				messageHelper.setText(content, true);
				
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			return "redirect:/loginForm.do";
		}else {
			return "redirect:/findPwForm.do";
		}
		
	}	
	
	// mainPage.do
	@RequestMapping(value="/mainPage.do", method=RequestMethod.GET)
	public String mainPage(HttpSession session, Model model) {
		logger.info("Controller mainPage {}", (Account_DTO)session.getAttribute("acc"));
		return "mainPage";
	}
	
	// myPageForm.do
	@RequestMapping(value="/myPageForm.do", method=RequestMethod.GET)
	public String myPageForm() {
		logger.info("Controller myPageForm");
		return "myPageForm";
	}
	
	// changePwForm.do
	@RequestMapping(value="/changePwForm.do", method=RequestMethod.GET)
	public String changePwForm() {
		logger.info("Controller changePwForm");
		return "changePwForm";
	}

}
