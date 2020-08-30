package com.stock.api.web;

//added by RahulS

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.exception.StockException;
import com.stock.api.model.Stocks;
import com.stock.api.service.StockService;

@RestController
public class StockController {
	Map<Long, String> keys = new HashMap<>();
	@Autowired
	StockService service;

	@RequestMapping(value = "/stockQuote", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Stocks>> getStocks(@RequestParam List<String> quoteNames) throws StockException {
		if (quoteNames.size() > 10) {
			throw new StockException("Query limitation breached-Supports only 10 APIS at a time");
		}
		quoteNames = quoteNames.stream().map(String::toUpperCase).collect(Collectors.toList());
		Map<String, List<Stocks>> jsonMap = new HashMap<>();
		service.setKeys(keys);
		jsonMap.put("stocks", service.getMetaApis(keys, quoteNames));
		return jsonMap;
	}

	@RequestMapping(value = "/stockOnBoard", method = RequestMethod.POST)
	@ResponseBody
	public String stockOnBoard(@Valid Stocks stock, BindingResult bindingResult) throws StockException {
		Stocks res = service.saveOrUpdate(stock);
		if (null == res.getId()) {
			throw new StockException("Record not saved");
		}
		return "Record Saved";
	}
}