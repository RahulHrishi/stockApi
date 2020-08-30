package com.stock.api.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.api.model.Stocks;
import com.stock.api.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;

	public Stocks createOrUpdateStock(Stocks stock) {
		return stockRepository.save(stock);
	}

	public List<Stocks> getQuotes() {
		return stockRepository.findAll();

	}

	public Stocks getQuoteById(Long quoteId) {
		Stocks stock = stockRepository.findById(quoteId).get();
		stock.setPrice(Math.round(stock.getPrice() * 100.0) / 100.0);
		return stock;
	}

	public Stocks saveOrUpdate(@Valid Stocks stock) {
		stock.setDate(new Timestamp(System.currentTimeMillis()));
		stock.setStockQuote(stock.getStockQuote().toUpperCase());
		return stockRepository.save(stock);
	}

	public Map<Long, String> setKeys(Map<Long, String> keys) {
		List<Stocks> list = getQuotes();
		list.forEach(stock -> keys.put(stock.getId(), stock.getStockQuote()));
		return keys;
	}

	public List<Stocks> getMetaApis(Map<Long, String> keys, List<String> quoteNames) {
		List<Stocks> temp = new ArrayList<>();
		quoteNames.stream().forEach(quoteName -> keys.forEach((key, val) -> {
			if (keys.containsValue(quoteName)) {
				if (quoteName.equalsIgnoreCase(val)) {
					temp.add(getQuoteById(key));
				}
			}
		}));
		quoteNames.forEach(quoteName -> {
			if (!keys.containsValue(quoteName)) {
				Stocks res = new Stocks();
				res.setStockQuote(quoteName);
				res.setStatus("Non-available stock quote");
				temp.add(res);
			}
		});
		return temp;
	}

}