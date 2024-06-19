package com.example.demo_lesson_OENk5IE5Et37.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "identitas")
public class Identitas {
  
  @Id
  @GeneratedValue
  @UuidGenerator
  private String id;

  @Column(name = "author")
  private String author;

  @Column(name = "img")
  private String img;

  @Column(name = "style")
  private String style;

  @Column(name = "is_actived")
  private Boolean isActived = true;

  @Column(name = "is_deleted")
  private Boolean isDeleted = false;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "code")
  private String code;

  @Column(name = "type")
  private String type;
  
  public Identitas() {
    
  }

  public Identitas(String author, String img, String style, Boolean isActived, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String code, String type) {
    this.author = author;
    this.img = img;
    this.style = style;
    this.isActived = isActived;
    this.isDeleted = isDeleted;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.code = code;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Boolean getIsActived() {
    return isActived;
  }

  public void setIsActived(Boolean isActived) {
    this.isActived = isActived;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
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

  @Override
  public String toString() {
    return "Identitas [id=" + id + ", author=" + author + ", img=" + img + ", style=" + style + ", isActived=" + isActived + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", code=" + code + ", type=" + type + "]";
  }

}
