package com.example.demo_lesson_OENk5IE5Et37.payloads.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BahanRequest {
  
  @NotNull(message = "title shouldn't be null")
  @NotBlank(message = "title shouldn't be null")
  private String title;

  @NotNull(message = "source shouldn't be null")
  @NotBlank(message = "source shouldn't be null")
  private String source;

  @NotNull(message = "code shouldn't be null")
  @NotBlank(message = "code shouldn't be null")
  private String code;

  @NotNull(message = "type shouldn't be null")
  @NotBlank(message = "type shouldn't be null")
  private String type;

  @NotNull(message = "point shouldn't be null")
  @NotBlank(message = "point shouldn't be null")
  private Integer point;

  public BahanRequest() {

  }

  public BahanRequest(String title, String source, String code, String type, Integer point) {
    this.title = title;
    this.source = source;
    this.code = code;
    this.type = type;
    this.point = point;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

}
