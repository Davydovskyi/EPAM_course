package by.jonline.module_4.simple_class_and_object.task9.view;

import java.util.List;

import by.jonline.module_4.simple_class_and_object.task9.entity.Book;

public class BookView {

	public void printBooks(String message, List<Book> books) {

		System.out.println(message);
		System.out.println("------------------------------------");

		for (Book book : books) {
			System.out.printf(
					"%s%nid: %d%nauthor(s): %s%npublisher: %s%nyear: %d%npages: %d%nprice: %.2f%nbinding: %s%n",
					book.getTitle(), book.getId(), book.getAuthors(), book.getPublisher(), book.getYear(),
					book.getNumberOfPages(), book.getPrice(), book.getBindingType());
			System.out.println("------------------------------------");
		}
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}