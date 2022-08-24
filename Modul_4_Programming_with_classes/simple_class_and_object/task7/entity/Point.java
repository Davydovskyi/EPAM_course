package by.jonline.module_4.simple_class_and_object.task7.entity;

import java.io.Serializable;

public class Point implements Serializable {

	private static final long serialVersionUID = 1090796773234892193L;

	private double x;
	private double y;

	public Point() {
		this(0, 0);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static double getDistance(Point a, Point b) {
		double dx = b.getX() - a.getX();
		double dy = b.getY() - a.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Point other = (Point) obj;

		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		return Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
}