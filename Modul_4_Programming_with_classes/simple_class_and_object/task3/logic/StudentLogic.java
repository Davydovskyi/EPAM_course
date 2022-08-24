package by.jonline.module_4.simple_class_and_object.task3.logic;

import by.jonline.module_4.simple_class_and_object.task3.entity.Student;

public class StudentLogic {

	public boolean isStudentExcellent(Student student) {

		if (student == null) {
			return false;
		}

		int[] grades;
		grades = student.getGrades();

		for (int i : grades) {
			if (i < 9) {
				return false;
			}
		}
		return true;
	}
}