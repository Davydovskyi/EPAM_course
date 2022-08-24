package by.jonline.module_4.aggregation_and_composition.task5.entity;

import java.io.Serializable;

public class TravelVoucher implements Serializable {

	private static final long serialVersionUID = 4983498047212686360L;

	private TypeOfVoucher typeOfVoucher;
	private FoodType foodType;
	private TypeOfTransport transport;
	private int days;
	private int price;

	public TravelVoucher() {
		this(TypeOfVoucher.NOT_SET, FoodType.NOT_SET, TypeOfTransport.WITHOUT_TRANSPORT, 0);
	}

	public TravelVoucher(TypeOfVoucher typeOfVoucher, FoodType foodType, TypeOfTransport transport, int days) {
		if (typeOfVoucher != null) {
			this.typeOfVoucher = typeOfVoucher;
		} else {
			this.typeOfVoucher = TypeOfVoucher.NOT_SET;
		}

		if (foodType != null) {
			this.foodType = foodType;
		} else {
			this.foodType = FoodType.NOT_SET;
		}

		if (transport != null) {
			this.transport = transport;
		} else {
			this.transport = TypeOfTransport.WITHOUT_TRANSPORT;
		}

		if (days > 0) {
			this.days = days;
		}

		this.price = 0;
	}

	public TypeOfVoucher getTypeOfVoucher() {
		return typeOfVoucher;
	}

	public void setTypeOfVaucher(TypeOfVoucher typeOfVoucher) {
		if (typeOfVoucher != null) {
			this.typeOfVoucher = typeOfVoucher;
		}
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		if (foodType != null) {
			this.foodType = foodType;
		}
	}

	public TypeOfTransport getTransport() {
		return transport;
	}

	public void setTransport(TypeOfTransport transport) {
		if (transport != null) {
			this.transport = transport;
		}
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		if (days > 0) {
			this.days = days;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
		result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
		result = prime * result + price;
		result = prime * result + ((transport == null) ? 0 : transport.hashCode());
		result = prime * result + ((typeOfVoucher == null) ? 0 : typeOfVoucher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		TravelVoucher other = (TravelVoucher) obj;

		if (days != other.days)
			return false;
		if (foodType != other.foodType)
			return false;
		if (price != other.price)
			return false;
		if (transport != other.transport)
			return false;
		return typeOfVoucher == other.typeOfVoucher;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [typeOfVoucher=").append(typeOfVoucher)
				.append(", foodType=").append(foodType).append(", transport=").append(transport).append(", days=")
				.append(days).append(", price=").append(price).append("]");
		return builder.toString();
	}
}