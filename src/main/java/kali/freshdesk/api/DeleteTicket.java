package kali.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

public class DeleteTicket {
	
	
	public static void deleteTicket() throws IOException, JSONException{
		
		 String stringUrl = "https://kpfsujeet1365.freshdesk.com/api/v2/tickets/1/reply";
	        URL url = new URL(stringUrl);
	        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	        uc.setDoOutput(true);
	        uc.setDoInput(true);
	        uc.setRequestMethod("POST");
	        uc.setRequestProperty("Content-Type", "application/json");
	        
	        String userpass = "BhPXCrDNWwuvbtxHo2p" + ":" + "X";
	        String basicAuth = "" + new String(new Base64().encode(userpass.getBytes()));
	        System.out.println(basicAuth);
	        uc.setRequestProperty("Authorization", basicAuth);
	        
	        OutputStreamWriter wr = new OutputStreamWriter(uc.getOutputStream());
	        wr.write("{ \"body\":\"We are working on this issue. Will keep you posted.\" }");
	        wr.flush();
	        
	        InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
	        
	        BufferedReader br=new BufferedReader(inputStreamReader);
	        String str=br.readLine();
	        System.out.println(str);
	       // JSONObject response_json = new JSONObject(str.substring(1, str.length()-1));
	        
	}

	public static void main(String[] args) throws IOException, JSONException {
		deleteTicket();

	}

}
