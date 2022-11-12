package lab.designpattern.lab2.model.ticket;

public class AdultTicket extends AbstractTicket {

	public AdultTicket(double price, double taxRate) {
		super(price, taxRate);
	}

	@Override
	public boolean isTicketValid(Object basisDataForTicketVerification) {

		int age = (int) basisDataForTicketVerification;
		return age > 16 && age < 65;
	}

}
