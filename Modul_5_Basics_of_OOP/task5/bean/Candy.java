package by.jonline.module_5.task5.bean;

import java.io.Serializable;

public abstract class Candy implements Serializable, Comparable<Candy> {

	private static final long serialVersionUID = -2721011516291277457L;

	private String name = "Unknown candy";
	private int price = 1;

	public Candy() {

	}

	public Candy(String name, int price) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
		if (price > 0) {
			this.price = price;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		}
	}

	@Override
	public int compareTo(Candy o) {
		return name.compareToIgnoreCase(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Candy other = (Candy) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return price == other.price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", price=").append(price)
				.append("]");
		return builder.toString();
	}
}