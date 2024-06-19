package com.example.demo_lesson_OENk5IE5Et37.services.bahan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo_lesson_OENk5IE5Et37.models.Bahan;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.BahanRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;
import com.example.demo_lesson_OENk5IE5Et37.repositories.BahanRepository;
import com.example.demo_lesson_OENk5IE5Et37.utils.GeneralUtils;

@Service
public class BahanServiceImpl implements BahanService {

  @Autowired
  private BahanRepository bahanRepository;

  @Autowired
  private GeneralUtils generalUtils;

  @Override
  public Response add_bahan(BahanRequest request) {
    Bahan bahan = new Bahan();

    bahan.setTitle(request.getTitle());
    bahan.setSource(request.getSource());
    bahan.setPoint(request.getPoint());
    bahan.setCode(generalUtils.GeneratingRandomAlphanumeric());
    bahan.setType(request.getType());

    bahan = bahanRepository.save(bahan);

    Response response = new Response();
    response.setStatus(HttpStatus.CREATED.value());
    response.setMessage("created success");
    response.setData(bahan);

    return response;
  }

  @Override
  public Response get_bahan() {
    List<Bahan> bahan = bahanRepository.findByActive();
    Response response = new Response(HttpStatus.OK.value(), "success", bahan);
    return response;
  }

  @Override
  public Response get_bahan_by_id(String uuid) {
    Optional<Bahan> bahan = bahanRepository.findById(uuid);

    Response response = new Response();

    if (bahan.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(bahan);
    } else {
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("success");
      response.setData(bahan);
    }

    return response;
  }

  @Override
  public Response update_bahan_by_id(String uuid, BahanRequest request) {
    Optional<Bahan> bahan = bahanRepository.findById(uuid);

    Response response = new Response();

    if (bahan.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(bahan);
    } else {
      if (bahan.isPresent()) {
        Bahan _bahan = bahan.get();

        _bahan.setTitle(request.getTitle());
        _bahan.setSource(request.getSource());
        _bahan.setPoint(request.getPoint());
        _bahan.setCode(generalUtils.GeneratingRandomAlphanumeric());
        _bahan.setType(request.getType());

        bahanRepository.save(_bahan);

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("updated success");
        response.setData(_bahan);
      }
    }

    return response;
  }

  @Override
  public Response delete_bahan_by_id(String uuid) {
    Optional<Bahan> bahan = bahanRepository.findById(uuid);

    Response response = new Response();

    if (bahan.isEmpty()) { 
      response.setStatus(HttpStatus.CREATED.value());
      response.setMessage("not found");
      response.setData(bahan);
    } else {
      if (bahan.isPresent()) {
        Bahan _bahan = bahan.get();

        _bahan.setIsDeleted(true);

        bahanRepository.save(_bahan);
        
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("success deleted");
        response.setData(_bahan);
      }
    }

    return response;
  }
  
}
