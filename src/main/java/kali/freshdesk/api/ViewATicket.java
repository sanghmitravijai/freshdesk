package kali.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

public class ViewATicket {
	
	
	
	public static String ticketDetails(int ticketId) throws IOException{
		
		URL url = new URL(ApiName.endPoint+ApiName.viewTicket(ticketId));
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		//con.setDoOutput(true);
       // con.setDoInput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        String basicAuth = "" + new String(new Base64().encode(ApiName.token.getBytes()));
        con.setRequestProperty("Authorization", basicAuth);
     //   OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());
        BufferedReader br=new BufferedReader(inputStreamReader);
        String str=br.readLine();
       	return str;
		
		
	}
}
