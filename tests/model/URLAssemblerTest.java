package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.QueryRequest;

class URLAssemblerTest {

	@Test
	void emptyValuesTest() 
	{
		URLAssembler assembler = new URLAssembler("");
		QueryRequest request = new QueryRequest();
		
		assertEquals(assembler.makeURL(request), 
				"https://www.alphavantage.co/query?function=&symbol=&apikey=");
	}

	@Test
	void apiKeyTest()
	{
		URLAssembler assembler = new URLAssembler("key");
		QueryRequest request = new QueryRequest();
		
		assertEquals(assembler.makeURL(request), 
				"https://www.alphavantage.co/query?function=&symbol=&apikey=key");
	}
	
	@Test
	void correctValueTest()
	{
		URLAssembler assembler = new URLAssembler("key");
		QueryRequest request = new QueryRequest();
		
		request.setSymbol("symbol");
		request.setTimeSeries("TIME_SERIES");
		
		assertEquals(assembler.makeURL(request), 
				"https://www.alphavantage.co/query?function=TIME_SERIES&symbol=symbol&apikey=key");
		
		request.setTimeIntervall("time_interval");

		assertEquals(assembler.makeURL(request), 
				"https://www.alphavantage.co/query?function=TIME_SERIES&symbol=symbol&interval=time_interval&apikey=key");
		
		request.setOutputSize("output_size");

		assertEquals(assembler.makeURL(request), 
				"https://www.alphavantage.co/query?function=TIME_SERIES&symbol=symbol&interval=time_interval&outputsize=output_size&apikey=key");
	}
}
