package com.cafe24.ecoshaur.admin;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String id;
	private String mem_name;
	private String pw;
	private String birth;
	private String contact_number;
	private String email;
	private String zip;
	private String address;
	private String address_r;
	private String grade;
	private String joined_date;
	private String lastdate;
	private String pro_name;
	private MultipartFile pro_name1;
	public MemberDTO() { }
	
	
	
  public MemberDTO(String id, String mem_name, String pw, String birth, String contact_number, String email, String zip,
      String address, String address_r, String grade, String joined_date, String lastdate, String pro_name, MultipartFile pro_name1) {
    super();
    this.id = id;
    this.mem_name = mem_name;
    this.pw = pw;
    this.birth = birth;
    this.contact_number = contact_number;
    this.email = email;
    this.zip = zip;
    this.address = address;
    this.address_r = address_r;
    this.grade = grade;
    this.joined_date = joined_date;
    this.lastdate = lastdate;
    this.pro_name=pro_name;
    this.pro_name1=pro_name1;
  }



  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_r() {
		return address_r;
	}
	public void setAddress_r(String address_r) {
		this.address_r = address_r;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(String joined_date) {
		this.joined_date = joined_date;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}



  public MultipartFile getPro_name1() {
    return pro_name1;
  }



  public void setPro_name1(MultipartFile pro_name1) {
    this.pro_name1 = pro_name1;
  }
	

}
