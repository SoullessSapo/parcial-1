package org.example.parcial1.controller;

import org.example.parcial1.dto.ChatResponse;
import org.example.parcial1.dto.CompareRequest;
import org.example.parcial1.service.ChatService;
import org.example.parcial1.service.StockMarketServices;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stock-market")
public class StockMarketController {
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
    @GetMapping("/monthly")
    public String getMonthlyStockData() {
        return stockMarketServices.getMonthlyStockData();
    }
    @PostMapping("/compare-options")
    public ChatResponse compareOptions(@RequestBody CompareRequest request) throws Exception {
        JSONObject json = new JSONObject(request.getJsonData());
        JSONObject timeSeries = json.getJSONObject("Time Series (5min)");
        JSONObject option1 = timeSeries.getJSONObject(request.getTime1());
        JSONObject option2 = timeSeries.getJSONObject(request.getTime2());

        String prompt = "dado estos 2 IBM tradestocks, cual es mejor y porque?\n"
                + "Option 1 (" + request.getTime1() + "): " + option1.toString() + "\n"
                + "Option 2 (" + request.getTime2() + "): " + option2.toString();

        String response = chatService.chat(prompt);
        return new ChatResponse(response);
    }
}
