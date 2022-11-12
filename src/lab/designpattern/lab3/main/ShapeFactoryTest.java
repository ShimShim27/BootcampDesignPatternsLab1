package lab.designpattern.lab3.main;

import lab.designpattern.lab3.factory.ShapeFactory;
import lab.designpattern.lab3.factory.ShapeFactory.ShapeType;

public class ShapeFactoryTest {
	public static void main(String[] args) {
		ShapeFactory factory = ShapeFactory.getInstance();
		
		factory.getShape(ShapeType.CIRCLE).draw();
		factory.getShape(ShapeType.RECTANGLE).draw();
		factory.getShape(ShapeType.SQUARE).draw();
	}
}
