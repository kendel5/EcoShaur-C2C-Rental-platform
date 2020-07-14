package com.cafe24.ecoshaur.community;

import org.springframework.web.multipart.MultipartFile;

public class NoticeDTO {
	//공지사항
	private int postno;
	private String head;
	private String title;
	private String contents; 
	private String image_name;
	private String post_date;
	private int view;
	
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
	
	public NoticeDTO() { }
	
	public NoticeDTO(int postno, String head, String title, String contents, String image_name,
      String post_date, int view) {
    this.postno = postno;
    this.head = head;
    this.title = title;
    this.contents = contents;
    this.image_name = image_name;
    this.post_date = post_date;
    this.view = view;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [postno=" + postno + ", head=" + head + ", title=" + title + ", contents=" + contents
				+ ", image_name=" + image_name + ", post_date=" + post_date + ", view=" + view + "]";
	}
}
