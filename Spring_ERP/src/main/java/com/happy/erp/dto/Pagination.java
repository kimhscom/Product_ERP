package com.happy.erp.dto;

import java.io.Serializable;

public class Pagination implements Serializable {
	
	private static final long serialVersionUID = -4588857943479144861L;
	private int page; // 현재 선택된 페이지
	private int countList; // 페이지 당 몇 개의 게시글을 보여줄 것인지
	private int totalCount; // 총 게시글, 글의 갯수
	private int countPage; // 화면에 몇 개의 페이지를 보여줄 것인지
	private int totalPage; // 총 페이지 갯수
	private int startPage; // 현재 회면의 시작 페이지 번호, 쪼꼬만 화살표 때문에 필요함
	private int endPage; // 현재 화면의 끝 페이지 번호, 쪼꼬만 화살표 때문에 필요함
	
	public Pagination() {
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (totalPage < page) {
			page = totalPage;
		}
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		// 총 개시글 수 / 페이지당 보여줄 개시글 갯수
		// ex) 총 개시글 27 / 페이지당 보여줄 개시글 갯수 3 = 9
		// 총 페이지 갯수는 9
		int totalPageResult=totalCount / countList;
		
		// 만약 나머지가 있을 경우 페이지를  추가하는 처리
		// ex) 총 게시글 26 / 페이지당 보여줄 개시글 3 = 8 나머지 2
		// 나머지 2개를 보여줄 페이지가 필요하므로
		// 페이지는 9가 되어야 함 그러므로 1을 더해준 것
		if (totalCount % countList > 0) {
			totalPageResult++;
		}
		
		this.totalPage = totalPageResult;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int page) {
		int startPageResult = ((page -1) / countPage) * countPage + 1;
		
		this.startPage = startPageResult;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int countPage) {
		int endPageResult = startPage + countPage - 1;
		
		if (endPageResult > totalPage) {
			endPageResult = totalPage;
		}
		
		this.endPage = endPageResult;
	}

	@Override
	public String toString() {
		return "Pagination [page=" + page + ", countList=" + countList + ", totalCount=" + totalCount + ", countPage="
				+ countPage + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	

}
