package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.erp.dto.Account_DTO;
import com.happy.erp.dto.Pagination;
import com.happy.erp.dto.SearchPagination;

@Service
public class Account_Service implements Account_IService {
	
	private Logger logger = LoggerFactory.getLogger(Account_Service.class);
	
	@Autowired
	private Account_Interface account_Interface;
	
	@Override
	public boolean insertAccount(Account_DTO dto) {
		logger.info("사용자 등록 insertAccount {}", dto);
		return account_Interface.insertAccount(dto);
	}

	@Override
	public boolean idCheck(String account_id) {
		logger.info("사용자 중복체크 idCheck {}", account_id);
		return account_Interface.idCheck(account_id);
	}
	
	@Override
	public Account_DTO getLogin(Account_DTO dto) {
		logger.info("로그인 getLogin {}", dto);
		return account_Interface.getLogin(dto);
	}

	@Override
	public boolean findAccountPw(Map<String, String> map) {
		logger.info("비밀번호 찾기 findAccountPw {}", map);
		return account_Interface.findAccountPw(map);
	}

	@Override
	public boolean changePw(Map<String, String> map) {
		logger.info("비밀번호 변경 changePw {}", map);
		return account_Interface.changePw(map);
	}
		
	@Override
	public Account_DTO detailAccount(String account_id) {
		logger.info("사용자 상세조회 detailAccount {}", account_id);
		return account_Interface.detailAccount(account_id);
	}
	
	@Override
	public List<Account_DTO> accountList() {
		logger.info("사용자 전체조회 accountList");
		return account_Interface.accountList();
	}

	@Override
	public List<Account_DTO> accountListRow(Pagination dto) {
		logger.info("사용자 전체조회(페이징) accountListRow {}", dto);
		return account_Interface.accountListRow(dto);
	}

	@Override
	public int accountListTotal() {
		logger.info("사용자 총 인원 조회 accountListTotal");
		return account_Interface.accountListTotal();
	}

	@Override
	public List<Account_DTO> accountSearchListRow(SearchPagination dto) {
		logger.info("사용자 조건검색 조회(페이징) accountSearchListRow {}", dto);
		return account_Interface.accountSearchListRow(dto);
	}
	
	@Override
	public int accountSearchListTotal(SearchPagination dto) {
		logger.info("사용자 조건검색 총 인원 조회 accountSearchListTotal {}", dto);
		return account_Interface.accountSearchListTotal(dto);
	}
	
	@Override
	public boolean modifyAccount(Map<String, String> map) {
		logger.info("사용자 정보 수정 modifyAccount {}", map);
		return account_Interface.modifyAccount(map);
	}

	@Override
	public boolean changeAuth(Map<String, String> map) {
		logger.info("사용자 권한 수정 changeAuth {}", map);
		return account_Interface.changeAuth(map);
	}

	@Override
	public boolean deleteAccount(String account_id) {
		logger.info("사용자 삭제 deleteAccount {}", account_id);
		return account_Interface.deleteAccount(account_id);
	}


}
