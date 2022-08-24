package by.jonline.module_5.task5.presentation;

import java.util.HashMap;
import java.util.Map;

import by.jonline.module_5.task5.presentation.impl.CreateGiftPresentation;
import by.jonline.module_5.task5.presentation.impl.NoPresentation;

public class PresentationProvider {

	private static final PresentationProvider instance = new PresentationProvider();

	private Map<String, Presentation> presenations = new HashMap<>();

	private PresentationProvider() {
		presenations.put("createGift", new CreateGiftPresentation());
		presenations.put("noPresentation", new NoPresentation());
	}

	public static PresentationProvider getInstance() {
		return instance;
	}

	public Presentation getPresentation(String presentationName) {
		Presentation presentation;
		presentation = presenations.getOrDefault(presentationName, presenations.get("noPresentation"));
		return presentation;
	}
}