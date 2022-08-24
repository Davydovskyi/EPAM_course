package by.jonline.module_4.simple_class_and_object.task2;

import java.io.Serializable;
import java.util.Objects;

/**
 * Создйте класс Test2 двумя переменными. Добавьте конструктор с входными
 * параметрами. Добавьте конструктор, инициализирующий члены класса по
 * умолчанию. Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Test2 implements Serializable {

	private static final long serialVersionUID = 7490210241676842965L;

	private String name;
	private int b;

	public Test2() {
		this("", 0);
	}

	public Test2(String name, int b) {
		this.name = name;
		this.b = b;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [a=").append(name).append(", b=").append(b).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Test2 other = (Test2) obj;

		if (b != other.b)
			return false;
		return Objects.equals(name, other.name);
	}
}