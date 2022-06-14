package com.golstov.restapp.service.impl;

import com.golstov.restapp.dto.CurrencyRateDTO;
import com.golstov.restapp.dto.GifDTO;
import com.golstov.restapp.exeption.BadCurrencyCodeException;
import com.golstov.restapp.service.CurrencyService;
import com.golstov.restapp.service.DownloadService;
import com.golstov.restapp.service.ExchangeRatesService;
import com.golstov.restapp.service.GifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    final static Logger logger = LoggerFactory.getLogger(ExchangeRatesServiceImpl.class);

    private final CurrencyService currencyService;
    private final GifService gifService;
    private final DownloadService downloadService;


    public ExchangeRatesServiceImpl(CurrencyService currencyService, GifService gifService, DownloadService downloadService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
        this.downloadService = downloadService;
    }


    @Override
    public ResponseEntity<byte[]> getGifByCurrency(String currency) {

        if (!isCurrencyCodeValid(currency)) {
            logger.error("Currency code is incorrect");
            throw new BadCurrencyCodeException("Currency code must be 3 characters");
        }
        currency = currency.toUpperCase();
        logger.info("Current currency code: " + currency);
        String todayDate = getDateFromCurrent(0);
        String yesterdayDate = getDateFromCurrent(1);
        double todayRate = getExchangeRate(todayDate, currency);
        double yesterdayRate = getExchangeRate(yesterdayDate, currency);
        String comparisonResult = todayRate > yesterdayRate ? "rich" : "broke";
        URI basePathUri = URI.create(getGifUrlByTag(comparisonResult));
        return downloadService.getGifByUrl(basePathUri);
    }

    private boolean isCurrencyCodeValid(String currency) {
        return Pattern.matches("[a-zA-Z]{3}", currency);
    }

    private static String getDateFromCurrent(int days) {
        Instant date = Instant.now().minus(days, ChronoUnit.DAYS);
        LocalDateTime datetime = LocalDateTime.ofInstant(date, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(datetime);
    }

    private double getExchangeRate(String date, String currencyCode) {
        CurrencyRateDTO currencyRateDTO = currencyService.getCurrency(date, currencyCode).getBody();
        if (currencyRateDTO != null) {
            return currencyRateDTO.getRates().get(currencyCode);
        } else {
            throw new RuntimeException("Currency not found");
        }
    }

    private String getGifUrlByTag(String tag) {
        GifDTO gifDTO = gifService.getGifResponse(tag).getBody();
        String url = null;
        if(gifDTO != null && gifDTO.getData() != null) {
            Map images = (Map) gifDTO.getData().get("images");
            Map original = (Map) images.get("original");
            url = (String) original.get("url");
        }
        if (url == null || url.isEmpty()){
            throw new RuntimeException("Current gif url not found");
        }
        logger.info("Gif Url: " + url);
        return url;
    }
}
