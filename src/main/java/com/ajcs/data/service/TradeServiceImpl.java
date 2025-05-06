package com.ajcs.data.service;

import com.ajcs.data.model.trade.Trade;
import com.ajcs.data.repository.trade.TradeRepository;
import org.springframework.stereotype.Component;

@Component
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Trade createTrade(Trade trade) {
        return this.tradeRepository.save(trade);
    }
}
