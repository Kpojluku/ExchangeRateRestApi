package com.golstov.restapp.client;

import com.golstov.restapp.dto.CurrencyRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchange-rates-client", url = "${openexchangerates.url}")
public interface ExchangeRatesClient {

    @GetMapping("/{date}.json")
    ResponseEntity<CurrencyRateDTO> getCurrency(@PathVariable("date") String date,
                                                @RequestParam("app_id") String id,
                                                @RequestParam(value = "symbols") String currencyCode);

}
