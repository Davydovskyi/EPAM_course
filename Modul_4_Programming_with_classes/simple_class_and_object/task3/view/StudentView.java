package by.jonline.module_4.simple_class_and_object.task3.view;

import by.jonline.module_4.simple_class_and_object.task3.entity.Student;

public class StudentView {

	public void printSurnameAndGroup(String message, Student student) {
		System.out.println(student.getSurname() + " из группы " + student.getGroup() + message);
	}
}