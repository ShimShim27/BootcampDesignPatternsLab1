package lab.designpattern.lab1.factory;

import lab.designpattern.lab1.base.DigitNamer;
import lab.designpattern.lab1.entity.namer.HundredsDigitNamer;
import lab.designpattern.lab1.entity.namer.OnesDigitNamer;
import lab.designpattern.lab1.entity.namer.TensDigitNamer;

public class DigitNamerFactory {
	private static DigitNamerFactory INSTANCE;

	private DigitNamerFactory() {

	}

	public static DigitNamerFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DigitNamerFactory();
		}
		return INSTANCE;
	}

	public DigitNamer createDigitNameInstance() {
		OnesDigitNamer ones = new OnesDigitNamer();
		TensDigitNamer tens = new TensDigitNamer();
		HundredsDigitNamer hundreds = new HundredsDigitNamer();

		ones.chain(tens);
		tens.chain(hundreds);
		hundreds.chain(ones);

		return ones;
	}
}
