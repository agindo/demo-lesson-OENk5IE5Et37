package com.example.demo_lesson_OENk5IE5Et37.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "materi")
public class Materi {
  
  @Id
  @GeneratedValue
  @UuidGenerator
  private String id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

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

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "materi_id")
  private Set<Submateri> submateri = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "materi_id")
  private Set<Identitas> identitas = new HashSet<>();

  public Materi() {

  }

  public Materi(String title, String description, Boolean isActived, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String code, String type) {
    this.title = title;
    this.description = description;
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

  public Set<Submateri> getSubmateri() {
    return submateri;
  }

  public void setSubmateri(Set<Submateri> submateri) {
    this.submateri = submateri;
  }

  public Set<Identitas> getIdentitas() {
    return identitas;
  }

  public void setIdentitas(Set<Identitas> identitas) {
    this.identitas = identitas;
  }

  @Override
  public String toString() {
    return "Materi [id=" + id + ", title=" + title + ", description=" + description + ", isActived=" + isActived + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", code=" + code + ", type=" + type + "]";
  }

}
