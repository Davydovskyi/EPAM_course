package by.jonline.module_5.task5.bean.candy_impl;

import by.jonline.module_5.task5.bean.Candy;

public class Caramel extends Candy {

	private static final long serialVersionUID = -3766535408795026166L;

	public Caramel() {
		super("Caramelka", 10);
	}

	public Caramel(String name, int price) {
		super(name, price);
	}
}