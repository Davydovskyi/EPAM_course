package by.jonline.module_5.task4.controller;

import java.util.HashMap;
import java.util.Map;

import by.jonline.module_5.task4.controller.impl.GetTreasureCommand;
import by.jonline.module_5.task4.controller.impl.MostExpensiveTreasureCommand;
import by.jonline.module_5.task4.controller.impl.NoCommand;
import by.jonline.module_5.task4.controller.impl.TreasureForAmountCommand;

public class CommandProvider {

	private static final CommandProvider instance = new CommandProvider();

	private Map<String, Command> commands = new HashMap<>();

	private CommandProvider() {
		commands.put("getTreasure", new GetTreasureCommand());
		commands.put("mostExpensive", new MostExpensiveTreasureCommand());
		commands.put("forAmount", new TreasureForAmountCommand());
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