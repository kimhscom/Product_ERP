package com.happy.erp.beans;

import com.happy.erp.dto.Account_DTO;

public class InputList {
	
	private Account_DTO acc;

	public void setAcc(Account_DTO acc) {
		this.acc = acc;
	}
	
	// 날짜 포멧 변경(2019-04-04 2:11:12.0) -> 2019-04-04
	private String dateFormat(String date) {
		return date.substring(0, date.indexOf(" "));
	}

}
