package com.example.demo_lesson_OENk5IE5Et37.payloads.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class IdentitasRequest {
  
  @NotNull(message = "author shouldn't be null")
  @NotBlank(message = "author shouldn't be null")
  private String author;

  @NotNull(message = "img shouldn't be null")
  @NotBlank(message = "img shouldn't be null")
  private String img;

  @NotNull(message = "style shouldn't be null")
  @NotBlank(message = "style shouldn't be null")
  private String style;

  @NotNull(message = "code shouldn't be null")
  @NotBlank(message = "code shouldn't be null")
  private String code;

  @NotNull(message = "type shouldn't be null")
  @NotBlank(message = "type shouldn't be null")
  private String type;

  public IdentitasRequest() {

  }

  public IdentitasRequest(String author, String img, String style, String code, String type) {
    this.author = author;
    this.img = img;
    this.style = style;
    this.code = code;
    this.type = type;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
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

}
