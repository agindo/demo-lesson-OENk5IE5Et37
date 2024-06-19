package com.example.demo_lesson_OENk5IE5Et37.services.identitas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo_lesson_OENk5IE5Et37.models.Identitas;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.IdentitasRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.IdentitasRepository;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

@Service
public class IdentitasServiceImpl implements IdentitasService {

  @Autowired
  private IdentitasRepository identitasRepository;

  @Autowired
  private GeneralUtils generalUtils;

  @Override
  public Response add_identitas(IdentitasRequest request) {
    Identitas identitas = new Identitas();

    identitas.setAuthor(request.getAuthor());
    identitas.setImg(request.getImg());
    identitas.setStyle(request.getStyle());
    identitas.setCode(generalUtils.GeneratingRandomAlphanumeric());
    identitas.setType(request.getType());

    identitas = identitasRepository.save(identitas);

    Response response = new Response();
    response.setStatus(HttpStatus.CREATED.value());
    response.setMessage("created success");
    response.setData(identitas);

    return response;
  }

  @Override
  public Response get_identitas() {
    List<Identitas> identitas = identitasRepository.findByActive();
    Response response = new Response(HttpStatus.OK.value(), "success", identitas);
    return response;
  }

  @Override
  public Response get_identitas_by_id(String uuid) {
   Optional<Identitas> identitas = identitasRepository.findById(uuid);

    Response response = new Response();

    if (identitas.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(identitas);
    } else {
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("success");
      response.setData(identitas);
    }

    return response;
  }

  @Override
  public Response update_identitas_by_id(String uuid, IdentitasRequest request) {
    Optional<Identitas> identitas = identitasRepository.findById(uuid);

    Response response = new Response();

    if (identitas.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(identitas);
    } else {
      if (identitas.isPresent()) {
        Identitas _identitas = identitas.get();

        _identitas.setAuthor(request.getAuthor());
        _identitas.setImg(request.getImg());
        _identitas.setStyle(request.getStyle());
        _identitas.setCode(generalUtils.GeneratingRandomAlphanumeric());
        _identitas.setType(request.getType());

        identitasRepository.save(_identitas);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("updated success");
        response.setData(_identitas);
      }
    }

    return response;
  }

  @Override
  public Response delete_identitas_by_id(String uuid) {
    Optional<Identitas> identitas = identitasRepository.findById(uuid);

    Response response = new Response();

    if (identitas.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(identitas);
    } else {
      if (identitas.isPresent()) {

        identitasRepository.deleteById(uuid);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("success deleted");
        response.setData(null);
      }
    }

    return response;
  }
  
}
