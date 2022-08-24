package by.jonline.module_4.simple_class_and_object.task3.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Student implements Serializable {

	private static final long serialVersionUID = 7918128782990454717L;

	private static final int QUANTITY_OF_EXAMS = 5;
	private String surname;
	private String initials;
	private int group;
	private final int[] grades = new int[QUANTITY_OF_EXAMS];

	public Student() {
		this("", "", 0);
	}

	public Student(String surname, String initials, int group) {
		this.surname = surname;
		this.initials = initials;
		this.group = group;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {

		if (grades == null || grades.length > 5) {
			return;
		}

		System.arraycopy(grades, 0, this.grades, 0, grades.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(grades);
		result = prime * result + group;
		result = prime * result + ((initials == null) ? 0 : initials.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Student other = (Student) obj;

		if (!Arrays.equals(grades, other.grades))
			return false;
		if (group != other.group)
			return false;
		if (!Objects.equals(initials, other.initials))
			return false;
		return Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [surname=").append(surname).append(", initials=")
				.append(initials).append(", group=").append(group).append(", grades=").append(Arrays.toString(grades))
				.append("]");
		return builder.toString();
	}
}