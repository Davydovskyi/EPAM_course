package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.controller.CommandProvider;
import by.jonline.module_6.home_library.controller.Controller;

public class ControllerImpl implements Controller {

	private final CommandProvider commandProvider = CommandProvider.getInstance();

	@Override
	public String doAction(String request) {
		String[] params;
		String commandName;
		String response = null;

		params = request.split(DELIMETER);
		commandName = params[0];

		Command currentCommand = commandProvider.getCommand(commandName);

		response = currentCommand.execute(request);

		return response;
	}
}