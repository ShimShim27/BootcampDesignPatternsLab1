package lab.designpattern.lab1.entity.provider;

import lab.designpattern.lab1.base.DigitNamesProvider;

public class TyEndingDigitNamesProvider implements DigitNamesProvider {
	private static String[] ENDS_WITH_TY_UNIT_NAMES = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty",
			"Sixty", "Seventy", "Eighty", "Ninty" };

	@Override
	public String[] provideNames() {
		return ENDS_WITH_TY_UNIT_NAMES;
	}

}
