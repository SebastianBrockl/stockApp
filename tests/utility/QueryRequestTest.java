package utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueryRequestTest {

	@Test
	void getSetIntervalTest()
	{
		
		String testValue = "testValue";
		
		QueryRequest request = new QueryRequest();
		
		request.setTimeIntervall(testValue);
		
		assertEquals(request.getTimeIntervall(), testValue);
	}
	
	@Test
	void getSetSymbolTest()
	{
		
		String testValue = "testValue";
		
		QueryRequest request = new QueryRequest();
		
		request.setSymbol(testValue);
		
		assertEquals(request.getSymbol(), testValue);
	}	
	
	@Test
	void getSetSeriesTest()
	{
		
		String testValue = "testValue";
		
		QueryRequest request = new QueryRequest();
		
		request.setTimeSeries(testValue);
		
		assertEquals(request.getTimeSeries(), testValue);
	}
	
	@Test
	void getSetSizeTest()
	{
		
		String testValue = "testValue";
		
		QueryRequest request = new QueryRequest();
		
		request.setOutputSize(testValue);
		
		assertEquals(request.getOutputSize(), testValue);
	}

}
