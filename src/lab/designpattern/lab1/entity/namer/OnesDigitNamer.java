package lab.designpattern.lab1.entity.namer;

import lab.designpattern.lab1.factory.DigitNamesProviderFactory.ProviderType;

public class OnesDigitNamer extends AbstractDigitNamer {

	private static String[] THREE_DIGIT_GROUPING_NAMES = new String[] { "", "Thousand", "Million", "Billion",
			"Trillion", "Quadrillion", "" };

	@Override
	public String getName(int inputNumber, int digitNormalPositionIndex) {
		if (this.isFinalDigitNamed(inputNumber, digitNormalPositionIndex)) {
			return "";
		}

		int digit = this.getDigitFromNumber(inputNumber, digitNormalPositionIndex);
		String name = this.getDigitNames(ProviderType.TYPE_BASIC)[digit];

		int inputNumberCount = String.valueOf(inputNumber).length();
		boolean canGetNextDigit = digitNormalPositionIndex + 1 < inputNumberCount;
		boolean canGetTheNextTwoDigit = digitNormalPositionIndex + 2 < inputNumberCount;

		// Check the next digit if it is equal to one
		if (canGetNextDigit && this.getDigitFromNumber(inputNumber, digitNormalPositionIndex + 1) == 1) {
			name = "";
		}

		// check if the next two digit is equal to 0 when the current digit is 0
		String threeDigitGroupingName = THREE_DIGIT_GROUPING_NAMES[digitNormalPositionIndex / 3];

		if (digit == 0 && canGetNextDigit && this.getDigitFromNumber(inputNumber, digitNormalPositionIndex + 1) == 0) {
			if (canGetTheNextTwoDigit && this.getDigitFromNumber(inputNumber, digitNormalPositionIndex + 2) == 0) {
				threeDigitGroupingName = "";
			}
		}

		name = String.format("%s %s", name, threeDigitGroupingName);
		return this.generateFinalName(inputNumber, digitNormalPositionIndex, name);
	}

}
