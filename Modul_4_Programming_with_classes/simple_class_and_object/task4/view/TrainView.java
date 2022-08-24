package by.jonline.module_4.simple_class_and_object.task4.view;

import java.text.SimpleDateFormat;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task4.entity.Train;

public class TrainView {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM в HH:mm");

	public void printAllTrains(String message, List<Train> listTrains) {

		System.out.println(message);
		System.out.println("------------------------------------");

		for (Train train : listTrains) {
			System.out.printf("Номер поезда: %d%nКуда: %s%nВремя отправления: %s.%n", train.getTrainNumber(),
					train.getDestination(), dateFormat.format(train.getDeprtureTime()));
			System.out.println("------------------------------------");
		}
	}

	public void printTrain(Train train) {
		System.out.printf("Куда: %s%nВремя отправления: %s.", train.getDestination(),
				dateFormat.format(train.getDeprtureTime()));
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}