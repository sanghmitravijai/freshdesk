package kali.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import kali.freshdesk.api.CreateTicketApi;

public class UpdateTicket {
	UpdateTicket(){}
	public static String updateTicket(int ticketId) throws IOException, JSONException{
		URL url = new URL(ApiName.endPoint+ApiName.updateTicket(ticketId));
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true);
	 //   con.setDoInput(true);
	    con.setRequestMethod("PUT");
	    con.setRequestProperty("Content-Type", "application/json");
	    String basicAuth = "" + new String(new Base64().encode(ApiName.token.getBytes()));
	    con.setRequestProperty("Authorization", basicAuth);
	    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	    CreateTicketApi ct=new CreateTicketApi();
	    ct.setName("kali");
	   // ct.setSubject("first create API");
	    //ct.setEmail("gelobmith@gmail.com");
	    ct.setDescription("gelobmith is a big mith");
	    wr.write("{\"name\":\"shani\",\"twitter_id\":\"@twitter\", \"priority\":1, \"status\":3 }");
	    wr.flush();
	    InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());
	    BufferedReader br=new BufferedReader(inputStreamReader);
	    String str=br.readLine();
	    System.out.println(str);
	 //   JSONObject json = new JSONObject(str);
	    return "";
	}
	
}
