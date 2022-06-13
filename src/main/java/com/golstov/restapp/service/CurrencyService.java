package com.golstov.restapp.service;

import com.golstov.restapp.dto.CurrencyRateDTO;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {

    ResponseEntity<CurrencyRateDTO> getCurrency(String date, String currencyCode);

}
