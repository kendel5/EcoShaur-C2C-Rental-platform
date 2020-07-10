package com.cafe24.ecoshaur.member;

public class MypageDTO {
	private String id_receive;
	private String product_no;
	private String product_name;
	private String title;
	private String reg_date;
	
	public MypageDTO() {}
	
	public MypageDTO(String id_receive, String product_no, String product_name, String title, String reg_date) {
		this.id_receive = id_receive;
		this.product_no = product_no;
		this.product_name = product_name;
		this.title = title;
		this.reg_date = reg_date;
	}

	public String getId_receive() {
		return id_receive;
	}

	public void setId_receive(String id_receive) {
		this.id_receive = id_receive;
	}

	public String getProduct_no() {
		return product_no;
	}

	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}
