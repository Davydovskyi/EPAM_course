package by.jonline.module_6.home_library.controller.impl;

import java.util.Set;

import by.jonline.module_6.home_library.controller.Command;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.service.BookService;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.ServiceProvider;

public class ShowAllBooksCommand implements Command {

	@Override
	public String execute(String request) {
		String response = null;

		Set<Book> books;

		BookService service = ServiceProvider.getInstance().getBookService();

		StringBuilder builder = new StringBuilder();
		try {
			books = service.showAllBooks().keySet();
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
				response = "Not found";
			}
		} catch (ServiceException e) {
			// logging
			System.err.println(e);
			response = "Error during books show procedure";
		}
		return response;
	}
}