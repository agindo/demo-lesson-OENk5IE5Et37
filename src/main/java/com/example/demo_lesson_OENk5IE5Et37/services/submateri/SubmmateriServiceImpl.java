package com.example.demo_lesson_OENk5IE5Et37.services.submateri;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo_lesson_OENk5IE5Et37.models.Submateri;
// import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.MateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.SubmateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
// import com.example.demo_lesson_OENk5IE5Et37.repositories.MateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.repositories.SubmateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

@Service
public class SubmmateriServiceImpl implements SubmateriService {

  // @Autowired
  // private MateriRepository materiRepository;

  @Autowired
  private SubmateriRepository submateriRepository;

  @Autowired
  private GeneralUtils generalUtils;

  @Override
  public Response add_submateri(SubmateriRequest request) {
    Submateri submateri = new Submateri();

    submateri.setTitle(request.getTitle());
    submateri.setDescription(request.getDescription());
    submateri.setCode(generalUtils.GeneratingRandomAlphanumeric());
    submateri.setType(request.getType());

    submateri = submateriRepository.save(submateri);
    
    Response response = new Response();
    response.setStatus(HttpStatus.CREATED.value());
    response.setMessage("created success");
    response.setData(submateri);

    return response;
  }

  @Override
  public Response get_submateri() {
    List<Submateri> submateri = submateriRepository.findByActive();
    Response response = new Response(HttpStatus.OK.value(), "success", submateri);
    return response;
  }

  @Override
  public Response get_submateri_by_id(String uuid) {
    Optional<Submateri> submateri = submateriRepository.findById(uuid);

    Response response = new Response();

    if (submateri.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(submateri);
    } else {
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("success");
      response.setData(submateri);
    }

    return response;
  }

  @Override
  public Response update_submateri_by_id(String uuid, SubmateriRequest request) {
    Optional<Submateri> submateri = submateriRepository.findById(uuid);

    Response response = new Response();

    if (submateri.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(submateri);
    } else {
      if (submateri.isPresent()) {
        Submateri _submateri = submateri.get();

        _submateri.setTitle(request.getTitle());
        _submateri.setDescription(request.getDescription());
        _submateri.setCode(generalUtils.GeneratingRandomAlphanumeric());
        _submateri.setType(request.getType());

        submateriRepository.save(_submateri);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("updated success");
        response.setData(_submateri);
      }
    }

    return response;
  }

  @Override
  public Response delete_submateri_by_id(String uuid) {
    Optional<Submateri> submateri = submateriRepository.findById(uuid);

    Response response = new Response();

    if (submateri.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(submateri);
    } else {
      if (submateri.isPresent()) {

        submateriRepository.deleteById(submateri.get().getId());

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("success deleted");
        response.setData(null);
      }
    }

    return response;
  }
  
}
