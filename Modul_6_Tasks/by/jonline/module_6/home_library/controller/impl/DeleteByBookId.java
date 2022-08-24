package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.service.BookService;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;

public class DeleteByBookId implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		params = request.split(DELINETER);

		boolean result;

		BookService service = ServiceProvider.getInstance().getBookService();

		try {
			result = service.deleteBook(Long.parseLong(params[1].split("=")[1]));
			response = result ? "Book deleted" : "Book hasn't been deleted";
		} catch (NumberFormatException | ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during deleting book";
		}
		return response;
	}
}