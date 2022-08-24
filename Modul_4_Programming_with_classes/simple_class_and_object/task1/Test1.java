package by.jonline.module_4.simple_class_and_object.task1;

import java.io.Serializable;

/**
 * Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и
 * методы изменения этих переменных. Добавьте метод, который находит сумму
 * значений этих переменных, и метод, который находит наибольшее значение из
 * этих двух переменных.
 */

public class Test1 implements Serializable {

	private static final long serialVersionUID = 8971144598008828942L;

	private int x;
	private int y;

	public Test1() {
		this(0, 0);
	}

	public Test1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void printAll() {
		System.out.println("x = " + x + ", y = " + y);
	}

	public int getMax() {
		return x > y ? x : y;
	}

	public int getSum() {
		return x + y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Test1 other = (Test1) obj;

		if (x != other.x)
			return false;
		return y != other.y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
}