package by.jonline.module_5.task5.controller.impl;

import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.controller.Command;
import by.jonline.module_5.task5.controller.CommandProvider;
import by.jonline.module_5.task5.controller.Contoller;
import by.jonline.module_5.task5.presentation.Presentation;
import by.jonline.module_5.task5.presentation.PresentationProvider;
import by.jonline.module_5.task5.service.ServiceException;

public class GiftController implements Contoller {

	private CommandProvider commandProvider = CommandProvider.getInstance();
	private PresentationProvider presentationProvider = PresentationProvider.getInstance();

	@Override
	public String doAction(String request) {

		Gift gift = null;

		Command command;
		command = commandProvider.getCommand(request.split(" ")[0]);

		try {
			gift = command.execute(request);
		} catch (ServiceException e) {
			// Logging
			System.err.println(e);
			return "Error.";
		}

		Presentation presentation;
		presentation = presentationProvider.getPresentation(request.split(" ")[0]);

		return presentation.getResponse(gift);
	}
}