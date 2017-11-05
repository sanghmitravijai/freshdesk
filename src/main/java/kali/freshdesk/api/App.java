package kali.freshdesk;

import java.io.IOException;

import org.json.JSONException;

public class App 
{
    public static void main( String[] args ) throws IOException, JSONException
    {
    //	System.out.println(CreateTicket.create());
    //   System.out.println(ReplyTicket.reply(2, "Via Bus"));
    	System.out.println(Conversation.ticketConversation(2));
    	//System.out.println(UpdateTicket.updateTicket(37));
    	//System.out.println(ViewATicket.ticketDetails(39));
    //	System.out.println(ViewATicket.ticketDetails(41));
    	//System.out.println(ViewATicket.ticketDetails(42));
    }
}
