package by.jonline.module_5.task5.presentation.impl;

import java.util.Map;

import by.jonline.module_5.task5.bean.Candy;
import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.presentation.Presentation;

public class CreateGiftPresentation implements Presentation {

	@Override
	public String getResponse(Gift gift) {
		StringBuilder builder = new StringBuilder();
		if (gift != null && !gift.getCandies().isEmpty()) {
			builder.append("Подарок готов:\n");
			for (Map.Entry<Candy, Integer> pair : gift.getCandies().entrySet()) {
				builder.append(pair.getKey().getName()).append(" - ").append(pair.getValue()).append(" шт.\n");
			}

			builder.append("Стоимость - ").append(gift.getPrice());
			return builder.toString();
		} else {
			return "Подарок не создан.";
		}
	}
}