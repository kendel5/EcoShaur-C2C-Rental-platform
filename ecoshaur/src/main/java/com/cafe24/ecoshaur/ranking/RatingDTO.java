package com.cafe24.ecoshaur.ranking;


public class RatingDTO {
  private String no;
  private String id_give;
  private String id_receive;
  private String evaluation;
  private String rated_date;
  
  public RatingDTO() {}
  
  public RatingDTO(String no, String id_give, String id_receive, String evaluation, String rated_date) {
	  this.no = no;
	  this.id_give = id_give;
	  this.id_receive = id_receive;
	  this.evaluation = evaluation;
	  this.rated_date = rated_date;
  }

  public String getNo() {
	  return no;
  }

  public void setNo(String no) {
	  this.no = no;
  }

  public String getId_give() {
	  return id_give;
  }

  public void setId_give(String id_give) {
	  this.id_give = id_give;
  }

  public String getId_receive() {
	  return id_receive;
  }

  public void setId_receive(String id_receive) {
	  this.id_receive = id_receive;
  }

  public String getEvaluation() {
	  return evaluation;
  }

  public void setEvaluation(String evaluation) {
	  this.evaluation = evaluation;
  }

  public String getRated_date() {
	  return rated_date;
  }

  public void setRated_date(String rated_date) {
	  this.rated_date = rated_date;
  }

  

}
