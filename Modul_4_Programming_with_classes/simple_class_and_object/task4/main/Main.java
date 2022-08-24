package by.jonline.module_4.simple_class_and_object.task4.main;

import java.util.Date;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task4.entity.Depo;
import by.jonline.module_4.simple_class_and_object.task4.entity.Train;
import by.jonline.module_4.simple_class_and_object.task4.logic.TrainLogic;
import by.jonline.module_4.simple_class_and_object.task4.view.TrainView;

/**
 * Создайте класс Train, содержащий поля: название пункта назначения, номер
 * поезда, время отправления. Создайте данные в массив из пяти элементов типа
 * Train, добавьте возможность сортировки элементов массива по номерам поездов.
 * Добавьте возможность вывода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массив по пункту назначения,
 * причем поезда с одинаковыми пунктами назначения должны быть упорядочены по
 * времени отправления.
 */

public class Main {

	public static void main(String[] args) {

		Depo depo = new Depo();
		TrainLogic trainLogic = new TrainLogic();
		TrainView trainView = new TrainView();
		UserInput userInput = new UserInput();

		depo.addTrain(new Train("Варшава", 9, new Date(100034586)));
		depo.addTrain(new Train("Варшава", 6, new Date(10345876)));
		depo.addTrain(new Train("Москва", 11, new Date(1045745)));
		depo.addTrain(new Train("Москва", 14, new Date(1067953)));
		depo.addTrain(new Train("Астана", 7, new Date(10678967)));

		trainView.printAllTrains("Список доступных поездов: ", depo.getTrains());

		List<Train> sortedByNumber;
		sortedByNumber = trainLogic.sortByNumber(depo.getTrains());

		List<Train> sortedByDestination;
		sortedByDestination = trainLogic.sortByDestination(depo.getTrains());

		int findNumber;
		findNumber = userInput.enterTrainNumber("Пожалуйста, выберите номер поезда.");

		Train train;
		train = trainLogic.findByNumber(depo.getTrains(), findNumber);

		if (train == null) {
			trainView.printErrorMessage("Под номером " + findNumber + " поезда не существует.");
		} else {
			trainView.printTrain(train);
		}
	}
}