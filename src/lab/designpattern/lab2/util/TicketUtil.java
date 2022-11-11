package lab.designpattern.lab2.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TicketUtil {
	public static BigDecimal toMonetaryValue(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		return bigDecimal.divide(new BigDecimal(1),1,RoundingMode.FLOOR);
	}
}
