package org.example.parcial1.controller;

import org.example.parcial1.dto.ChatRequest;
import org.example.parcial1.dto.ChatResponse;
import org.example.parcial1.service.ChatService;
import org.example.parcial1.service.StockMarketServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stock-market")
public class StockMarketController {
    String API = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=X75K4OIHF5MJ8DY8";
    private final ChatService chatService;
    private final StockMarketServices stockMarketServices;
    public StockMarketController() {
        this.chatService = new ChatService();
        this.stockMarketServices = new StockMarketServices();
    }
    @GetMapping("/Intraday")
    public String getIntradayStockData() {
        return stockMarketServices.getIntradayStockData();
    }

    @GetMapping("/daily")
    public String getDailyStockData() {
        return stockMarketServices.getDailyStockData();
    }
    @GetMapping("/weekly")
    public String getWeeklyStockData() {
        return stockMarketServices.getWeeklyStockData();
    }
    @PostMapping("/chatgpt-opinion")
    public ChatResponse getChatGPTOpinion(@RequestBody ChatRequest request) throws Exception {
        String response = chatService.chat(request.getPrompt());
        return new ChatResponse(response);
    }
}
