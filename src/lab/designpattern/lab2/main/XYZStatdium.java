package lab.designpattern.lab2.main;

import lab.designpattern.lab2.base.Ticket;
import lab.designpattern.lab2.base.TicketsManager;
import lab.designpattern.lab2.entity.manager.DefaultTicketManager;
import lab.designpattern.lab2.entity.ticket.AdultTicket;
import lab.designpattern.lab2.entity.ticket.ChildTicket;
import lab.designpattern.lab2.entity.ticket.SeniorTicket;
import lab.designpattern.lab2.factory.TicketFactory;

/**
 * to create your own custom ticket, just inherit from the AbstractTicket class
 */

public class XYZStatdium {

	public static void main(String[] args) {

		TicketsManager manager = new DefaultTicketManager();
		int[] ages = new int[] { 69, 55, 25, 5 };
		double taxRate = 0.12; // 12 %

		for (int age : ages) {
			try {
				Ticket ticket = createTicket(age, taxRate);

				if(ticket == null) {
					print(String.format("No ticket available for age %s", age));
				} else {
					print(String.format("Creating %s - %s", ticket.getClass().getSimpleName(),
							ticket.getTotalSalePrice()));

					manager.addTicket(ticket);
				}
				
			} catch (Exception e) {
				print(String.format("Error: ", e.getMessage()));
			}
		}

		print(String.format("Total Price: %s", manager.calculateAllTicketsSalePrice()));

		manager.deleteAllTickets();

	}

	private static Ticket createTicket(int age, double taxRate) throws Exception {
		return TicketFactory.getInstance().createTicketInstance(age,
				new TicketFactory.TicketConstructorParametersWrapper(AdultTicket.class, 15, taxRate),
				new TicketFactory.TicketConstructorParametersWrapper(SeniorTicket.class, 12, taxRate),
				new TicketFactory.TicketConstructorParametersWrapper(ChildTicket.class, 10, taxRate));
	}
	
	
	private static void print(Object obj) {
		System.out.println(obj);
	}

}
