package by.jonline.module_4.aggregation_and_composition.task2.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Car implements Serializable {

	private static final long serialVersionUID = 2729698361649064029L;

	private String model;
	private Wheel[] wheels;
	private Engine engine;
	private int fuelLevel;

	public Car() {
		this("");
	}

	public Car(String model) {
		this.model = model;
		wheels = new Wheel[] { new Wheel(), new Wheel(), new Wheel(), new Wheel() };
		engine = new Engine();
		fuelLevel = 50;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Wheel[] getWheels() {
		return wheels;
	}

	public void setWheels(Wheel[] wheels) {
		if (wheels != null && wheels.length == 4) {
			this.wheels = wheels;
		}
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		if (engine != null) {
			this.engine = engine;
		}
	}

	public int getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(int fuelLevel) {
		if (fuelLevel > 0 || fuelLevel < 100) {
			this.fuelLevel = fuelLevel;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + fuelLevel;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + Arrays.hashCode(wheels);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Car other = (Car) obj;

		if (!Objects.equals(engine, other.engine)) {
			return false;
		}
		if (!Objects.equals(model, other.model)) {
			return false;
		}
		if (!Arrays.equals(wheels, other.wheels))
			return false;
		return fuelLevel == other.fuelLevel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [model=").append(model).append(", wheels=")
				.append(Arrays.toString(wheels)).append(", engine=").append(engine).append(", fuelLevel=")
				.append(fuelLevel).append("]");
		return builder.toString();
	}
}