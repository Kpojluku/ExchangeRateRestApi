package com.golstov.restapp.service;

import com.golstov.restapp.dto.GifDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GifServiceTest {

    @Autowired
    private GifService gifService;

    @Test
    void responseFromGifClient() {
        ResponseEntity<GifDTO> gifDTOResponseEntity = gifService.getGifResponse("rich");
        Assertions.assertEquals(gifDTOResponseEntity.getStatusCodeValue(), 200);
        Assertions.assertNotNull(gifDTOResponseEntity.getBody());
    }


}
