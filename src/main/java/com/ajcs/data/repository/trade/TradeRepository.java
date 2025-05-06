package com.ajcs.data.repository.trade;

import com.ajcs.data.model.trade.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
