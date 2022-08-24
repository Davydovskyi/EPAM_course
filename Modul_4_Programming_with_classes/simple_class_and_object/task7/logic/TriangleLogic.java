package by.jonline.module_4.simple_class_and_object.task7.logic;

import by.jonline.module_4.simple_class_and_object.task7.entity.Point;
import by.jonline.module_4.simple_class_and_object.task7.entity.Triangle;

public class TriangleLogic {

	public double getPerimeter(Triangle triangle) {

		if (!exists(triangle)) {
			return 0;
		}

		double ab;
		double ac;
		double bc;

		ab = Point.getDistance(triangle.getPointA(), triangle.getPointB());
		ac = Point.getDistance(triangle.getPointA(), triangle.getPointC());
		bc = Point.getDistance(triangle.getPointB(), triangle.getPointC());

		return ab + ac + bc;
	}

	public double getSquare(Triangle triangle) {

		if (!exists(triangle)) {
			return 0;
		}

		double temp1 = (triangle.getPointB().getX() - triangle.getPointA().getX())
				* (triangle.getPointC().getY() - triangle.getPointA().getY());
		double temp2 = (triangle.getPointC().getX() - triangle.getPointA().getX())
				* (triangle.getPointB().getY() - triangle.getPointA().getY());

		return Math.abs(temp1 - temp2) / 2;
	}

	public Point getMedianPoint(Triangle triangle) {

		if (!exists(triangle)) {
			return null;
		}

		double x;
		double y;

		x = (triangle.getPointA().getX() + triangle.getPointB().getX() + triangle.getPointC().getX()) / 3;
		y = (triangle.getPointA().getY() + triangle.getPointB().getY() + triangle.getPointC().getY()) / 3;

		return new Point(x, y);
	}

	private boolean exists(Triangle triangle) {

		if (triangle == null || triangle.getPointA() == null || triangle.getPointB() == null
				|| triangle.getPointC() == null) {
			return false;
		}

		double ab;
		double ac;
		double bc;

		ab = Point.getDistance(triangle.getPointA(), triangle.getPointB());
		ac = Point.getDistance(triangle.getPointA(), triangle.getPointC());
		bc = Point.getDistance(triangle.getPointB(), triangle.getPointC());

		return ab + bc > ac && ab + ac > bc && bc + ac > ab;
	}
}