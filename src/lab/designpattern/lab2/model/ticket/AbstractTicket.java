package lab.designpattern.lab2.model.ticket;

import java.math.BigDecimal;
import java.util.UUID;

import lab.designpattern.lab2.base.Ticket;
import lab.designpattern.lab2.util.TicketUtil;

public abstract class AbstractTicket implements Ticket {
	private final BigDecimal originalPrice;
	private final double taxRate;
	private final String id;

	public AbstractTicket(double originalPrice, double taxRate) {
		this.originalPrice = TicketUtil.toMonetaryValue(originalPrice);
		this.taxRate = taxRate;
		id = String.format("%s-%s", UUID.randomUUID().toString(), String.valueOf(System.currentTimeMillis()));
	}

	@Override
	public BigDecimal getOriginalPrice() {
		return this.originalPrice;
	}

	@Override
	public BigDecimal getTotalSalePrice() {
		return this.getOriginalPrice().add(this.getTotalTax());
	}

	@Override
	public BigDecimal getTotalTax() {
		return this.originalPrice.multiply(TicketUtil.toMonetaryValue(this.getTaxRate()));
	}

	@Override
	public double getTaxRate() {
		return this.taxRate;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
