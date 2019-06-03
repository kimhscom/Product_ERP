package com.happy.erp.dto;

import java.io.Serializable;

public class Pagination implements Serializable {
	
	private static final long serialVersionUID = 1765323223561490640L;
	private int pageList; // 출력할 페이지 번호 갯수
	private int index; // 출력할 페이지 번호
	private int pageNum; // 출력할 페이지 시작번호
	private int listNum; // 출력할 리스트 갯수
	private int total; // 리스트 총갯수
	private String searchType; // 검색타입
	private String keyword; // 키워드
	
	{
		pageList = 10;
		index = 0;
		pageNum = 1;
		listNum = 10;
	}

	public Pagination() {
		super();
	}

	public Pagination(String index, String pageNum, String listNum) {
		if(index != null) {
			this.index = Integer.parseInt(index);
		}
		if(pageNum != null) {
			this.pageNum = Integer.parseInt(pageNum);
		}
		if(listNum != null) {
			this.listNum = Integer.parseInt(listNum);
		}
		
		this.index = Integer.parseInt(index);
		this.pageNum = Integer.parseInt(pageNum);
		this.listNum = Integer.parseInt(listNum);
		
	}
	
	public int getStart() {
		return index*listNum+1;
	}
	
	public int getLast() {
		return (index*listNum)+listNum;
	}
	
	public int getCount() {
		int temp = total-listNum*(pageNum-1);
		int min = temp/listNum;
		int count = 0;
		
		if (temp%listNum != 0) {
			min++;
		}
		
		if (temp <= listNum) {
			count = pageNum;
		}else if(min <= pageList) {
			count = min+pageNum-1;
		}else {
			count = pageList+pageNum-1;
		}
		
		return count;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}	

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
		return "Pagination [pageList=" + pageList + ", index=" + index + ", pageNum=" + pageNum + ", listNum=" + listNum
				+ ", total=" + total + ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}	
		

}
