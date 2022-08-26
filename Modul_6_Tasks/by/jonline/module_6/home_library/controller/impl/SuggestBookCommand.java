package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.builder.BookBuilder;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;
import by.jonline.module_6.home_library.service.UserService;

public class SuggestBookCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		params = request.split(DELINETER);

		Book book = new BookBuilder().withTitle(params[1].split("=")[1]).withAuthor(params[2].split("=")[1])
				.withPublicationYear(Integer.parseInt(params[3].split("=")[1]))
				.withCountOfPages(Integer.parseInt(params[4].split("=")[1])).build();

		UserService service = ServiceProvider.getInstance().getUserService();

		try {
			service.suggestBook(book);
			response = "Suggestion sent";
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during book suggestion procedure";
		}
		return response;
	}
}