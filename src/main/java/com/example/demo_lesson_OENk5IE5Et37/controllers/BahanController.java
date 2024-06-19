package com.example.demo_lesson_OENk5IE5Et37.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_lesson_OENk5IE5Et37.exception.ResourceNotFoundException;
import com.example.demo_lesson_OENk5IE5Et37.models.Bahan;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.BahanRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.BahanRepository;
import com.example.demo_lesson_OENk5IE5Et37.repositories.SubmateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.services.bahan.BahanService;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BahanController {
  
  @Autowired
  private SubmateriRepository submateriRepository;

  @Autowired
  private BahanRepository bahanRepository;

  @Autowired
  private BahanService bahanService;

  @Autowired
  private GeneralUtils generalUtils;

  @PostMapping("submateri/{submateriId}/bahan")
  public ResponseEntity<Bahan> add_bahan_0(@PathVariable(value = "submateriId") String submateriId, @RequestBody Bahan bahan) {
    Bahan _bahan = submateriRepository.findById(submateriId).map(submateri -> {
      submateri.getBahan().add(bahan);

      bahan.setTitle(bahan.getTitle());
      bahan.setSource(bahan.getSource());
      bahan.setCode(generalUtils.GeneratingRandomAlphanumeric());
      bahan.setType(bahan.getType());
      bahan.setPoint(bahan.getPoint());

      return bahanRepository.save(bahan);
    }).orElseThrow(() -> new ResourceNotFoundException("not found" + submateriId));

    return new ResponseEntity<>(_bahan, HttpStatus.CREATED);
  }
  
  @GetMapping("/bahan/{uuid}")
  public ResponseEntity<?> get_bahan_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = bahanService.get_bahan_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @PutMapping("/bahan/{uuid}")
  public ResponseEntity<?> update_bahan_by_id(@PathVariable("uuid") String id, @RequestBody BahanRequest request) {
    try {
      Response response = bahanService.update_bahan_by_id(id, request);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @DeleteMapping("/bahan/{uuid}")
  public ResponseEntity<?> delete_bahan_by_id(@PathVariable("uuid") String id) {
    try {
      Response response = bahanService.delete_bahan_by_id(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

}
