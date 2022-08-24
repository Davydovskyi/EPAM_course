package by.jonline.module_5.task5.bean.candy_impl;

import by.jonline.module_5.task5.bean.Candy;

public class TruffleCandy extends Candy {

	private static final long serialVersionUID = -5777809880015256985L;

	public TruffleCandy() {
		super("Napoleon", 45);
	}

	public TruffleCandy(String name, int price) {
		super(name, price);
	}
}