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
	
	// temp_pw(임시비밀번호) 암호화 필요!!!
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
	
	@RequestMapping(value="/detailAccount.do", method=RequestMethod.GET)
	public String detailAccount(String account_id) {
		Account_DTO dto = service.detailAccount(account_id);
		System.out.println(dto+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	@RequestMapping(value="/accountListRow.do", method=RequestMethod.GET)
	public String accountListRow() {
		int n = service.accountListRow();
		System.out.println(n+"$$$$$$$$$$$$$$$$$$$$");
		return null;
	}
	
	// class not found excepssion 문제 해결할 것
	@RequestMapping(value="/accountList.do", method=RequestMethod.GET)
	public String accountList() {
		Pagination pdto = new Pagination();
		int total = service.accountListRow();
		pdto.setTotal(total);
		
		List<Account_DTO> lists = service.accountList(pdto);
		System.out.println(lists.size()+"$$$$$$$$$$$$$$$$$$$$");	
		System.out.println(lists+"$$$$$$$$$$$$$$$$$$$$");						
		return null;
	}
	
	
}
