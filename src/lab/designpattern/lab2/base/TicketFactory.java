package lab.designpattern.lab2.base;

import lab.designpattern.lab2.factory.DefaultTicketFactory.TicketConstructorParametersWrapper;

public interface TicketFactory {
	public Ticket createTicketInstance(Object basisDataForTicketVerification,
			TicketConstructorParametersWrapper... ticketConstructorParametersWrappers) throws Exception;
}
