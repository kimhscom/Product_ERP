package com.happy.erp.dto;

public class SearchPagination extends Pagination { // Pagination class 상속
	
	private String searchType; // 검색타입
	private String keyword; // 키워드
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return super.toString() + "SearchPagination [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	

}
