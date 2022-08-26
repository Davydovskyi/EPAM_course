package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.User;
import by.jonline.module_6.home_library.entity.builder.UserBuilder;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;
import by.jonline.module_6.home_library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		boolean result;

		params = request.split(DELINETER);

		User user = new UserBuilder().withName(params[1].split("=")[1]).withSurname(params[2].split("=")[1])
				.withLogin(params[3].split("=")[1]).withPassword(params[4].split("=")[1])
				.withEmail(params[5].split("=")[1]).build();

		UserService service = ServiceProvider.getInstance().getUserService();

		try {
			result = service.registration(user);
			response = result ? "Successful registration" : "User with this login and email already exists";
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during rigistration procedure";
		}
		return response;
	}
}