package kali.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Conversation {

	public static String ticketConversation(int ticketId) throws IOException, JSONException{
		URL url = new URL(ApiName.endPoint+ApiName.ticketConversation(ticketId));
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
        JSONArray jsonarray = new JSONArray(str);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject object = jsonarray.getJSONObject(i);
            System.out.println(object.get("body_text"));
        }
       	return str;
	}	
}