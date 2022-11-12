package lab.designpattern.lab3.factory;

import lab.designpattern.lab3.base.Shape;
import lab.designpattern.lab3.model.Circle;
import lab.designpattern.lab3.model.Rectangle;
import lab.designpattern.lab3.model.Square;

public class ShapeFactory {
	private static ShapeFactory INSTANCE;

	private ShapeFactory() {

	}

	public static ShapeFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ShapeFactory();
		}

		return INSTANCE;
	}

	public Shape getShape(ShapeType type) {
		Shape shape = null;
		switch (type) {
		case CIRCLE:
			shape = new Circle();
			break;
		case SQUARE:
			shape = new Square();
			break;
		case RECTANGLE:
			shape = new Rectangle();
			break;
		}
		return shape;
	}

	public static enum ShapeType {
		CIRCLE, SQUARE, RECTANGLE
	}
}
