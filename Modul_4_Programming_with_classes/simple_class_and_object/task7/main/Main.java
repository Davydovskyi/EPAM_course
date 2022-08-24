package by.jonline.module_4.simple_class_and_object.task7.main;

import by.jonline.module_4.simple_class_and_object.task7.entity.Point;
import by.jonline.module_4.simple_class_and_object.task7.entity.Triangle;
import by.jonline.module_4.simple_class_and_object.task7.logic.TriangleLogic;
import by.jonline.module_4.simple_class_and_object.task7.view.TriangeView;

/**
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания
 * объектов, вычисления площади, периметра и точки пересечения медиан.
 */

public class Main {

	public static void main(String[] args) {

		Triangle triangle = new Triangle(new Point(-1, -3), new Point(3, 4), new Point(5, -5));
		TriangleLogic triangleLogic = new TriangleLogic();
		TriangeView triangeView = new TriangeView();

		double perimeter;
		double square;

		String errorMessage = "Треугольник не существует.";

		perimeter = triangleLogic.getPerimeter(triangle);

		if (perimeter == 0) {
			triangeView.printErrorMessage(errorMessage);
		}

		triangeView.print("Perimeter = ", perimeter);

		square = triangleLogic.getSquare(triangle);

		if (square == 0) {
			triangeView.printErrorMessage(errorMessage);
		}

		triangeView.print("Square = ", square);

		Point medianPoint;
		medianPoint = triangleLogic.getMedianPoint(triangle);

		if (medianPoint == null) {
			triangeView.printErrorMessage(errorMessage);
		} else {
			triangeView.printPoint("Координаты точки пересечения медиан треугольника", medianPoint);
		}
	}
}