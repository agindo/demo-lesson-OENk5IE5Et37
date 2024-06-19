package com.example.demo_lesson_OENk5IE5Et37.services.materi;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo_lesson_OENk5IE5Et37.models.Materi;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.MateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.MateriRepository;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

@Service
public class MateriServiceImpl implements MateriService {
  
  @Autowired
  private MateriRepository materiRepository;

  @Autowired
  private GeneralUtils generalUtils;

  @Override
  public Response add_materi(MateriRequest request) {
    Materi materi = new Materi();

    materi.setTitle(request.getTitle());
    materi.setDescription(request.getDescription());
    materi.setCode(generalUtils.GeneratingRandomAlphanumeric());
    materi.setType(request.getType());

    materi = materiRepository.save(materi);
    
    Response response = new Response();
    response.setStatus(HttpStatus.CREATED.value());
    response.setMessage("created success");
    response.setData(materi);

    return response;
  }

  @Override
  public Response get_materi() {
    List<Materi> materi = materiRepository.findByActive();
    Response response = new Response(HttpStatus.OK.value(), "success", materi);
    return response;
  }

  @Override
  public Response get_materi_by_id(String uuid) {
    Optional<Materi> materi = materiRepository.findById(uuid);

    Response response = new Response();

    if (materi.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(materi);
    } else {
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("success");
      response.setData(materi);
    }

    return response;
  }

  @Override
  public Response update_materi_by_id(String uuid, MateriRequest request) {
    Optional<Materi> materi = materiRepository.findById(uuid);

    Response response = new Response();

    if (materi.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(materi);
    } else {
      if (materi.isPresent()) {
        Materi _materi = materi.get();

        _materi.setTitle(request.getTitle());
        _materi.setDescription(request.getDescription());
        _materi.setCode(generalUtils.GeneratingRandomAlphanumeric());
        _materi.setType(request.getType());

        materiRepository.save(_materi);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("updated success");
        response.setData(_materi);
      }
    }

    return response;
  }

  @Override
  public Response delete_materi_by_id(String uuid) {
    Optional<Materi> materi = materiRepository.findById(uuid);

    Response response = new Response();

    if (materi.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(materi);
    } else {
      if (materi.isPresent()) {
        Materi _materi = materi.get();

        _materi.setIsDeleted(true);

        materiRepository.save(_materi);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("success deleted");
        response.setData(null);
      }
    }

    return response;
  }

  @Override
  public Optional<Materi> getmateribyid(String uuid) {
    Optional<Materi> materi = materiRepository.findById(uuid);
    return materi;
  }

}
