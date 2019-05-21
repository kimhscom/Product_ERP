package com.happy.erp.dto;

import java.io.Serializable;

public class Account_DTO implements Serializable {
	
	private static final long serialVersionUID = -6125419951204468492L;
	private String account_id;
	private String account_pw;
	private String account_name;
	private String account_phone;
	private String account_email;
	private int account_code;
	private String account_position;
	private String auth;
	private String account_delfag;
	private String account_regdate;
	
	public Account_DTO() {
		
	}

	public Account_DTO(String account_id, String account_pw, String account_name, String account_phone,
			String account_email, int account_code, String account_position, String auth, String account_delfag,
			String account_regdate) {
		super();
		this.account_id = account_id;
		this.account_pw = account_pw;
		this.account_name = account_name;
		this.account_phone = account_phone;
		this.account_email = account_email;
		this.account_code = account_code;
		this.account_position = account_position;
		this.auth = auth;
		this.account_delfag = account_delfag;
		this.account_regdate = account_regdate;
	}
	
	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_phone() {
		return account_phone;
	}

	public void setAccount_phone(String account_phone) {
		this.account_phone = account_phone;
	}

	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}

	public int getAccount_code() {
		return account_code;
	}

	public void setAccount_code(int account_code) {
		this.account_code = account_code;
	}

	public String getAccount_position() {
		return account_position;
	}

	public void setAccount_position(String account_position) {
		this.account_position = account_position;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getAccount_delfag() {
		return account_delfag;
	}

	public void setAccount_delfag(String account_delfag) {
		this.account_delfag = account_delfag;
	}

	public String getAccount_regdate() {
		return account_regdate;
	}

	public void setAccount_regdate(String account_regdate) {
		this.account_regdate = account_regdate;
	}
	
	@Override
	public String toString() {
		return "Account_DTO [account_id=" + account_id + ", account_pw=" + account_pw + ", account_name=" + account_name
				+ ", account_phone=" + account_phone + ", account_email=" + account_email + ", account_code="
				+ account_code + ", account_position=" + account_position + ", auth=" + auth + ", account_delfag="
				+ account_delfag + ", account_regdate=" + account_regdate + "]";
	}

}
