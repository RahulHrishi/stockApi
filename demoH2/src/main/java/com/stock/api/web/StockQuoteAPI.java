package com.stock.api.web;

import java.io.IOException;
import java.sql.Timestamp;

import com.stock.api.model.Stocks;

public class StockQuoteAPI {

	public static void main(String[] args) throws IOException {
		
		Stocks se = new Stocks();
		se.setCompanyName("zycus");
		se.setCurrency("INR");
		se.setDate( new Timestamp(System.currentTimeMillis()));		
		//se.setId(id);
		se.setPrice(20.25);
		se.setStockQuote("HDFC");
		
	}
}