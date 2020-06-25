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
		String queryResult = httpsClient.makeQuery(
								urlAssembler.makeURL(request));
		//TODO cache results
		//TODO return data
		
	}
}
