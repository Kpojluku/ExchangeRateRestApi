package com.golstov.restapp.service.impl;

import com.golstov.restapp.client.ExchangeRatesClient;
import com.golstov.restapp.dto.CurrencyRateDTO;
import com.golstov.restapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final ExchangeRatesClient exchangeRatesClient;
    private final String API_KEY;

    public CurrencyServiceImpl(ExchangeRatesClient currencyClient, @Value("${openexchangerates.api_key}") String API_KEY) {
        this.exchangeRatesClient = currencyClient;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<CurrencyRateDTO> getCurrency(String date, String currencyCode) {
        return exchangeRatesClient.getCurrency(date, API_KEY, currencyCode);
    }
}
