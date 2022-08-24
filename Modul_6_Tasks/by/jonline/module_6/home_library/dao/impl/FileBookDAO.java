package by.jonline.module_6.home_library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import by.jonline.module_6.home_library.dao.BookDAO;
import by.jonline.module_6.home_library.dao.DAOException;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.BookType;
import by.jonline.module_6.home_library.entity.builder.BookBuilder;

public class FileBookDAO implements BookDAO {

	private static final String BOOKS_SOURCE = "src/sources/books.txt";
	private static final String PARAM_DELIMETER = "' '";
	private static final String DELIMETER = "' '";

	@Override
	public Map<Book, Integer> getAllBooks() throws DAOException {
		Map<Book, Integer> books = new HashMap<>();

		String line = null;
		String[] params = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_SOURCE))) {
			while ((line = reader.readLine()) != null) {
				params = line.split(PARAM_DELIMETER);
				Book book = new BookBuilder().withId(Integer.parseInt(params[0])).withTitle(params[1])
						.withAuthor(params[2]).withPublicationYear(Integer.parseInt(params[3]))
						.withCountOfPages(Integer.parseInt(params[4])).withBookType(BookType.valueOf(params[5]))
						.build();
				books.put(book, Integer.parseInt(params[6]));
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return books;
	}

	@Override
	public boolean addBook(Book book) throws DAOException {
		Map<Book, Integer> books;
		books = getAllBooks();

		TreeSet<Book> sortedBooks = null;

		long lastId = 0;

		if (books.containsKey(book)) {
			if (book.getBookType() == BookType.PAPER_BOOK) {
				books.replace(book, books.get(book) + 1);
			} else {
				return false;
			}
		} else {
			sortedBooks = new TreeSet<>(books.keySet());
			lastId = sortedBooks.size();
			book.setId(++lastId);
			books.put(book, 1);
		}
		saveBooks(books);
		return true;
	}

	@Override
	public boolean deleteBook(long bookID) throws DAOException {
		Map<Book, Integer> books;
		books = getAllBooks();

		Book book = null;

		for (Map.Entry<Book, Integer> pair : books.entrySet()) {
			if (pair.getKey().getId() == bookID) {
				book = pair.getKey();
				break;
			}
		}

		if (book != null) {
			if (books.get(book) > 1) {
				books.replace(book, books.get(book) - 1);
			} else {
				books.remove(book);
			}
		} else {
			return false;
		}
		saveBooks(books);
		return true;
	}

	@Override
	public boolean deleteBook(Book book) throws DAOException {
		Map<Book, Integer> books;
		books = getAllBooks();

		Integer countOfBooks;
		countOfBooks = books.get(book);

		if (countOfBooks != null) {
			if (countOfBooks > 1) {
				books.replace(book, books.get(book) - 1);
			} else {
				books.remove(book);
			}
		} else {
			return false;
		}
		saveBooks(books);
		return true;
	}

	private void saveBooks(Map<Book, Integer> books) throws DAOException {
		long id = 0;

		Map<Book, Integer> sortedBooks = new TreeMap<>(books);

		Book book;
		StringBuilder builder = new StringBuilder();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_SOURCE))) {
			for (Map.Entry<Book, Integer> pair : sortedBooks.entrySet()) {
				book = pair.getKey();
				book.setId(++id);
				builder.append(book.getId()).append(DELIMETER).append(book.getTitle()).append(DELIMETER)
						.append(book.getAuthor()).append(DELIMETER).append(book.getPublicationYear()).append(DELIMETER)
						.append(book.getCountOfPages()).append(DELIMETER).append(book.getBookType()).append(DELIMETER)
						.append(pair.getValue());
				writer.write(builder.toString());
				writer.newLine();
				builder.setLength(0);
			}
		} catch (IOException e) {
			throw new DAOException();
		}
	}
}