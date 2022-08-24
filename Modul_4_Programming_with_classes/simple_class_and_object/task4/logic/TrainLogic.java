package by.jonline.module_4.simple_class_and_object.task4.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task4.entity.Train;

public class TrainLogic {

	public List<Train> sortByNumber(List<Train> trains) {

		List<Train> sortedTrains = new ArrayList<>();
		sortedTrains.addAll(trains);

		for (int i = 0; i < sortedTrains.size(); i++) {
			int minID = i;
			for (int j = i + 1; j < sortedTrains.size(); j++) {

				if (sortedTrains.get(minID).getTrainNumber() > sortedTrains.get(j).getTrainNumber()) {
					minID = j;
				}
			}
			swap(sortedTrains, minID, i);
		}
		return sortedTrains;
	}

	public List<Train> sortByDestination(List<Train> trains) {

		List<Train> sortedTrains = new ArrayList<>();
		sortedTrains.addAll(trains);

		boolean sorted = false;
		while (!sorted) {
			sorted = true;

			String destination1;
			String destination2;
			Date departureTime1;
			Date departureTime2;
			int compare;

			for (int i = 0; i < sortedTrains.size() - 1; i++) {

				destination1 = sortedTrains.get(i).getDestination();
				destination2 = sortedTrains.get(i + 1).getDestination();
				departureTime1 = sortedTrains.get(i).getDeprtureTime();
				departureTime2 = sortedTrains.get(i + 1).getDeprtureTime();

				compare = destination1.compareToIgnoreCase(destination2);

				if (compare > 0 || (compare == 0 && departureTime1.after(departureTime2))) {
					sorted = false;
					swap(sortedTrains, i, i + 1);
				}
			}
		}
		return sortedTrains;
	}

	public Train findByNumber(List<Train> trains, int findNumber) {

		Train foundTrain = null;

		for (Train train : trains) {
			if (train.getTrainNumber() == findNumber) {
				foundTrain = train;
			}
		}
		return foundTrain;
	}

	public void swap(List<Train> trains, int id1, int id2) {
		Train train = trains.get(id1);
		trains.set(id1, trains.get(id2));
		trains.set(id2, train);
	}
}