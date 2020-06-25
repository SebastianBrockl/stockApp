package model;

import utility.QueryRequest;


/**
 * Simple class that consumes an QueryRequest and generates a URL based on it
 * 
 * 	example queries:
 * 
 * 	https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY_ADJUSTED&symbol=MSFT&apikey=demo
 *	https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=MSFT&apikey=demo
 *	https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&outputsize=full&apikey=demo
 *
 * @author Sebastian
 *
 */
public class URLAssembler {

	String key;
	final String baseURL = "https://www.alphavantage.co/query?";
	
	public URLAssembler (String APIkey)
	{
		key = APIkey;
	}
	
	public String makeURL(QueryRequest request)
	{
		String url = baseURL;
		url += "function=" +request.getTimeSeries();
		url += "&symbol=" + request.getSymbol();
		
		if( ! request.getTimeIntervall().equals("")){
			url += "&interval=" + request.getTimeIntervall();
		}
		if( ! request.getOutputSize().equals("")){
			url += "&outputsize=" +  request.getOutputSize();
		}
		
		url += "&apikey=" + key;
		
		System.out.println("new URL generated: " + url);
		return url;
	}
}
