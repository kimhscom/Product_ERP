package com.happy.erp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.erp.dto.Account_DTO;
import com.happy.erp.dto.Pagination;
import com.happy.erp.model.Account_IService;

@Controller
public class AccountTest_Ctrl {
	
	@Autowired
	private Account_IService service;
	
	@RequestMapping(value="/insertAccount.do", method=RequestMethod.GET)
	public String insertAccount(Account_DTO dto) {
		boolean isc = service.insertAccount(dto);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/idCheck.do", method=RequestMethod.GET)
	public String idCheck(String account_id) {
		boolean isc = service.idCheck(account_id);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/getLogin.do", method=RequestMethod.GET)
	public String getLogin(Account_DTO dto) {
		Account_DTO ldto = service.getLogin(dto);
		System.out.println(ldto+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/findAccountPw.do", method=RequestMethod.GET)
	public String findAccountPw(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String account_email = request.getParameter("account_email");
		String temp_pw = request.getParameter("temp_pw");
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_email", account_email);
		map.put("temp_pw", temp_pw);
		boolean isc = service.findAccountPw(map);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/changePw.do", method=RequestMethod.GET)
	public String changePw(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String account_pw = request.getParameter("account_pw");
		String change_pw = request.getParameter("change_pw");
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_pw", account_pw);
		map.put("change_pw", change_pw);
		boolean isc = service.changePw(map);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/detailAccount.do", method=RequestMethod.GET)
	public String detailAccount(String account_id) {
		Account_DTO dto = service.detailAccount(account_id);
		System.out.println(dto+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/accountListTotal.do", method=RequestMethod.GET)
	public String accountListTotal() {
		int n = service.accountListTotal();
		System.out.println(n+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	// class not found excepssion 문제 해결할 것
//	@RequestMapping(value="/accountListRow.do", method=RequestMethod.GET)
//	public String accountListRow() {
//		Pagination pdto = new Pagination();
//		int total = service.accountListTotal();
//		pdto.setTotal(total);
//		
//		List<Account_DTO> lists = service.accountListRow(pdto);
//		System.out.println(lists.size()+"$$$$$$$$$$$$$$$$$$$$");	
//		System.out.println(lists+"$$$$$$$$$$$$$$$$$$$$");						
//		return null;
//	}
	
	@RequestMapping(value="/modifyAccount.do", method=RequestMethod.GET)
	public String modifyAccount(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String account_phone = request.getParameter("account_phone");
		String account_email = request.getParameter("account_email");
		String account_position = request.getParameter("account_position");
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("account_phone", account_phone);
		map.put("account_email", account_email);
		map.put("account_position", account_position);
		boolean isc = service.modifyAccount(map);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/changeAuth.do", method=RequestMethod.GET)
	public String changeAuth(HttpServletRequest request) {
		String account_id = request.getParameter("account_id");
		String auth = request.getParameter("auth");
		Map<String, String> map = new HashMap<String, String>();
		map.put("account_id", account_id);
		map.put("auth", auth);
		boolean isc = service.changeAuth(map);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/deleteAccount.do", method=RequestMethod.GET)
	public String deleteAccount(String account_id) {
		boolean isc = service.deleteAccount(account_id);
		System.out.println(isc+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	
}
