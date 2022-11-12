package lab.designpattern.lab1.entity.digitnamesprovider;

import lab.designpattern.lab1.base.DigitNamesProvider;

public class BasicDigitNamesProvider implements DigitNamesProvider {
	private static String[] BASIC_DIGIT_NAMES = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine" };
	
	@Override
	public String[] provideNames() {
		return BASIC_DIGIT_NAMES;
	}

}