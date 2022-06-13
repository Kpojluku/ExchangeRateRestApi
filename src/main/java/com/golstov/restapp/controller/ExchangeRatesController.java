package com.golstov.restapp.controller;


import com.golstov.restapp.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExchangeRatesController {

    @Autowired
    ExchangeRatesService exchangeRatesService;

    @GetMapping("/compareExchangeRates")
    public ResponseEntity<byte[]> compareExchangeRatesAndGetGif(@RequestParam("currency") String currency) {
        return exchangeRatesService.getGifByCurrency(currency);
    }
}
