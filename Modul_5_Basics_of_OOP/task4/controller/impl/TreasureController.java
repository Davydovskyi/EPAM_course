package by.jonline.module_5.task4.controller.impl;

import java.util.List;

import by.jonline.module_5.task4.bean.Cave;
import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.controller.Command;
import by.jonline.module_5.task4.controller.CommandProvider;
import by.jonline.module_5.task4.controller.Controller;
import by.jonline.module_5.task4.presentation.PresentationProvider;
import by.jonline.module_5.task4.service.ServiceException;

public class TreasureController implements Controller {

	private final CommandProvider comProvider = CommandProvider.getInstance();
	private final PresentationProvider presProvider = PresentationProvider.getInstance();

	@Override
	public String doAction(String request) {
		String[] params;
		String commandName;

		Cave cave = new Cave();

		List<Treasure> result = null;

		params = request.split("\\s+");
		commandName = params[0];

		Command currentCommand = comProvider.getCommand(commandName);

		String response = null;
		try {
			result = currentCommand.excute(cave.getTreasures(), request);
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			return "Error";
		}

		response = presProvider.getPresentation().getAnswer(result);
		return response;
	}
}