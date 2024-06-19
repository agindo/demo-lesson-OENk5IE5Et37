package com.example.demo_lesson_OENk5IE5Et37.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_lesson_OENk5IE5Et37.exception.ResourceNotFoundException;
import com.example.demo_lesson_OENk5IE5Et37.models.Identitas;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.IdentitasRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.IdentitasRepository;
import com.example.demo_lesson_OENk5IE5Et37.repositories.MateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.services.identitas.IdentitasService;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class IdentitasController {

  @Autowired
  private MateriRepository materiRepository;

  @Autowired
  private IdentitasRepository identitasRepository;
  
  @Autowired
  private IdentitasService identitasService;

  @Autowired
  private GeneralUtils generalUtils;

  @PostMapping("/materi/{materiId}/identitas")
  public ResponseEntity<Identitas> add_identitas(@PathVariable(value = "materiId") String materiId, @RequestBody Identitas entity) {
    Identitas _identitas = materiRepository.findById(materiId).map(materi -> {
      materi.getIdentitas().add(entity);

      entity.setAuthor(entity.getAuthor());
      entity.setImg(entity.getImg());
      entity.setStyle(entity.getStyle());
      entity.setType(entity.getType());
      entity.setCode(generalUtils.GeneratingRandomAlphanumeric());

      return identitasRepository.save(entity);
    }).orElseThrow(() -> new ResourceNotFoundException("not found" + materiId));
      
    return new ResponseEntity<>(_identitas, HttpStatus.CREATED);
  }
  
  @GetMapping("/identitas/{uuid}")
  public ResponseEntity<?> get_identitas_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = identitasService.get_identitas_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @PutMapping("/identitas/{uuid}")
  public ResponseEntity<?> update_identitas_by_id(@PathVariable("uuid") String id, @RequestBody IdentitasRequest request) {      
    try {
      Response response = identitasService.update_identitas_by_id(id, request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
  
  @DeleteMapping("/identitas/{uuid}")
  public ResponseEntity<?> delete_identitas_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = identitasService.delete_identitas_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  } 

}
