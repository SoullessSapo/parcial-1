package org.example.parcial1.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

public class StockMarketServices {
    String API = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=X75K4OIHF5MJ8DY8";
    public String getIntradayStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getDailyStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getWeeklyStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
