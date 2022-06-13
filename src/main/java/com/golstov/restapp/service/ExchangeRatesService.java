package com.golstov.restapp.service;

import org.springframework.http.ResponseEntity;

public interface ExchangeRatesService {
    ResponseEntity<byte[]> getGifByCurrency(String currency);
}
