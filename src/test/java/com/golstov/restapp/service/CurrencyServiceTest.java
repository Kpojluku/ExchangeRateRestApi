package com.golstov.restapp.service;

import com.golstov.restapp.dto.CurrencyRateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    void responseFromExchangeRatesClient() {
        String currencyCode = "RUB";
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        ResponseEntity<CurrencyRateDTO> currencyRateDTO = currencyService.getCurrency(date, currencyCode);
        Assertions.assertEquals(currencyRateDTO.getStatusCodeValue(), 200);
        Assertions.assertNotNull(currencyRateDTO.getBody());
        Assertions.assertNotNull(currencyRateDTO.getBody().getRates().get(currencyCode));
    }
}
