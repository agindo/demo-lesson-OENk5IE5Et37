package com.example.demo_lesson_OENk5IE5Et37.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_lesson_OENk5IE5Et37.exception.ResourceNotFoundException;
import com.example.demo_lesson_OENk5IE5Et37.models.Submateri;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.SubmateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.MateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.repositories.SubmateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.services.submateri.SubmateriService;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SubmateriController {
  
  @Autowired
  private MateriRepository materiRepository; 

  @Autowired
  private SubmateriRepository submateriRepository;

  @Autowired
  private SubmateriService submateriService;

  @Autowired
  private GeneralUtils generalUtils;

  @PostMapping("/materi/{materiId}/submateri")
  public ResponseEntity<Submateri> add_submateri_0(@PathVariable(value = "materiId") String materiId, @RequestBody Submateri submateri) {
    Submateri _submateri = materiRepository.findById(materiId).map(materi -> {
      materi.getSubmateri().add(submateri);

      submateri.setTitle(submateri.getTitle());
      submateri.setDescription(submateri.getDescription());
      submateri.setCode(generalUtils.GeneratingRandomAlphanumeric());
      submateri.setType(submateri.getType());

      return submateriRepository.save(submateri);
    }).orElseThrow(() -> new ResourceNotFoundException("not found" + materiId));

    return new ResponseEntity<>(_submateri, HttpStatus.CREATED);
  }
  
  @PostMapping("/submateri")
  public ResponseEntity<?> add_submateri(@Valid @RequestBody SubmateriRequest request) {
    try {
      Response response = submateriService.add_submateri(request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/submateri/{uuid}")
  public ResponseEntity<?> get_submateri_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = submateriService.get_submateri_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @PutMapping("/submateri/{uuid}")
  public ResponseEntity<?> update_submateri_by_id(@PathVariable("uuid") String id, @RequestBody SubmateriRequest request) {
    try {
      Response response = submateriService.update_submateri_by_id(id, request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
  
  @DeleteMapping("/submateri/{uuid}")
  public ResponseEntity<?> delete_submateri_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = submateriService.delete_submateri_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
  
}
