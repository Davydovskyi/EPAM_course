package by.jonline.module_4.simple_class_and_object.task4.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Train implements Serializable {

	private static final long serialVersionUID = -9128495108511229229L;

	private String destination;
	private int trainNumber;
	private Date deprtureTime;

	public Train() {
		this("", 0, new Date(0));
	}

	public Train(String destination, int number, Date deprtureTime) {
		this.destination = destination;
		this.trainNumber = number;
		this.deprtureTime = deprtureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Date getDeprtureTime() {
		return deprtureTime;
	}

	public void setDeprtureTime(Date deprtureTime) {
		if (deprtureTime != null) {
			this.deprtureTime = deprtureTime;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deprtureTime == null) ? 0 : deprtureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + trainNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Train other = (Train) obj;

		if (trainNumber != other.trainNumber)
			return false;
		if (!Objects.equals(destination, other.destination))
			return false;
		return Objects.equals(deprtureTime, other.deprtureTime);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [destination=").append(destination).append(", trainNumber=")
				.append(trainNumber).append(", deprtureTime=").append(deprtureTime.toString()).append("]");
		return builder.toString();
	}
}