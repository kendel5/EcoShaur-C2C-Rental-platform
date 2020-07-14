package com.cafe24.ecoshaur.community;

import org.springframework.web.multipart.MultipartFile;

public class QnaDTO {

  private int postno;
  private String head;
  private String title;
  private String contents;
  private String image_name;
  private String post_date;
  private String id;
  private int pcode;
  private int ccode;
  
  //1)스프링 파일 객체 멤버 변수 선언
  //<input type='file' name='posterMF'>
  private MultipartFile posterMF;
 
  //2)getter와 setter작성
  public MultipartFile getPosterMF() {
    return posterMF;
  }

  public void setPosterMF(MultipartFile posterMF) {
    this.posterMF = posterMF;
  }
  
  public QnaDTO() { }

  public QnaDTO(int postno, String head, String title, String contents, String image_name,
      String post_date, String id, int pcode, int ccode) {
    super();
    this.postno = postno;
    this.head = head;
    this.title = title;
    this.contents = contents;
    this.image_name = image_name;
    this.post_date = post_date;
    this.id = id;
    this.pcode = pcode;
    this.ccode = ccode;
  }

  public int getPostno() {
    return postno;
  }

  public void setPostno(int postno) {
    this.postno = postno;
  }

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getImage_name() {
    return image_name;
  }

  public void setImage_name(String image_name) {
    this.image_name = image_name;
  }

  public String getPost_date() {
    return post_date;
  }

  public void setPost_date(String post_date) {
    this.post_date = post_date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPcode() {
    return pcode;
  }

  public void setPcode(int pcode) {
    this.pcode = pcode;
  }

  public int getCcode() {
    return ccode;
  }

  public void setCcode(int ccode) {
    this.ccode = ccode;
  }

  
}