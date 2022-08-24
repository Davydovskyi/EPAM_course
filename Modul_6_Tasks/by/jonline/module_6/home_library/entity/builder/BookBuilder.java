package by.jonline.module_6.home_library.entity.builder;

import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.BookType;

public class BookBuilder {

	private Book book;

	public BookBuilder() {
		book = new Book();
	}

	public BookBuilder withId(long id) {
		book.setId(id);
		return this;
	}

	public BookBuilder withTitle(String title) {
		book.setTitle(title);
		return this;
	}

	public BookBuilder withAuthor(String author) {
		book.setAuthor(author);
		return this;
	}

	public BookBuilder withPublicationYear(int year) {
		book.setPublicationYear(year);
		return this;
	}

	public BookBuilder withBookType(BookType bookType) {
		book.setBookType(bookType);
		return this;
	}

	public BookBuilder withCountOfPages(int pages) {
		book.setCountOfPages(pages);
		return this;
	}

	public Book build() {
		return book;
	}
}