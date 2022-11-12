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
		
		System.out.println(ones.getName(1_000_000, 0));
		System.out.println(ones.getName(Integer.MAX_VALUE, 0));
		System.out.println(ones.getName(29, 0));
		System.out.println(ones.getName(69_000, 0));
		System.out.println(ones.getName(0, 0));
	}

}
