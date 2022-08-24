package by.jonline.module_5.task5.bean.candy_impl;

import by.jonline.module_5.task5.bean.Candy;

public class ChocolateCandy extends Candy {

	private static final long serialVersionUID = -1422939990348418050L;

	public ChocolateCandy() {
		super("Chocolate Candy", 20);
	}

	public ChocolateCandy(String name, int price) {
		super(name, price);
	}
}
