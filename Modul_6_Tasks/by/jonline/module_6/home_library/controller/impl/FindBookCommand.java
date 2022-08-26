package by.jonline.module_6.home_library.controller.impl;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.service.BookService;
import by.jonline.module_6.home_library.service.SearchParameter;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;

public class FindBookCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		params = request.split(DELINETER);

		Map<SearchParameter, String> parameters = new EnumMap<>(SearchParameter.class);

		for (int i = 1; i < params.length - 1; i += 2) {
			try {
				parameters.put(SearchParameter.valueOf(params[i].split("=")[1].toUpperCase()),
						params[i + 1].split("=")[1]);
			} catch (IllegalArgumentException | NullPointerException e) {
				// logging
				System.err.println(e);
				parameters.put(SearchParameter.BY_ID, "");
			}
		}

		List<Book> books = null;

		BookService service = ServiceProvider.getInstance().getBookService();

		StringBuilder builder = new StringBuilder();
		try {
			books = service.findBook(parameters);
			if (!books.isEmpty()) {
				for (Book book : books) {
					builder.append("Id: ").append(book.getId()).append("\nTitle: ").append(book.getTitle())
							.append("\nAuthor: ").append(book.getAuthor()).append("\nPublication year: ")
							.append(book.getPublicationYear()).append("\nCount of page: ")
							.append(book.getCountOfPages()).append("\nType: ").append(book.getBookType())
							.append("\n\n");
				}
				response = builder.toString();
			} else {
				response = "Nothing found";
			}
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during book search";
		}
		return response;
	}
}