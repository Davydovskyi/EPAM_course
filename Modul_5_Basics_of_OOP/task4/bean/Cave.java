package by.jonline.module_5.task4.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cave implements Serializable {

	private static final long serialVersionUID = -2488743716921607935L;

	private String name;
	private List<Treasure> treasures;

	public Cave() {
		name = "Dragon Cave";
		treasures = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void setTreasures(List<Treasure> treasures) {
		if (treasures != null) {
			this.treasures = treasures;
		}
	}

	public boolean addTreasure(Treasure treasure) {
		if (treasure != null) {
			return treasures.add(treasure);
		}
		return false;
	}

	public boolean removeTreasure(Treasure treasure) {
		return treasures.remove(treasure);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((treasures == null) ? 0 : treasures.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Cave other = (Cave) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (treasures == null) {
			if (other.treasures != null)
				return false;
		} else if (!treasures.equals(other.treasures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", treasures=")
				.append(treasures).append("]");
		return builder.toString();
	}
}