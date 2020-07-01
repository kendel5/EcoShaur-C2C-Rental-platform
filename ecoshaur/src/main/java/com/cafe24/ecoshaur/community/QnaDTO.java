package com.cafe24.ecoshaur.community;

public class QnaDTO {

	private int postno;
	private char head;
	private String title;
	private String contents;
	private String image_name;
	private long image_size;
	private String post_date;
	private String id;
	private int pcode;
	
  public QnaDTO() { }

  public QnaDTO(int postno, char head, String title, String contents, String image_name, long image_size,
      String post_date, String id, int pcode) {
    this.postno = postno;
    this.head = head;
    this.title = title;
    this.contents = contents;
    this.image_name = image_name;
    this.image_size = image_size;
    this.post_date = post_date;
    this.id = id;
    this.pcode = pcode;
  }

  public int getPostno() {
    return postno;
  }

  public void setPostno(int postno) {
    this.postno = postno;
  }

  public char getHead() {
    return head;
  }

  public void setHead(char head) {
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

  public long getImage_size() {
    return image_size;
  }

  public void setImage_size(long image_size) {
    this.image_size = image_size;
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
	
  
	
	
	
}