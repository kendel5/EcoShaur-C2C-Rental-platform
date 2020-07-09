package com.cafe24.ecoshaur.admin;

public class PointDTO {
  private int no;
  private String id;
  private int point;
  private String date;

  public PointDTO() {
  }

  public PointDTO(int no, String id, int point, String date) {
    this.no = no;
    this.id = id;
    this.point = point;
    this.date = date;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
