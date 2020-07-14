package com.cafe24.ecoshaur.home;

public class HomeDTO {
  private String id;
  private String mem_name;
  private String pw;
  private String birth;
  private String contact_number;
  private String email;
  private char zip;
  private String address;
  private String address_r;
  private char grade;
  private String joined_date;
  private String lastdate;
  
  
  
  public HomeDTO() { }



  public HomeDTO(String iD, String mEM_NAME, String pW, String bIRTH, String cONTACT_NUMBER, String eMAIL, char zIP,
      String aDDRESS, String aDDRESS_R, char gRADE, String jOINED_DATE, String lASTDATE) {
    id = iD;
    mem_name = mEM_NAME;
    pw = pW;
    birth = bIRTH;
    contact_number = cONTACT_NUMBER;
    email = eMAIL;
    zip = zIP;
    address = aDDRESS;
    address_r = aDDRESS_R;
    grade = gRADE;
    joined_date = jOINED_DATE;
    lastdate = lASTDATE;
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



  public char getZip() {
    return zip;
  }



  public void setZip(char zip) {
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



  public char getGrade() {
    return grade;
  }



  public void setGrade(char grade) {
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



  
  
  
  
}
