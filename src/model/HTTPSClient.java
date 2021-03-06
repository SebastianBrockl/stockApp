package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;


/**
 * class that performs the https-query
 * NOTE this class is _heavily_ based on an example found online here:
 * https://mkyong.com/java/java-https-client-httpsurlconnection-example/
 * 
 * @author Sebastian
 */
public class HTTPSClient
{
	
	/**
	 * queries alphavantage web-api for the desired data
	 * 
	 * @param queryString API-query call generated by QueryHandler
	 * @return raw return from the alphavantage server
	 */
	public String makeQuery(String urlString)
	{
		
		String result = "";
		
		URL url;
		
		try {
			
			System.out.println("querying URL: " + urlString);
			
			url = new URL(urlString);

			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

			// dump all cert info
			print_https_cert(con);

			// get the content
			result = getContent(con);
			
			
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return result;

	}
	
	private void print_https_cert(HttpsURLConnection con)
	{
		if(con!=null)
		{
			try
			{

				System.out.println("Response Code : " + con.getResponseCode());
				System.out.println("Cipher Suite : " + con.getCipherSuite());
				System.out.println("\n");

				Certificate[] certs = con.getServerCertificates();
				for(Certificate cert : certs){
					System.out.println("Cert Type : " + cert.getType());
					System.out.println("Cert Hash Code : " + cert.hashCode());
					System.out.println("Cert Public Key Algorithm : "
							+ cert.getPublicKey().getAlgorithm());
					System.out.println("Cert Public Key Format : "
							+ cert.getPublicKey().getFormat());
					System.out.println("\n");
				}

			} 
			catch (SSLPeerUnverifiedException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}
	
	private String getContent(HttpsURLConnection con)
	{
		
		String outputString ="";
		if(con!=null){

			try {

				StringBuffer output = new StringBuffer();

				System.out.println("****** Content of the URL ********");
				BufferedReader br =
						new BufferedReader(
								new InputStreamReader(con.getInputStream()));

				String input;

				while ((input = br.readLine()) != null)
				{
					System.out.println(input);
					output.append(input + "\n");
				}
				br.close();

				outputString = output.toString();
				
				System.out.println("response from URL recieved!");
				return outputString;
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		}
		// exception thrown, disregard data
		return "";

	}
	
}
