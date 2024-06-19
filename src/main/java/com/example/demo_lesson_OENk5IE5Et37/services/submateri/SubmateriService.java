package com.example.demo_lesson_OENk5IE5Et37.services.submateri;

import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.SubmateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;

public interface SubmateriService {

  Response add_submateri(SubmateriRequest request);

  Response get_submateri();

  Response get_submateri_by_id(String uuid);

  Response update_submateri_by_id(String uuid, SubmateriRequest request);

  Response delete_submateri_by_id(String uuid);
  
}
