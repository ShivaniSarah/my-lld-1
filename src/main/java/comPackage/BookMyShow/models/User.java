package lld8.models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final String userId;
    private final String userName;
    private final String emailId;
    private final String phoneNo;
    private final Map<String,Ticket> ticketMap;

    public User(String userId, String userName, String emailId, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.ticketMap = new HashMap<>();
    }

    public void addTicket(Ticket ticket){
        ticketMap.put(ticket.getTicketId(),ticket);
    }
}
