package by.jonline.module_4.simple_class_and_object.task4.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Depo implements Serializable {

	private static final long serialVersionUID = -1473665648046951296L;

	private List<Train> trains;

	public Depo() {
		trains = new ArrayList<>();
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void addTrain(Train train) {
		if (train != null) {
			trains.add(train);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trains == null) ? 0 : trains.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Depo other = (Depo) obj;

		return Objects.equals(trains, other.trains);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [trains=").append(trains.toString()).append("]");
		return builder.toString();
	}
}