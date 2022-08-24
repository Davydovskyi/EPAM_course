package by.jonline.module_4.simple_class_and_object.task3.main;

import java.util.Random;

import by.jonline.module_4.simple_class_and_object.task3.entity.Student;
import by.jonline.module_4.simple_class_and_object.task3.logic.StudentLogic;
import by.jonline.module_4.simple_class_and_object.task3.view.StudentView;

/**
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер
 * группы, успеваемость (массив из пяти элементов). Создайте массив из десяти
 * элементов такого типа. Добавьте возможность вывода фамилий и номеров групп
 * студентов, имеющих оценки, равные только 9 или 10.
 */

public class Main {

	public static void main(String[] args) {

		String surname = "Student";
		String initial = "S.T.";

		Student[] students = new Student[10];

		for (int i = 0; i < students.length - 1; i++) {
			students[i] = new Student((surname + (i + 1)), (initial + (i + 1)), (i + 2) / 2);
			students[i].setGrades(getGrades());
		}

		StudentLogic studentLogic = new StudentLogic();
		StudentView studentView = new StudentView();

		for (Student student : students) {

			if (studentLogic.isStudentExcellent(student)) {
				studentView.printSurnameAndGroup(" имеет только оценки 9 и выше.", student);
			}
		}
	}

	private static int[] getGrades() {

		int[] grades = new int[5];

		Random random = new Random();

		for (int i = 0; i < grades.length; i++) {
			grades[i] = random.nextInt(5) + 6;
		}
		return grades;
	}
}