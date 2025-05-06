package com.ajcs.data.controller;

import com.ajcs.data.model.refdata.Security;
import com.ajcs.data.model.trade.Trade;
import com.ajcs.data.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trading")
public class TradeController {

    TradeService tradeServiceImpl;

    public TradeController(TradeService tradeServiceImpl) {
        this.tradeServiceImpl = tradeServiceImpl;
    }

    @PostMapping("/trade")
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
        Trade newTrade = this.tradeServiceImpl.createTrade(trade);
        return new ResponseEntity<Trade>(newTrade, HttpStatus.OK);
    }

}
