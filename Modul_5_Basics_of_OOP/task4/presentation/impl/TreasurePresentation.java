package by.jonline.module_5.task4.presentation.impl;

import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.presentation.Presentation;

public class TreasurePresentation implements Presentation {

	@Override
	public String getAnswer(List<Treasure> treasures) {
		StringBuilder builder = new StringBuilder();

		if (treasures.isEmpty()) {
			return "Ничего не найдено.";
		}

		for (Treasure treasure : treasures) {
			builder.append(treasure.getTreasureName()).append(" стоимость - ").append(treasure.getValue()).append("\n");
		}
		return builder.toString();
	}
}