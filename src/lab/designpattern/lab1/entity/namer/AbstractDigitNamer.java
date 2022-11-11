package lab.designpattern.lab1.entity.namer;

import lab.designpattern.lab1.base.DigitNamer;
import lab.designpattern.lab1.factory.DigitNamesProviderFactory;
import lab.designpattern.lab1.factory.DigitNamesProviderFactory.ProviderType;

public abstract class AbstractDigitNamer implements DigitNamer {
	private DigitNamer nextDigitNamer;

	protected int getDigitFromNumber(long number, int digitNormalIndex) {

		int upperBound = (int) (number % Math.pow(10, digitNormalIndex + 1));
		int excessNumber = (int) (number % Math.pow(10, digitNormalIndex));
		int digit = upperBound - excessNumber;
		
		// remove all the trailing zeros
		while (digit >= 10) {
			digit /= 10;
		}

		return digit;
	}

	public void chain(DigitNamer nextDigitNamer) {
		this.nextDigitNamer = nextDigitNamer;
	}

	protected boolean isFinalDigitNamed(int inputNumber, int currentDigitNormalPositionIndex) {
		return currentDigitNormalPositionIndex >= String.valueOf(inputNumber).length();
	}

	protected DigitNamer getNextDigitNamer() {
		return this.nextDigitNamer;
	}

	protected String generateFinalName(int inputNumber, int currentDigitNormalPositionIndex, String rawName) {
		String finalName = String.format("%s %s",
				this.getNextDigitNamer().getName(inputNumber, currentDigitNormalPositionIndex + 1), rawName);

		finalName = finalName.trim().replaceAll("\\s{2}", "");

		if (String.valueOf(inputNumber).length() >= currentDigitNormalPositionIndex && finalName.isEmpty()) {
			finalName = "Zero";
		}

		return finalName;

	}

	protected String[] getDigitNames(ProviderType type) {
		return DigitNamesProviderFactory.getInstance().createDigitNamesInstance(type).provideNames();
	}

}
