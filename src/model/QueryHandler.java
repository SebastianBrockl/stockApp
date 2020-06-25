package model;

import utility.QueryRequest;

/**
 * Class that consumes QueryRequests coming in from the GUI
 * NOTE! not thread-safe as of time being
 * 
 * @TODO implement caching 
 * 
 * @author Sebastian
 */
public class QueryHandler 
{

	private String apiKey;
	private URLAssembler urlAssembler;
	private HTTPSClient httpsClient;

	public QueryHandler(String apiKey)
	{
		this.apiKey = apiKey;
		urlAssembler = new URLAssembler(apiKey);
	}
	
	/**
	 * Function that produces data based on a query-object
	 * @TODO get data to controller and onto GUI
	 * @TODO cache results to avoid unnecessary API-queries
	 * @param request
	 */
	public void makeQuery(QueryRequest request)
	{
		//TODO check cache
		@SuppressWarnings("unused")
		String queryResult = httpsClient.makeQuery(
								urlAssembler.makeURL(request));
		//TODO cache results
		//TODO return data
		
	}
	
	/**
	 * Function overload that uses the single case makeQuery to perform two queries and produce a comparison of the results
	 * @TODO get data to controller and onto GUI
	 * @TODO cache results to avoid unnecessary API-queries
	 * @param request
	 */
	public void makeQuery(QueryRequest request1, QueryRequest request2)
	{
		if(request1.getSymbol().equals("") && request2.getSymbol().equals(""))
		{
			// failiure mode both symbols are faulty
			//TODO report user error
		}
		// if both queries have the same symbol
		else if (request1.getSymbol().equals(request2.getSymbol()))
		{
			//TODO perform single query
		}
		else if(!request1.getSymbol().equals(""))
		{
			
		}
		else if(request2.getSymbol().equals(""))
		{
			
		}
		else
		{
			// both symbols are valid and not Equal - the expected default case

		}
	}

}
