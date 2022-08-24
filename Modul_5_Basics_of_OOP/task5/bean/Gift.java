package by.jonline.module_5.task5.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import by.jonline.module_5.task5.bean.package_impl.SimplePackage;

public class Gift implements Serializable {

	private static final long serialVersionUID = -8543816570262948444L;

	private String name = "Your Gift";
	private Package giftPackage = new SimplePackage();
	private Map<Candy, Integer> candies = new HashMap<>();
	private int price = 0;

	public Gift() {
	}

	public Gift(String name, Map<Candy, Integer> candies, Package giftPackage) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}

		if (candies != null) {
			this.candies = candies;
		}

		if (giftPackage != null) {
			this.giftPackage = giftPackage;
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

	public Package getGiftPackage() {
		return giftPackage;
	}

	public void setGiftPackage(Package giftPackage) {
		if (giftPackage != null) {
			this.giftPackage = giftPackage;
		}
	}

	public Map<Candy, Integer> getCandies() {
		return candies;
	}

	public void setCandies(Map<Candy, Integer> candies) {
		if (candies != null) {
			this.candies = candies;
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

	public void addCandy(Candy candy, int count) {
		candies.merge(candy, count, (oldVal, newVal) -> oldVal + newVal);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candies == null) ? 0 : candies.hashCode());
		result = prime * result + ((giftPackage == null) ? 0 : giftPackage.hashCode());
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

		Gift other = (Gift) obj;
		if (candies == null) {
			if (other.candies != null)
				return false;
		} else if (!candies.equals(other.candies))
			return false;
		if (giftPackage == null) {
			if (other.giftPackage != null)
				return false;
		} else if (!giftPackage.equals(other.giftPackage))
			return false;
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
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", giftPackage=")
				.append(giftPackage).append(", candies=").append(candies.toString()).append(", price=").append(price)
				.append("]");
		return builder.toString();
	}
}