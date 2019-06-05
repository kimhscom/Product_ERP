package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.erp.dto.Item_DTO;
import com.happy.erp.dto.Pagination;

@Service
public class Item_Service implements Item_IService {
	
	private Logger logger = LoggerFactory.getLogger(Item_Service.class);
	
	@Autowired
	private Item_Interface item_Interface; 

	@Override
	public boolean insertItem(Item_DTO dto) {
		logger.info("품목 등록 insertItem {}", dto);
		return item_Interface.insertItem(dto);
	}

	@Override
	public List<Item_DTO> itemListRow(Pagination dto) {
		logger.info("품목 조회 itemListRow {}", dto);
		return item_Interface.itemListRow(dto);
	}

	@Override
	public int itemListTotal() {
		logger.info("품목 총 갯수 조회 itemListTotal");
		return item_Interface.itemListTotal();
	}

	@Override
	public Item_DTO detailItem(String item_code) {
		logger.info("품목 상세 조회 detailItem {}", item_code);
		return item_Interface.detailItem(item_code);
	}
	
	@Override
	public boolean modifyItem(Map<String, String> map) {
		logger.info("품목 수정 modifyItem {}", map);
		return item_Interface.modifyItem(map);
	}

	@Override
	public boolean deleteItem(String item_code) {
		logger.info("품목 삭제 deleteItem {}", item_code);
		return item_Interface.deleteItem(item_code);
	}


}
