package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import com.happy.erp.dto.Item_DTO;
import com.happy.erp.dto.Pagination;

public interface Item_Interface {
	
	// insertItem : 품목 등록
	public boolean insertItem(Item_DTO dto);
	
	// itemListRow : 품목 조회(페이징)
	public List<Item_DTO> itemListRow(Pagination dto);
	
	// itemListTotal : 품목 총 갯수 조회
	public int itemListTotal();
	
	// detailItem : 품목 상세 조회
	public Item_DTO detailItem(String item_code);
	
	// modifyItem : 품목 수정
	public boolean modifyItem(Map<String, String> map);
	
	// deleteItem : 품목 삭제
	public boolean deleteItem(String item_code);

}
