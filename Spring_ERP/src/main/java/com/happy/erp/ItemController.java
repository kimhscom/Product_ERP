package com.happy.erp;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.erp.dto.Item_DTO;
import com.happy.erp.dto.Pagination;
import com.happy.erp.model.Item_IService;

@Controller
public class ItemController {
	
	private Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private Item_IService item_IService;
	
	// itemList.do
	@RequestMapping(value="/itemList.do", method=RequestMethod.GET)
	public String itemList(Pagination paging, Model model) {
		logger.info("Controller itemList");
		logger.info("페이징 시작하는 곳 {}", new Date());
		logger.info("전송받은 Pagination 값 : "+paging);
		
		List<Item_DTO> lists = item_IService.itemListRow(paging);
		paging.setTotal(item_IService.itemListTotal());
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", paging);
		logger.info("=========================================페이징 Pagination 값"+paging);
		
		return "itemList";
	}
	
	// insertItem.do
	@RequestMapping(value="/insertItem.do", method=RequestMethod.POST)
	public String insertItem(Item_DTO dto) {
		logger.info("Controller insertItem {}", dto);
		boolean isc = item_IService.insertItem(dto);
		return "redirect:itemList.do";
	}
	
	// detailItemForm.do
	@RequestMapping(value="/detailItemForm.do", method=RequestMethod.GET)	
	public String detailItemForm(String item_code, Model model) {
		Item_DTO dto = item_IService.detailItem(item_code);
		
		model.addAttribute("item", dto);
		logger.info("Controller detailItemForm {} // {}", dto, new Date());
		return "detailItemForm";
	}

}
