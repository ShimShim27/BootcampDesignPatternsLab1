package lab.designpattern.lab1.entity.namer;

import lab.designpattern.lab1.factory.DigitNamesProviderFactory.ProviderType;

public class TensDigitNamer extends AbstractDigitNamer {

	@Override
	public String getName(int inputNumber, int digitNormalPositionIndex) {
		if (this.isFinalDigitNamed(inputNumber, digitNormalPositionIndex)) {
			return "";
		}

		int digit = this.getDigitFromNumber(inputNumber, digitNormalPositionIndex);
		int previousDigit = this.getDigitFromNumber(inputNumber, digitNormalPositionIndex - 1);
		String name = this.getDigitNames(ProviderType.TYPE_TY_ENDING)[digit];
		if (digit == 1) {
			name = this.getDigitNames(ProviderType.TYPE_TO_TEN_NINETEEN)[previousDigit];
		}

		return this.generateFinalName(inputNumber, digitNormalPositionIndex, name);
	}

}
