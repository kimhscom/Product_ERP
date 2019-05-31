package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import com.happy.erp.dto.Account_DTO;
import com.happy.erp.dto.Pagination;
import com.happy.erp.dto.SearchPagination;

public interface Account_Interface {
	
	// insertAccount : 사용자 등록
	public boolean insertAccount(Account_DTO dto);
	
	// idCheck : 사용자 중복체크
	public boolean idCheck(String account_id);
	
	// getLogin : 로그인
	public Account_DTO getLogin(Account_DTO dto);
	
	// findAccountPw : 비밀번호 찾기
	public boolean findAccountPw(Map<String, String> map);
	
	// changePw : 비밀번호 변경
	public boolean changePw(Map<String, String> map);
	
	// detailAccount : 사용자 상세조회
	public Account_DTO detailAccount(String account_id);
	
	// accountList : 사용자 전체조회
	public List<Account_DTO> accountList();
	
	// accountList : 사용자 전체조회(페이징)
	public List<Account_DTO> accountListRow(Pagination dto);
	
	// accountListRow : 사용자 총 인원 조회
	public int accountListTotal();
	
	// accountSearchListRow : 사용자 조건검색 조회(페이징)
	public List<Account_DTO> accountSearchListRow(SearchPagination dto);
	
	// accountSearchListTotal : 사용자 조건검색 총 인원 조회
	public int accountSearchListTotal(SearchPagination dto);
	
	// modifyAccount : 사용자 정보 수정
	public boolean modifyAccount(Map<String, String> map);
	
	// changeAuth : 사용자 권한 수정
	public boolean changeAuth(Map<String, String> map);
	
	// deleteAccount : 사용자 삭제
	public boolean deleteAccount(String account_id);

}
