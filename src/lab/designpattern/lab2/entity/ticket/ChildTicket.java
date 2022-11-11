package lab.designpattern.lab2.entity.ticket;


public class ChildTicket extends AbstractTicket {
	
	public ChildTicket(double price, double taxRate) {
		super(price, taxRate);
	}


	@Override
	public boolean isTicketValid(Object basisDataForTicketVerification) {
		int age = (int) basisDataForTicketVerification;
		return age <= 16 && age > 0;
	}
}
