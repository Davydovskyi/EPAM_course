package by.jonline.module_5.task2.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Payment implements Serializable {

	private static final long serialVersionUID = -4614843697412324924L;

	private long id;
	private Map<Product, Integer> products = new TreeMap<>();

	public Payment() {
	}

	public Payment(long id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public static class Product implements Serializable, Comparable<Product> {

		private static final long serialVersionUID = 2976905884860478491L;

		private String name = "New Item";
		private double price;

		public Product() {
		}

		public Product(String name, double price) {
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

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			if (price > 0) {
				this.price = price;
			}
		}

		@Override
		public int compareTo(Product o) {
			int compare = name.compareToIgnoreCase(o.getName());
			return compare != 0 ? compare : Double.compare(price, o.price);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;

			Product other = (Product) obj;

			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", price=").append(price)
					.append("]");
			return builder.toString();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Payment other = (Payment) obj;

		if (id != other.id)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", products=").append(products)
				.append("]");
		return builder.toString();
	}
}