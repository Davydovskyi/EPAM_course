package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;

public class NoCommand implements Command {

	@Override
	public String execute(String request) {
		return "It's not available yet";
	}
}