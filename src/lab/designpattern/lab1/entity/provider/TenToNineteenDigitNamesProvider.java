package lab.designpattern.lab1.entity.provider;

import lab.designpattern.lab1.base.DigitNamesProvider;

public class TenToNineteenDigitNamesProvider implements DigitNamesProvider {
	public static String[] TEN_TO_NINETEEN_NAMES = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	
	@Override
	public String[] provideNames() {
		return TEN_TO_NINETEEN_NAMES;
	}

}
