package by.jonline.module_5.task4.bean;

import java.io.Serializable;

public class Treasure implements Serializable, Comparable<Treasure> {

	private static final long serialVersionUID = 6741454670446479204L;

	private String treasureName = "Treasure0";
	private int value;

	public Treasure() {
	}

	public Treasure(String treasureName, int value) {
		if (treasureName != null && !treasureName.trim().isEmpty()) {
			this.treasureName = treasureName;
		}
		if (value > 0) {
			this.value = value;
		}
	}

	public String getTreasureName() {
		return treasureName;
	}

	public void setTreasureName(String treasureName) {
		if (treasureName != null && !treasureName.trim().isEmpty()) {
			this.treasureName = treasureName;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value > 0) {
			this.value = value;
		}
	}

	@Override
	public int compareTo(Treasure o) {
		return Integer.compare(value, o.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((treasureName == null) ? 0 : treasureName.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Treasure other = (Treasure) obj;

		if (treasureName == null) {
			if (other.treasureName != null)
				return false;
		} else if (!treasureName.equals(other.treasureName))
			return false;
		return value == other.value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [treasureName=").append(treasureName).append(", value=")
				.append(value).append("]");
		return builder.toString();
	}
}