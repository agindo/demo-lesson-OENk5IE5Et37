package com.example.demo_lesson_OENk5IE5Et37.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "bahan")
public class Bahan {
  
  @Id
  @GeneratedValue
  @UuidGenerator
  private String id;

  @Column(name = "title")
  private String title;

  @Column(name = "source")
  private String source;

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

  @Column(name = "point")
  private Integer point;

  public Bahan() {
    
  }

  public Bahan(String title, String source, Boolean isActived, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String code, String type, Integer point) {
    this.title = title;
    this.source = source;
    this.isActived = isActived;
    this.isDeleted = isDeleted;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.code = code;
    this.type = type;
    this.point = point;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  @Override
  public String toString() {
    return "Bahan [id=" + id + ", title=" + title + ", source=" + source + ", isActived=" + isActived + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", code=" + code + ", type=" + type + ", point=" + point + "]";
  }

}
