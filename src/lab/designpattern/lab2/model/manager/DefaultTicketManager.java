package lab.designpattern.lab2.model.manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab.designpattern.lab2.base.Ticket;
import lab.designpattern.lab2.base.TicketsManager;

public class DefaultTicketManager implements TicketsManager {
	private Map<String, Ticket> ticketsMap;

	public DefaultTicketManager() {
		ticketsMap = new HashMap<>();
	}

	@Override
	public void addTicket(Ticket ticket) {
		if(ticket == null) throw new IllegalArgumentException("Ticket can't be null");
		this.ticketsMap.put(ticket.getId(), ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return new ArrayList<>(ticketsMap.values());
	}

	@Override
	public BigDecimal calculateAllTicketsSalePrice() {
		return this.getAllTickets().stream()
				.map(ticket -> ticket.getTotalSalePrice())
				.reduce((priceA, priceB) -> priceA.add(priceB)).orElse(new BigDecimal(0));
	}

	@Override
	public void deleteTicket(String id) {
		if(id == null || id.isEmpty()) throw new IllegalArgumentException("Id can't be null or empty");
		ticketsMap.remove(id);
	}

	@Override
	public void deleteAllTickets() {
		this.getAllTickets().clear();

	}
}
