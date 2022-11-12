package lab.designpattern.lab1.main;

import lab.designpattern.lab1.base.DigitNamer;
import lab.designpattern.lab1.factory.DigitNamerFactory;

public class Main {

	public static void main(String[] args) {

		DigitNamer namer = DigitNamerFactory.getInstance().createDigitNamerInstance();

		System.out.println(namer.getName(1_000_000, 0));
		System.out.println(namer.getName(Integer.MAX_VALUE, 0));
		System.out.println(namer.getName(29, 0));
		System.out.println(namer.getName(69_000, 0));
		System.out.println(namer.getName(0, 0));
	}

}
