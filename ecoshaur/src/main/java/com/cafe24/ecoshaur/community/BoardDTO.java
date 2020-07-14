package com.cafe24.ecoshaur.community;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	//자유게시판
	private int postno;
	private String title;
	private String contents;
	private String image_name;
	private String post_date;
	private String id;
	private int view;
	private int good;
	private int bad;
	
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
	
	public BoardDTO() { }
	
	public BoardDTO(int postno, String title, String contents, String image_name, String post_date,
      String id, int view, int good, int bad) {
    this.postno = postno;
    this.title = title;
    this.contents = contents;
    this.image_name = image_name;
    this.post_date = post_date;
    this.id = id;
    this.view = view;
    this.good = good;
    this.bad = bad;
  }

  public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	
}
