package lab.designpattern.lab2.entity.ticket;



public class SeniorTicket extends AbstractTicket {
	

	public SeniorTicket(double price, double taxRate) {
		super(price, taxRate);
	}

	
	@Override
	public boolean isTicketValid(Object basisDataForTicketVerification) {
		return (int) basisDataForTicketVerification >= 65;
	}

}
