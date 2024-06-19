package com.example.demo_lesson_OENk5IE5Et37.services.materi;

import java.util.Optional;

import com.example.demo_lesson_OENk5IE5Et37.models.Materi;
import com.example.demo_lesson_OENk5IE5Et37.payloads.requests.MateriRequest;
import com.example.demo_lesson_OENk5IE5Et37.payloads.responses.Response;

public interface MateriService {
  
  Response add_materi(MateriRequest request);

  Response get_materi();

  Response get_materi_by_id(String uuid);

  Response update_materi_by_id(String uuid, MateriRequest request);

  Response delete_materi_by_id(String uuid);

  Optional<Materi> getmateribyid(String uuid);
  
}
