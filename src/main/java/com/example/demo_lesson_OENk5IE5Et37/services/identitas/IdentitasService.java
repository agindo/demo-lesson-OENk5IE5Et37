package com.example.demo_lesson_OENk5IE5Et37.services.identitas;

import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.IdentitasRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;

public interface IdentitasService {

  Response add_identitas(IdentitasRequest request);

  Response get_identitas();

  Response get_identitas_by_id(String uuid);

  Response update_identitas_by_id(String uuid, IdentitasRequest request);

  Response delete_identitas_by_id(String uuid);
  
}