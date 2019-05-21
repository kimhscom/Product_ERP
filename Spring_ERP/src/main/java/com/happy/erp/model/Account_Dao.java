package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.happy.erp.dto.Account_DTO;
import com.happy.erp.dto.Pagination;

@Repository
public class Account_Dao implements Account_Interface {

	private Logger logger = LoggerFactory.getLogger(Account_Dao.class);
	private final String NS = "com.happy.erp.Statement_Account.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean insertAccount(Account_DTO dto) {
		String encodePw = passwordEncoder.encode(dto.getAccount_pw());
		dto.setAccount_pw(encodePw);
		int n = sqlSession.insert(NS+"insertAccount", dto);
		return n>0? true:false;
	}

	@Override
	public boolean idCheck(String account_id) {
		int n = sqlSession.selectOne(NS+"idCheck", account_id);
		return n>0? true:false;
	}

	@Override
	public Account_DTO getLogin(Account_DTO dto) {
		String securityPw = sqlSession.selectOne(NS+"selStringPw", dto);
		
		if (passwordEncoder.matches(dto.getAccount_pw(), securityPw)) {
			dto.setAccount_pw(securityPw);
			System.out.println("비밀번호 일치");
			return sqlSession.selectOne(NS+"getLogin", dto);
		}else {
			System.out.println("비밀번호 불일치");
		}
				
		return null;
	}

	@Override
	public boolean findAccountPw(Map<String, String> map) {
		int n = sqlSession.update(NS+"findAccountPw", map);
		return n>0? true:false;
	}

	@Override
	public Account_DTO detailAccount(String account_id) {
		return sqlSession.selectOne(NS+"detailAccount", account_id);
	}

	@Override
	public List<Account_DTO> accountList(Pagination dto) {
		return sqlSession.selectList(NS+"accountList", dto);
	}

	@Override
	public int accountListRow() {
		return sqlSession.selectOne(NS+"accountListRow");
	}

	@Override
	public boolean modifyAccount(Map<String, String> map) {
		int n = sqlSession.update(NS+"modifyAccount", map);
		return n>0? true:false;
	}

	@Override
	public boolean changeAuth(Map<String, String> map) {
		int n = sqlSession.update(NS+"changeAuth", map);
		return n>0? true:false;
	}

	@Override
	public boolean deleteAccount(String account_id) {
		int n = sqlSession.update(NS+"deleteAccount", account_id);
		return n>0? true:false;
	}

}
