package com.golstov.restapp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeRatesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void goodRequest() throws Exception {
        mockMvc.perform(get("/api/compareExchangeRates?currency=rub"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

    @Test
    public void badCurrencyCode() throws Exception {
        mockMvc.perform(get("/api/compareExchangeRates?currency=ru"))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof RuntimeException));
    }


}
