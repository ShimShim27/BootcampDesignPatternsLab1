package lab.designpattern.lab2.factory;

import lab.designpattern.lab2.base.Ticket;
import lab.designpattern.lab2.base.TicketFactory;

public class DefaultTicketFactory implements TicketFactory{
	private static DefaultTicketFactory INSTANCE;

	private DefaultTicketFactory() {

	}

	public static DefaultTicketFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DefaultTicketFactory();
		}
		return INSTANCE;
	}

	public Ticket createTicketInstance(Object basisDataForTicketVerification,
			TicketConstructorParametersWrapper... ticketConstructorParametersWrappers) throws Exception {
		Ticket ticket = null;
		for (TicketConstructorParametersWrapper parametersWrapper : ticketConstructorParametersWrappers) {

			try {
				Class<?> ticketClass = parametersWrapper.getTicketClass();

				Ticket tempTicket = (Ticket) Class.forName(ticketClass.getCanonicalName())
						.getConstructor(double.class, double.class)
						.newInstance(parametersWrapper.getPrice(), parametersWrapper.getTaxRate());

				if (tempTicket.isTicketValid(basisDataForTicketVerification)) {
					ticket = tempTicket;
					break;
				}
			} catch (ClassCastException e) {
				throw new ClassCastException(String.format("Should be type %s", Ticket.class.getSimpleName()));
			}
		}

		return ticket;

	}

	public static class TicketConstructorParametersWrapper {
		private Class<?> ticketClass;

		public Class<?> getTicketClass() {
			return ticketClass;
		}

		public double getPrice() {
			return price;
		}

		public double getTaxRate() {
			return taxRate;
		}

		private double price;
		private double taxRate;

		public TicketConstructorParametersWrapper(Class<?> ticketClass, double price, double taxRate) {
			this.ticketClass = ticketClass;
			this.price = price;
			this.taxRate = taxRate;
		}
	}

}
