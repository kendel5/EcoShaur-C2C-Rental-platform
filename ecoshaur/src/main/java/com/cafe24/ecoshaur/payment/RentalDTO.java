package com.cafe24.ecoshaur.payment;

import org.springframework.web.multipart.MultipartFile;

public class RentalDTO {
  private String product_no;
  private String product_name;
  private String title;
  private String sub_title;
  private String description;
  private int price_daily;
  private int deposit;
  private int total_quantity;
  private int remaining_quantity;
  private String thmb_name;
  private long thmb_size;
  private String image_name;
  private long image_size;
  private String reg_date;
  private String id;
  private String category_code;
  private char availability;
//---------------------------------------  
  //1)스프링 파일 객체 멤버 변수 선언
  //<input type='file' name='posterMF'>
  private MultipartFile posterMF;
  
  //<input type='file' name='filenameMF'>
  private MultipartFile filenameMF;
  
  //2)getter와 setter작성
  public MultipartFile getPosterMF() {
    return posterMF;
  }

  public void setPosterMF(MultipartFile posterMF) {
    this.posterMF = posterMF;
  }

  public MultipartFile getFilenameMF() {
    return filenameMF;
  }

  public void setFilenameMF(MultipartFile filenameMF) {
    this.filenameMF = filenameMF;
  }
  
  //3)servlet-context.xml에 스프링빈 등록
//---------------------------------------
  
  public RentalDTO() { }


  public RentalDTO(String product_no, String product_name, String title, String sub_title, String description,
      int price_daily, int deposit, int total_quantity, int remaining_quantity, String thmb_name, long thmb_size,
      String image_name, long image_size, String reg_date, String id, String category_code, char availability) {
    this.product_no = product_no;
    this.product_name = product_name;
    this.title = title;
    this.sub_title = sub_title;
    this.description = description;
    this.price_daily = price_daily;
    this.deposit = deposit;
    this.total_quantity = total_quantity;
    this.remaining_quantity = remaining_quantity;
    this.thmb_name = thmb_name;
    this.thmb_size = thmb_size;
    this.image_name = image_name;
    this.image_size = image_size;
    this.reg_date = reg_date;
    this.id = id;
    this.category_code = category_code;
    this.availability = availability;
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


  public String getSub_title() {
    return sub_title;
  }


  public void setSub_title(String sub_title) {
    this.sub_title = sub_title;
  }


  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public int getPrice_daily() {
    return price_daily;
  }


  public void setPrice_daily(int price_daily) {
    this.price_daily = price_daily;
  }


  public int getDeposit() {
    return deposit;
  }


  public void setDeposit(int deposit) {
    this.deposit = deposit;
  }


  public int getTotal_quantity() {
    return total_quantity;
  }


  public void setTotal_quantity(int total_quantity) {
    this.total_quantity = total_quantity;
  }


  public int getRemaining_quantity() {
    return remaining_quantity;
  }


  public void setRemaining_quantity(int remaining_quantity) {
    this.remaining_quantity = remaining_quantity;
  }


  public String getThmb_name() {
    return thmb_name;
  }


  public void setThmb_name(String thmb_name) {
    this.thmb_name = thmb_name;
  }


  public long getThmb_size() {
    return thmb_size;
  }


  public void setThmb_size(long thmb_size) {
    this.thmb_size = thmb_size;
  }


  public String getImage_name() {
    return image_name;
  }


  public void setImage_name(String image_name) {
    this.image_name = image_name;
  }


  public long getImage_size() {
    return image_size;
  }


  public void setImage_size(long image_size) {
    this.image_size = image_size;
  }


  public String getReg_date() {
    return reg_date;
  }


  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
  }


  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getCategory_code() {
    return category_code;
  }


  public void setCategory_code(String category_code) {
    this.category_code = category_code;
  }


  public char getAvailability() {
    return availability;
  }


  public void setAvailability(char availability) {
    this.availability = availability;
  }
  
  
  
  
  
  
  
  
  
  
}
