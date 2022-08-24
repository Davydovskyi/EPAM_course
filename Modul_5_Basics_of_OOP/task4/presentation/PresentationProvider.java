package by.jonline.module_5.task4.presentation;

import by.jonline.module_5.task4.presentation.impl.TreasurePresentation;

public class PresentationProvider {

	private static final PresentationProvider instance = new PresentationProvider();

	private Presentation presentation = new TreasurePresentation();

	private PresentationProvider() {
	}

	public static PresentationProvider getInstance() {
		return instance;
	}

	public Presentation getPresentation() {
		return presentation;
	}
}