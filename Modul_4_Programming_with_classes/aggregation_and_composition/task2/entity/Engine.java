package by.jonline.module_4.aggregation_and_composition.task2.entity;

import java.io.Serializable;

public class Engine implements Serializable {

	private static final long serialVersionUID = -2353124159197438157L;

	private static long id = 1000000000;
	private long number;
	private double power;
	private EngineType engineType;

	public Engine() {
		this(0, EngineType.NOT_SET);
		this.number = 0;
	}

	public Engine(double power, EngineType engineType) {
		this.number = id++;

		if (power > 0) {
			this.power = power;
		}
		if (engineType != null) {
			this.engineType = engineType;
		} else {
			this.engineType = EngineType.NOT_SET;
		}
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		if (number > 0) {
			this.number = number;
		}
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		if (power > 0) {
			this.power = power;
		}
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		if (engineType != null) {
			this.engineType = engineType;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engineType == null) ? 0 : engineType.hashCode());
		result = prime * result + (int) (number ^ (number >>> 32));
		long temp;
		temp = Double.doubleToLongBits(power);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Engine other = (Engine) obj;

		if (engineType != other.engineType)
			return false;
		if (Double.doubleToLongBits(power) != Double.doubleToLongBits(other.power))
			return false;
		return number == other.number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [number=").append(number).append(", power=").append(power)
				.append(", engineType=").append(engineType).append("]");
		return builder.toString();
	}
}