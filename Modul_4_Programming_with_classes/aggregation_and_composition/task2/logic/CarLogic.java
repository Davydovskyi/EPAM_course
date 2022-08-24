package by.jonline.module_4.aggregation_and_composition.task2.logic;

import java.util.Random;

import by.jonline.module_4.aggregation_and_composition.task2.entity.Car;
import by.jonline.module_4.aggregation_and_composition.task2.entity.Wheel;

public class CarLogic {

	public boolean canMove(Car car) {
		if (car == null || car.getFuelLevel() < 10) {
			return false;
		}

		Wheel[] wheels = car.getWheels();
		double diametr = wheels[0].getDiameter();
		if (diametr > 0) {
			for (Wheel wheel : wheels) {
				if (diametr != wheel.getDiameter()) {
					return false;
				}
			}
		}
		return true;
	}

	public void refuel(Car car) {
		if (car != null) {
			Random random = new Random();
			int residualFuelLevel = car.getFuelLevel();
			int fuelLevel = random.nextInt(101 - residualFuelLevel);
			car.setFuelLevel(fuelLevel + car.getFuelLevel());
		}
	}

	public boolean changeWheel(Car car, Wheel wheel) {
		if (wheel == null || car == null) {
			return false;
		}
		car.getWheels()[0] = wheel;
		return true;
	}
}