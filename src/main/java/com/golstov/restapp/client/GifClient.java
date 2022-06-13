package com.golstov.restapp.client;

import com.golstov.restapp.dto.GifDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif-client", url = "${giphy.url}")
public interface GifClient {

    @GetMapping(value = "/random")
    ResponseEntity<GifDTO> getGif(@RequestParam("api_key") String api_key,
                                  @RequestParam("tag") String tag);

}
