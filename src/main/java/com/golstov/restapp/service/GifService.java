package com.golstov.restapp.service;

import com.golstov.restapp.dto.GifDTO;
import org.springframework.http.ResponseEntity;

public interface GifService {

    ResponseEntity<GifDTO> getGifResponse(String tag);

}
