package com.cafe24.ecoshaur.payment;

public class CartDTO {
  private int cart_no;
  private String id;
  private String product_no;
  private int quantity;
  private String rental_period;
  private String receipt_date;
  private String cart_date;
  private int total_price;
  
  
  public CartDTO() { }


  public CartDTO(int cart_no, String id, String product_no, int quantity, String rental_period, String receipt_date,
      String cart_date, int total_price) {
    this.cart_no = cart_no;
    this.id = id;
    this.product_no = product_no;
    this.quantity = quantity;
    this.rental_period = rental_period;
    this.receipt_date = receipt_date;
    this.cart_date = cart_date;
    this.total_price = total_price;
  }


  public int getCart_no() {
    return cart_no;
  }


  public void setCart_no(int cart_no) {
    this.cart_no = cart_no;
  }


  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getProduct_no() {
    return product_no;
  }


  public void setProduct_no(String product_no) {
    this.product_no = product_no;
  }


  public int getQuantity() {
    return quantity;
  }


  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


  public String getRental_period() {
    return rental_period;
  }


  public void setRental_period(String rental_period) {
    this.rental_period = rental_period;
  }


  public String getReceipt_date() {
    return receipt_date;
  }


  public void setReceipt_date(String receipt_date) {
    this.receipt_date = receipt_date;
  }


  public String getCart_date() {
    return cart_date;
  }


  public void setCart_date(String cart_date) {
    this.cart_date = cart_date;
  }


  public int getTotal_price() {
    return total_price;
  }


  public void setTotal_price(int total_price) {
    this.total_price = total_price;
  }
  
}
