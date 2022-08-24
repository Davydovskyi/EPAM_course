package by.jonline.module_5.task5.service.impl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.jonline.module_5.task5.bean.Candy;
import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.service.CandyFactory;
import by.jonline.module_5.task5.service.GiftBuilder;
import by.jonline.module_5.task5.service.GiftService;
import by.jonline.module_5.task5.service.ServiceException;

public class GiftServiceImpl implements GiftService {

	private CandyFactory factory = new CandyFactory();

	@Override
	public Gift createGift(String[] params) throws ServiceException {
		GiftBuilder builder = new GiftBuilder();

		Gift gift;

		Candy candy;
		int countOfCandy;

		Pattern pattern = Pattern.compile("\\d{1,9}");
		Matcher matcher;

		String[] temp;

		for (String param : params) {
			temp = param.split("=");
			candy = factory.getCandy(temp[0]);
			matcher = pattern.matcher(temp[1]);

			if (matcher.matches()) {
				countOfCandy = Integer.parseInt(param.split("=")[1]);
				builder.addCandy(candy, countOfCandy);
			} else {
				throw new ServiceException("Invalid parametr.");
			}
		}

		gift = builder.create();
		gift.setPrice(calculatePrice(gift));

		return gift;
	}

	@Override
	public int calculatePrice(Gift gift) throws ServiceException {
		int price = 0;
		if (gift != null) {
			for (Map.Entry<Candy, Integer> pair : gift.getCandies().entrySet()) {
				price += pair.getKey().getPrice() * pair.getValue();
			}
		} else {
			throw new ServiceException("Not Exist.", new NullPointerException());
		}
		price += gift.getGiftPackage().getPrice();
		return price;
	}
}