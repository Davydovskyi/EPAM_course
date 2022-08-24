package by.jonline.module_4.simple_class_and_object.task6;

public class Main {

	public static void main(String[] args) {

		Time time = new Time(1, 4, 88);
		System.out.println(time.getTimeString());

		time.setSeconds(34);
		System.out.println(time.getTimeString());

		time.add(Time.HOUR, 10);
		System.out.println(time.getTimeString());

		time.add(Time.MINUTE, 6);
		System.out.println(time.getTimeString());

		time.add(Time.SECOND, 120);
		System.out.println(time.getTimeString());
	}
}