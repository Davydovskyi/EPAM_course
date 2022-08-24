package by.jonline.module_5.task5.presentation.impl;

import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.presentation.Presentation;

public class NoPresentation implements Presentation {

	@Override
	public String getResponse(Gift gift) {
		return "Error.";
	}
}