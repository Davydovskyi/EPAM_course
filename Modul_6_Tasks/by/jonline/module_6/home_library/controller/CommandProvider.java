package by.jonline.module_6.home_library.controller;

import java.util.EnumMap;
import java.util.Map;

import by.jonline.module_6.home_library.controller.impl.AddNewBookCommand;
import by.jonline.module_6.home_library.controller.impl.DeleteByBookCommand;
import by.jonline.module_6.home_library.controller.impl.DeleteByBookIdCommand;
import by.jonline.module_6.home_library.controller.impl.FindBookCommand;
import by.jonline.module_6.home_library.controller.impl.NoCommand;
import by.jonline.module_6.home_library.controller.impl.RegistrationCommand;
import by.jonline.module_6.home_library.controller.impl.ShowAllBooksCommand;
import by.jonline.module_6.home_library.controller.impl.SingInCommand;
import by.jonline.module_6.home_library.controller.impl.SuggestBookCommand;

public class CommandProvider {

	private static final CommandProvider instance = new CommandProvider();

	private Map<CommandName, Command> commands;

	private CommandProvider() {
		commands = new EnumMap<>(CommandName.class);

		commands.put(CommandName.SING_IN, new SingInCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.SUGGEST_BOOK, new SuggestBookCommand());
		commands.put(CommandName.ADD_NEW_BOOK, new AddNewBookCommand());
		commands.put(CommandName.DELETE_BY_BOOK, new DeleteByBookCommand());
		commands.put(CommandName.DELETE_BY_BOOK_ID, new DeleteByBookIdCommand());
		commands.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooksCommand());
		commands.put(CommandName.FIND_BOOK, new FindBookCommand());
		commands.put(CommandName.NO_COMMAND, new NoCommand());
	}

	public static CommandProvider getInstance() {
		return instance;
	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = commands.getOrDefault(commandName, commands.get(CommandName.NO_COMMAND));
		} catch (IllegalArgumentException | NullPointerException e) {
			// logging
			System.err.println(e);
			command = commands.get(CommandName.NO_COMMAND);
		}
		return command;
	}
}