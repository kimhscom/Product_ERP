package com.happy.erp;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import com.happy.erp.dto.Pagination;
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
	public String myPageForm(String account_id, Model model) {
		Account_DTO dto = account_IService.detailAccount(account_id);
		
		model.addAttribute("dto", dto);
		logger.info("Controller myPageForm {} // {}", dto, new Date());
		return "myPageForm";
	}
	
	// changePwForm.do
	@RequestMapping(value="/changePwForm.do", method=RequestMethod.GET)
	public String changePwForm() {
		logger.info("Controller changePwForm");
		return "changePwForm";
	}
	
	// changePw.do
	@RequestMapping(value="/changePw.do", method=RequestMethod.POST)
	public String changePw(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String account_pw = request.getParameter("account_pw");
		String change_pw = request.getParameter("change_pw");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_pw", account_pw);
		map.put("change_pw", change_pw);
		
		boolean isc = account_IService.changePw(map);
		logger.info("Controller changePw {} // {}", isc, new Date());
		return isc?"redirect:/logOut.do":"redirect:/changePwForm.do";
	}
	
	// modifyAccountForm.do
	@RequestMapping(value="/modifyAccountForm.do", method=RequestMethod.GET)
	public String modifyAccountForm(String account_id, Model model) {
		Account_DTO dto = account_IService.detailAccount(account_id);
		
		model.addAttribute("dto", dto);
		logger.info("Controller modifyAccountForm {} // {}", dto, new Date());
		return "modifyAccountForm";
	}
	
	// modifyAccount.do
	@RequestMapping(value="/modifyAccount.do", method=RequestMethod.POST)
	public String modifyAccount(HttpServletRequest request, Model model) {
		String account_id = request.getParameter("account_id");
		String account_phone = request.getParameter("account_phone");
		String account_email = request.getParameter("account_email");
		String account_position = request.getParameter("account_position");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_phone", account_phone);
		map.put("account_email", account_email);
		map.put("account_position", account_position);
		
		boolean isc = account_IService.modifyAccount(map);
		logger.info("Controller modifyAccount {} // {}", isc, new Date());
		
		Account_DTO dto = account_IService.detailAccount(account_id);
		
		model.addAttribute("dto", dto);
		logger.info("Controller modifyAccountForm {} // {}", dto, new Date());
		
		return "myPageForm";
	}
	
	// deleteAccount.do
	@RequestMapping(value="/deleteAccount.do", method=RequestMethod.POST)
	public String deleteAccount(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		
		boolean isc = account_IService.deleteAccount(account_id);
		logger.info("Controller deleteAccount {} // {}", isc, new Date());
		return isc?"redirect:/logOut.do":"modifyAccountForm";
	}
	
	// accountList.do
	@RequestMapping(value="/accountList.do", method={RequestMethod.GET,RequestMethod.POST})
	public String accountList(Pagination paging, Model model) {
		logger.info("Controller accountList");
		logger.info("페이징 시작하는 곳 {}", new Date());
		logger.info("전송받은 Pagination 값 : "+paging);
		
		List<Account_DTO> lists = account_IService.accountListRow(paging);
		paging.setTotal(account_IService.accountListTotal());
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", paging);
		logger.info("=========================================페이징 Pagination 값"+paging);
		
		return "accountList";
	}
	
	// accountSearchList.do
	@RequestMapping(value="/accountSearchList.do", method=RequestMethod.GET)
	public String accountSearchList(Pagination paging, Model model) {
		logger.info("Controller accountSearchList");
		logger.info("페이징 시작하는 곳 {}", new Date());
		logger.info("전송받은 Pagination 값 : "+paging);
		
		List<Account_DTO> lists = account_IService.accountSearchListRow(paging);
		paging.setTotal(account_IService.accountSearchListTotal(paging));
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", paging);
		logger.info("=========================================페이징 Pagination 값"+paging);
		
		return "accountSearchList";
	}
	
	// detailAccount.do
	@RequestMapping(value="/detailAccount.do", method=RequestMethod.GET)
	public String detailAccount(HttpServletRequest request, Model model) {
		String account_id = request.getParameter("account_id");
		
		Account_DTO dto = account_IService.detailAccount(account_id);
		
		model.addAttribute("dto", dto);
		logger.info("Controller detailAccount {} // {}", dto, new Date());
		return "detailAccount";
	}
	
	// changeAuthForm.do
	@RequestMapping(value="/changeAuthForm.do", method={RequestMethod.GET,RequestMethod.POST})
	public String changeAuthForm(Pagination paging, Model model) {
		logger.info("Controller changeAuthForm");
		logger.info("페이징 시작하는 곳 {}", new Date());
		logger.info("전송받은 Pagination 값 : "+paging);
		
		List<Account_DTO> lists = account_IService.accountListRow(paging);
		paging.setTotal(account_IService.accountListTotal());
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", paging);
		logger.info("=========================================페이징 Pagination 값"+paging);
		
		return "changeAuthForm";
	}
	
	// changeAuth.do
	@RequestMapping(value="/changeAuth.do", method=RequestMethod.POST)
	public String changeAuth(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String auth = request.getParameter("auth");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("auth", auth);
		
		boolean isc = account_IService.changeAuth(map);
		logger.info("Controller modifyAccount {} // {}", isc, new Date());
		return "redirect:/accountList.do";
	}
	
	// paging.do
	@RequestMapping(value="/paging.do", method=RequestMethod.POST, 
			produces="application/text; charset=UTF-8")
	@ResponseBody
	public String paging(Model model, HttpSession session, Pagination pgDto) {
		Account_DTO dto = (Account_DTO)session.getAttribute("acc");
		logger.info("Controlle paging {}", (Account_DTO)session.getAttribute("acc"));
		JSONObject json = null;
		
		if (dto.getAuth().trim().equalsIgnoreCase("S")) {
			pgDto.setTotal(account_IService.accountListTotal());
			// 사용자 조회 객체 -> JSON으로 담음
			json = objectJson(account_IService.accountListRow(pgDto), pgDto, dto);
		}
		
		session.removeAttribute("pg");
		session.setAttribute("pg", pgDto);
		logger.info("Controller paging {}", json.toString());
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject objectJson(List<Account_DTO> lists, Pagination pg, Account_DTO acc) {
		JSONObject json = new JSONObject();
		JSONArray jLists = new JSONArray();
		JSONObject jList = null;
		
		for (Account_DTO dto : lists) {
			jList = new JSONObject();
			jList.put("account_id", dto.getAccount_id());
			jList.put("account_pw", dto.getAccount_pw());
			jList.put("account_name", dto.getAccount_name());
			jList.put("account_phone", dto.getAccount_phone());
			jList.put("account_email", dto.getAccount_email());
			jList.put("empno", dto.getEmpno());
			jList.put("account_position", dto.getAccount_position());
			jList.put("auth", dto.getAuth());
			jList.put("account_delfag", dto.getAccount_delfag());
			jList.put("account_regdate", dto.getAccount_regdate());
			jList.put("accid", acc.getAccount_id());
			
			jLists.add(jList);
		}
		
		// 페이징
		
		jList = new JSONObject();
		jList.put("pageList", pg.getPageList() );
		jList.put("index", pg.getIndex());
		jList.put("pageNum", pg.getPageNum());
		jList.put("listNum", pg.getListNum());
		jList.put("total", pg.getTotal());
		jList.put("count", pg.getCount());
		
		json.put("lists", jLists);
		json.put("pg", jList);
		
		return json;
	}

}
