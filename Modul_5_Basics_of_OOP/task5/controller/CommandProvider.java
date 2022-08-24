package by.jonline.module_5.task5.controller;

import java.util.HashMap;
import java.util.Map;

import by.jonline.module_5.task5.controller.impl.CreateGiftCommand;
import by.jonline.module_5.task5.controller.impl.NoCommand;

public class CommandProvider {

	private static final CommandProvider instance = new CommandProvider();

	private Map<String, Command> commands = new HashMap<>();

	private CommandProvider() {
		commands.put("createGift", new CreateGiftCommand());
		commands.put("noCommand", new NoCommand());
	}

	public static CommandProvider getInstance() {
		return instance;
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.getOrDefault(commandName, commands.get("noCommand"));
		return command;
	}
}