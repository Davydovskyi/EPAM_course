package by.jonline.module_4.simple_class_and_object.task7.entity;

import java.io.Serializable;
import java.util.Objects;

public class Triangle implements Serializable {

	private static final long serialVersionUID = -5093710413783963369L;

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle() {
		this(new Point(), new Point(), new Point());
	}

	public Triangle(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		result = prime * result + ((pointC == null) ? 0 : pointC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Triangle other = (Triangle) obj;

		if (!Objects.equals(pointA, other.pointA)) {
			return false;
		}
		if (!Objects.equals(pointB, other.pointB)) {
			return false;
		}
		return Objects.equals(pointC, other.pointC);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [pointA=").append(pointA).append(", pointB=").append(pointB)
				.append(", pointC=").append(pointC).append("]");
		return builder.toString();
	}
}