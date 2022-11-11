package lab.designpattern.lab1.main;
import lab.designpattern.lab1.entity.namer.HundredsDigitNamer;
import lab.designpattern.lab1.entity.namer.OnesDigitNamer;
import lab.designpattern.lab1.entity.namer.TensDigitNamer;
import lab.designpattern.lab1.entity.provider.TenToNineteenDigitNamesProvider;

public class Main {

	public static void main(String[] args) {

		OnesDigitNamer ones = new OnesDigitNamer();
		TensDigitNamer tens = new TensDigitNamer();
		HundredsDigitNamer hundreds = new HundredsDigitNamer();
		
		ones.chain(tens);
		tens.chain(hundreds);
		hundreds.chain(ones);
		
		new TenToNineteenDigitNamesProvider();
		System.out.println(ones.getName(Integer.MAX_VALUE, 0));
	}

}
