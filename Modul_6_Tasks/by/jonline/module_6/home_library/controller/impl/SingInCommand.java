package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.Role;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;
import by.jonline.module_6.home_library.service.UserService;

public class SingInCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params = null;

		Role role;

		params = request.split(DELINETER);

		UserService service = ServiceProvider.getInstance().getUserService();

		try {
			role = service.singIn(params[1].split("=")[1], params[2].split("=")[1]);
			response = role != null ? "Welcome" : "Invalid login and password";
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during login procedure";
		}
		return response;
	}
}