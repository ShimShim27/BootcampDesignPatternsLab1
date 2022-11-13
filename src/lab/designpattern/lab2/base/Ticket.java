package lab.designpattern.lab2.base;

import java.math.BigDecimal;

public interface Ticket {
	public String getId();

	public BigDecimal getOriginalPrice();

	public BigDecimal getTotalTax();

	public BigDecimal getTotalSalePrice();

	public double getTaxRate();

	public boolean isTicketValid(Object basisDataForTicketVerification);
}
