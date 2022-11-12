package lab.designpattern.lab1.entity.namer;

import lab.designpattern.lab1.factory.DigitNamesProviderFactory.ProviderType;

public class HundredsDigitNamer extends AbstractDigitNamer {
	private static String HUNDRED = "Hundred";

	@Override
	public String getName(int inputNumber, int digitNormalPositionIndex) {

		if (this.isFinalDigitNamed(inputNumber, digitNormalPositionIndex)) {
			return "";
		}

		int currentDigit = this.extractDigitFromNumber(inputNumber, digitNormalPositionIndex);

		String name = this.getDigitNames(ProviderType.TYPE_BASIC)[currentDigit];

		if (!name.isEmpty()) {
			name = String.format("%s %s", name, HUNDRED);
		}
		return this.generateFinalName(inputNumber, digitNormalPositionIndex, name);
	}

}
