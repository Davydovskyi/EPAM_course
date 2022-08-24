package by.jonline.module_4.simple_class_and_object.task7.view;

import by.jonline.module_4.simple_class_and_object.task7.entity.Point;

public class TriangeView {

	public void printErrorMessage(String message) {
		System.out.println(message);
	}

	public void print(String message, double value) {
		System.out.printf("%s%.3f%n", message, value);
	}

	public void printPoint(String message, Point point) {
		System.out.printf("%s [%.3f, %.3f]%n", message, point.getX(), point.getY());
	}
}