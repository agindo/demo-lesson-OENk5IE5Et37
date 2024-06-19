package com.example.demo_lesson_OENk5IE5Et37.payloads.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SubmateriRequest {
  
  @NotNull(message = "title shouldn't be null")
  @NotBlank(message = "title shouldn't be null")
  private String title;

  @NotNull(message = "description shouldn't be null")
  @NotBlank(message = "description shouldn't be null")
  private String description;

  @NotNull(message = "code shouldn't be null")
  @NotBlank(message = "code shouldn't be null")
  private String code;

  @NotNull(message = "type shouldn't be null")
  @NotBlank(message = "type shouldn't be null")
  private String type;

  public SubmateriRequest() {

  }

  public SubmateriRequest(String title, String description, String code, String type) {
    this.title = title;
    this.description = description;
    this.code = code;
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
