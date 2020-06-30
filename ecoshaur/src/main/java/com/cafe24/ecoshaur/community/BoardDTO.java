package com.cafe24.ecoshaur.community;

public class BoardDTO {
	//자유게시판
	private int postno;
	private String title;
	private String contents;
	private String image_name;
	private long image_size;
	private String post_date;
	private String id;
	private int view;
	private int good;
	private int bad;
	
	public BoardDTO() { }
	
	public BoardDTO(int postno, String title, String contents, String image_name, long image_size, String post_date,
      String id, int view, int good, int bad) {
    this.postno = postno;
    this.title = title;
    this.contents = contents;
    this.image_name = image_name;
    this.image_size = image_size;
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
