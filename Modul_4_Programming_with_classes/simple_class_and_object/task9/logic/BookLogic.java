package by.jonline.module_4.simple_class_and_object.task9.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task9.entity.Book;

public class BookLogic {

	public List<Book> getBooksByAuthor(List<Book> books, String author) {

		List<Book> bookList = new ArrayList<>();

		for (Book book : books) {
			for (String name : book.getAuthors()) {
				if (name.equalsIgnoreCase(author)) {
					bookList.add(book);
				}
			}
		}
		return bookList;
	}

	public List<Book> getBooksByPublisher(List<Book> books, String publisher) {

		List<Book> bookList = new ArrayList<>();

		for (Book book : books) {
			if (book.getPublisher().equalsIgnoreCase(publisher)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	public List<Book> getBooksByYear(List<Book> books, int year) {

		List<Book> bookList = new ArrayList<>();

		for (Book book : books) {
			if (book.getYear() > year) {
				bookList.add(book);
			}
		}
		return bookList;
	}
}