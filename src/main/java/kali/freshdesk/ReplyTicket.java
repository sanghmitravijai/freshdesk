package kali.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import kali.freshdesk.api.ReplyTicketJson;

public class ReplyTicket {
	
	static public String reply(int ticketId,String body) throws IOException{
		URL url = new URL(ApiName.endPoint+ApiName.replyTicket(ticketId));
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        String basicAuth = "" + new String(new Base64().encode(ApiName.token.getBytes()));
        con.setRequestProperty("Authorization", basicAuth);
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        ReplyTicketJson rt=new ReplyTicketJson();
        
        rt.setBody(body);
        wr.write(rt.toString());
        wr.flush();
        InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());
        BufferedReader br=new BufferedReader(inputStreamReader);
        String str=br.readLine();
       	return str;	
	}
}