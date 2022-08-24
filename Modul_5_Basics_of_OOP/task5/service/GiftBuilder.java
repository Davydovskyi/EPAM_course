package by.jonline.module_5.task5.service;

import by.jonline.module_5.task5.bean.Candy;
import by.jonline.module_5.task5.bean.Gift;

public class GiftBuilder {

	private Gift gift;

	public GiftBuilder() {
		gift = new Gift();
	}

	public GiftBuilder addCandy(Candy candy, int count) {
		gift.addCandy(candy, count);
		return this;
	}

	public Gift create() {
		return gift;
	}
}