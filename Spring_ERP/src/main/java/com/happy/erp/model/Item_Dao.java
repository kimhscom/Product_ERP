package com.happy.erp.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy.erp.dto.Item_DTO;
import com.happy.erp.dto.Pagination;

@Repository
public class Item_Dao implements Item_Interface {
	
	private Logger logger = LoggerFactory.getLogger(Item_Dao.class);
	private final String NS = "com.happy.erp.Statement_Item.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public boolean insertItem(Item_DTO dto) {
		int n = sqlSession.insert(NS+"insertItem", dto);
		return n>0? true:false;
	}

	@Override
	public List<Item_DTO> itemListRow(Pagination dto) {
		return sqlSession.selectList(NS+"itemListRow", dto);
	}

	@Override
	public int itemListTotal() {
		return sqlSession.selectOne(NS+"itemListTotal");
	}

	@Override
	public Item_DTO detailItem(String item_code) {
		return sqlSession.selectOne(NS+"detailItem", item_code);
	}
	
	@Override
	public boolean modifyItem(Map<String, String> map) {
		int n = sqlSession.update(NS+"modifyItem", map);
		return n>0? true:false;
	}

	@Override
	public boolean deleteItem(String item_code) {
		int n = sqlSession.update(NS+"deleteItem", item_code);
		return n>0? true:false;
	}


}
