package by.jonline.module_6.home_library.controller.impl;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.BookType;
import by.jonline.module_6.home_library.entity.builder.BookBuilder;
import by.jonline.module_6.home_library.service.BookService;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;

public class DeleteByBookCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		params = request.split(DELINETER);

		boolean result;

		Book book = new BookBuilder().withTitle(params[1].split("=")[1]).withAuthor(params[2].split("=")[1])
				.withPublicationYear(Integer.parseInt(params[3].split("=")[1]))
				.withCountOfPages(Integer.parseInt(params[4].split("=")[1]))
				.withBookType(BookType.valueOf(params[5].split("=")[1].toUpperCase())).build();

		BookService service = ServiceProvider.getInstance().getBookService();

		try {
			result = service.deleteBook(book);
			response = result ? "Book deleted" : "Book hasn't been deleted";
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during deleting book";
		}
		return response;
	}
}