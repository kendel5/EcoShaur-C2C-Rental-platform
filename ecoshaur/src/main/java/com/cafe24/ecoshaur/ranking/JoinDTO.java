package com.cafe24.ecoshaur.ranking;


public class JoinDTO {
  private String id; 			//포인트
  private String pro_name;		//포인트, 좋아요
  private String mem_name;		//포인트, 좋아요
  private String grade;			//포인트, 좋아요
  private int point;			//포인트
  private String evaluation;	//좋아요
  private String id_receive;	//좋아요
  private int count;			//좋아요

  
  public JoinDTO() {}
  
  public JoinDTO(String id, String pro_name, String mem_name, String grade, int point, String evaluation, String id_receive, int count) {
	  this.id = id;
	  this.pro_name = pro_name;
	  this.mem_name = mem_name;
	  this.grade = grade;
	  this.point = point;
	  this.evaluation = evaluation;
	  this.id_receive = id_receive;
	  this.count = count;
  }

  public String getId() {
	  return id;
  }

  public void setId(String id) {
	  this.id = id;
  }

  public String getPro_name() {
	  return pro_name;
  }

  public void setPro_name(String pro_name) {
	  this.pro_name = pro_name;
  }

  public String getMem_name() {
	  return mem_name;
  }

  public void setMem_name(String mem_name) {
	  this.mem_name = mem_name;
  }

  public String getGrade() {
	  return grade;
  }

  public void setGrade(String grade) {
	  this.grade = grade;
  }

  public int getPoint() {
	  return point;
  }

  public void setPoint(int point) {
	  this.point = point;
  }

  public String getEvaluation() {
	  return evaluation;
  }

  public void setEvaluation(String evaluation) {
	  this.evaluation = evaluation;
  }

  public String getId_receive() {
	  return id_receive;
  }

  public void setId_receive(String id_receive) {
	  this.id_receive = id_receive;
  }

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}
 
  
}
