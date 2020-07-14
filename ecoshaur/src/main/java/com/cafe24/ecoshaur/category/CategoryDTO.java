package com.cafe24.ecoshaur.category;

public class CategoryDTO {
  private String major;
  private String minor;
  private String code;
  
  public CategoryDTO() { }

  public CategoryDTO(String major, String minor, String code) {
    this.major = major;
    this.minor = minor;
    this.code = code;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMinor() {
    return minor;
  }

  public void setMinor(String minor) {
    this.minor = minor;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
  
  
  
}
