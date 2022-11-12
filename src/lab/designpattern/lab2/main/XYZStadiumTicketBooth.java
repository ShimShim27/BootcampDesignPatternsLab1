package lab.designpattern.lab2.main;

import lab.designpattern.lab2.base.Ticket;
import lab.designpattern.lab2.base.TicketsManager;
import lab.designpattern.lab2.factory.DefaultTicketFactory;
import lab.designpattern.lab2.model.manager.DefaultTicketManager;
import lab.designpattern.lab2.model.ticket.AdultTicket;
import lab.designpattern.lab2.model.ticket.ChildTicket;
import lab.designpattern.lab2.model.ticket.SeniorTicket;

/**
 * to create your own custom ticket, just inherit from the AbstractTicket class.
 * to implement custom tax calculation logic, override getTotalTax method of Abstract ticket class.
 */

public class XYZStadiumTicketBooth {

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
		return DefaultTicketFactory.getInstance().createTicketInstance(age,
				new DefaultTicketFactory.TicketConstructorParametersWrapper(AdultTicket.class, 15, taxRate),
				new DefaultTicketFactory.TicketConstructorParametersWrapper(SeniorTicket.class, 12, taxRate),
				new DefaultTicketFactory.TicketConstructorParametersWrapper(ChildTicket.class, 10, taxRate));
	}
	
	
	private static void print(Object obj) {
		System.out.println(obj);
	}

}
