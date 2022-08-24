package by.jonline.module_4.aggregation_and_composition.task2.entity;

import java.io.Serializable;

public class Wheel implements Serializable {

	private static final long serialVersionUID = 753106039395772361L;

	private double diameter;
	private TireType tireType;

	public Wheel() {
		this(0, TireType.NOT_SET);
	}

	public Wheel(double diameter, TireType tireType) {
		if (diameter > 0) {
			this.diameter = diameter;
		}
		if (tireType != null) {
			this.tireType = tireType;
		} else {
			this.tireType = TireType.NOT_SET;
		}
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		if (diameter > 0) {
			this.diameter = diameter;
		}
	}

	public TireType getTireType() {
		return tireType;
	}

	public void setTireType(TireType tireType) {
		if (tireType != null) {
			this.tireType = tireType;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(diameter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tireType == null) ? 0 : tireType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Wheel other = (Wheel) obj;

		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		return tireType == other.tireType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [diameter=").append(diameter).append(", tireType=")
				.append(tireType).append("]");
		return builder.toString();
	}
}