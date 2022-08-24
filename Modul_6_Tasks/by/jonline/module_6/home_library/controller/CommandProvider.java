package by.jonline.module_6.home_library.controller;

import java.util.EnumMap;
import java.util.Map;

import by.jonline.module_6.home_library.controller.impl.AddNewBook;
import by.jonline.module_6.home_library.controller.impl.DeleteByBook;
import by.jonline.module_6.home_library.controller.impl.DeleteByBookId;
import by.jonline.module_6.home_library.controller.impl.FindBook;
import by.jonline.module_6.home_library.controller.impl.NoCommand;
import by.jonline.module_6.home_library.controller.impl.Registration;
import by.jonline.module_6.home_library.controller.impl.ShowAllBooks;
import by.jonline.module_6.home_library.controller.impl.SingIn;
import by.jonline.module_6.home_library.controller.impl.SuggestBook;

public class CommandProvider {

	private static final CommandProvider instance = new CommandProvider();

	private Map<CommandName, Command> commands;

	private CommandProvider() {
		commands = new EnumMap<>(CommandName.class);

		commands.put(CommandName.SING_IN, new SingIn());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.SUGGEST_BOOK, new SuggestBook());
		commands.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		commands.put(CommandName.DELETE_BY_BOOK, new DeleteByBook());
		commands.put(CommandName.DELETE_BY_BOOK_ID, new DeleteByBookId());
		commands.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooks());
		commands.put(CommandName.FIND_BOOK, new FindBook());
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