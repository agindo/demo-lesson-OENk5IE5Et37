package com.example.demo_lesson_OENk5IE5Et37.services.bahan;

import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.BahanRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;

public interface BahanService {

  Response add_bahan(BahanRequest request);

  Response get_bahan();

  Response get_bahan_by_id(String uuid);

  Response update_bahan_by_id(String uuid, BahanRequest request);

  Response delete_bahan_by_id(String uuid);
  
}
