package by.jonline.module_4.aggregation_and_composition.task2.view;

import by.jonline.module_4.aggregation_and_composition.task2.entity.Car;

public class CarView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printModel(Car car) {
		System.out.println(car.getModel());
	}
}