package by.jonline.module_6.home_library.service.util;

import java.time.LocalDate;

import by.jonline.module_6.home_library.entity.Book;

public class BookValidator {

	private static final String TITLE = ".{1,40}";
	private static final String AUTHOR = ".{1,40}";
	private static final LocalDate DATE = LocalDate.now();

	private BookValidator() {

	}

	public static boolean isCredentialValid(Book book) {
		if (book.getTitle() == null || !book.getTitle().matches(TITLE) || book.getAuthor() == null
				|| !book.getAuthor().matches(AUTHOR)) {
			return false;
		}
		if (book.getPublicationYear() < 1900 || book.getPublicationYear() > DATE.getYear()) {
			return false;
		}
		return book.getCountOfPages() > 1;
	}
}