package com.example.demo_lesson_OENk5IE5Et37.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.MateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.services.materi.MateriService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MateriController {
  
  @Autowired
  private MateriService materiService;

  @PostMapping("/materi")
  public ResponseEntity<?> add_materi(@Valid @RequestBody MateriRequest request) {
    try {
      Response response = materiService.add_materi(request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
  
  @GetMapping("/materi")
  public ResponseEntity<?> get_materi() {
    try {
      Response response = materiService.get_materi();
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/materi/{uuid}")
  public ResponseEntity<?> get_materi_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = materiService.get_materi_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @PutMapping("/materi/{uuid}")
  public ResponseEntity<?> update_materi_by_id(@PathVariable("uuid") String id, @RequestBody MateriRequest request) {
    try {
      Response response = materiService.update_materi_by_id(id, request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
  
  @DeleteMapping("/materi/{uuid}")
  public ResponseEntity<?> delete_materi_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = materiService.delete_materi_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

}
