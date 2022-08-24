package by.jonline.module_4.aggregation_and_composition.task2.main;

import by.jonline.module_4.aggregation_and_composition.task2.entity.Car;
import by.jonline.module_4.aggregation_and_composition.task2.entity.EngineType;
import by.jonline.module_4.aggregation_and_composition.task2.entity.TireType;
import by.jonline.module_4.aggregation_and_composition.task2.entity.Wheel;
import by.jonline.module_4.aggregation_and_composition.task2.logic.CarLogic;
import by.jonline.module_4.aggregation_and_composition.task2.view.CarView;

/**
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы:
 * ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */

public class Main {

	public static void main(String[] args) {
		CarLogic carLogic = new CarLogic();
		CarView carView = new CarView();
		Car ford = new Car("Ford");

		ford.getEngine().setEngineType(EngineType.DIESEL);
		ford.getEngine().setPower(110);

		for (Wheel wheel : ford.getWheels()) {
			wheel.setDiameter(23);
			wheel.setTireType(TireType.ALL_SEASON);
		}

		carLogic.refuel(ford);

		boolean changedWheel;
		changedWheel = carLogic.changeWheel(ford, new Wheel(34, TireType.WINTER));
		if (changedWheel) {
			carView.printMessage("Колесо поменяли...");
		} else {
			carView.printMessage("Ошибка, не заменить колесо....");
		}

		boolean moving;
		moving = carLogic.canMove(ford);
		if (moving) {
			carView.printMessage("Поехали....");
		} else {
			carView.printMessage("Ошибка, не удалось поехать....");
		}

		carView.printModel(ford);
	}
}