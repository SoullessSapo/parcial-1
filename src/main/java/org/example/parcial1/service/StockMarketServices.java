package org.example.parcial1.service;
import org.example.parcial1.config.Env;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

public class StockMarketServices {
    String API_daily = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=NBI0J8OKD5OEIZBC";
    String API_intraday = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=NBI0J8OKD5OEIZBC";
    String API_weekly = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=IBM&apikey=NBI0J8OKD5OEIZBC";
    String API_monthly = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=NBI0J8OKD5OEIZBC";
    public String getIntradayStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API_intraday)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getDailyStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API_daily)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getWeeklyStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API_weekly)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getMonthlyStockData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(API_monthly)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                        .build())
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
