package by.jonline.module_5.task5.service;

import by.jonline.module_5.task5.bean.Candy;
import by.jonline.module_5.task5.bean.CandyType;
import by.jonline.module_5.task5.bean.candy_impl.Caramel;
import by.jonline.module_5.task5.bean.candy_impl.ChocolateCandy;
import by.jonline.module_5.task5.bean.candy_impl.Lollipop;
import by.jonline.module_5.task5.bean.candy_impl.Souffle;
import by.jonline.module_5.task5.bean.candy_impl.Toffee;
import by.jonline.module_5.task5.bean.candy_impl.TruffleCandy;

public class CandyFactory {

	public Candy getCandy(String candyType) throws ServiceException {

		CandyType candy;
		try {
			candy = CandyType.valueOf(candyType.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new ServiceException(e);
		}

		switch (candy) {
		case CARAMEL:
			return new Caramel();
		case CHOCOLATE:
			return new ChocolateCandy();
		case TOFFEE:
			return new Toffee();
		case SOUFFLE:
			return new Souffle();
		case LOLLIPOP:
			return new Lollipop();
		case TRUFFLE:
			return new TruffleCandy();
		default:
			throw new ServiceException("Candy doesn't exist yet.");
		}
	}
}