package kali.freshdesk;

public class ApiName {
	public static final String token="aJ305umSTJyYK0zPf8VI" + ":" + "X";
	public static final String endPoint="https://sanghmitravijai.freshdesk.com";
	public static final String createTicket="/api/v2/tickets";
	public static final String allContact="/api/v2/contacts";
	public static final String contantTypeJson="";
	
	public static final String replyTicket(int ticketId){
		return "/api/v2/tickets/"+ticketId+"/reply";
	}
	
	public static final String ticketConversation(int ticketId){
		return "/api/v2/tickets/"+ticketId+"/conversations";
	}
	
	public static final String updateTicket(int ticketId){
		return "/api/v2/tickets/"+ticketId;
	}
	
	public static final String viewTicket(int ticketId){
		return "/api/v2/tickets/"+ticketId;
	}
	
}
