package lab.designpattern.lab2.base;

import java.math.BigDecimal;
import java.util.List;

public interface TicketsManager {
	public BigDecimal calculateAllTicketsSalePrice();

	public void addTicket(Ticket ticket);

	public List<Ticket> getAllTickets();

	public void deleteAllTickets();
	
	public void deleteTicket(String id);

}
