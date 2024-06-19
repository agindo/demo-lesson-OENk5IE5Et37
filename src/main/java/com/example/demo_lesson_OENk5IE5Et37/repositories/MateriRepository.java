package com.example.demo_lesson_OENk5IE5Et37.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_lesson_OENk5IE5Et37.models.Materi;

@Repository
public interface MateriRepository extends JpaRepository<Materi, String> {

  @Query(value = "SELECT * FROM materi n WHERE n.is_actived = TRUE AND n.is_deleted = FALSE", nativeQuery = true)
  List<Materi> findByActive();

}
