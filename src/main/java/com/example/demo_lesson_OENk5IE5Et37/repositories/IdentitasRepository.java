package com.example.demo_lesson_OENk5IE5Et37.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_lesson_OENk5IE5Et37.models.Identitas;

@Repository
public interface IdentitasRepository extends JpaRepository<Identitas, String> {
  
  @Query(value = "SELECT * FROM identitas n WHERE n.is_actived = TRUE AND n.is_deleted = FALSE", nativeQuery = true)
  List<Identitas> findByActive();

}
