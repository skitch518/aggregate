package com.agregate.portfolio.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class FinnhubService {

    @Value("${finnhub.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getCurrentPrice(String ticker) {
    // call Finnhub, return price

    String url = "https://finnhub.io/api/v1/quote?symbol=" + ticker + "&token=" + apiKey;
    Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    return new BigDecimal(response.get("c").toString());

    }
}
