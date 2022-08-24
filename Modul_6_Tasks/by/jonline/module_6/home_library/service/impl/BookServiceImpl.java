package by.jonline.module_6.home_library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.jonline.module_6.home_library.dao.BookDAO;
import by.jonline.module_6.home_library.dao.DAOException;
import by.jonline.module_6.home_library.dao.DAOProvider;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.service.BookService;
import by.jonline.module_6.home_library.service.SearchParameter;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.util.BookValidator;

public class BookServiceImpl implements BookService {

	private final DAOProvider daoProvider = DAOProvider.getInstance();
	private final BookDAO bookDAO = daoProvider.getBookDAO();

	@Override
	public boolean addNewBook(Book book) throws ServiceException {
		if (!BookValidator.isCredentialValid(book)) {
			throw new ServiceException("Book data is incorrect.");
		}

		boolean result;

		try {
			result = bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public Map<Book, Integer> showAllBooks() throws ServiceException {
		Map<Book, Integer> books;
		try {
			books = new TreeMap<>(bookDAO.getAllBooks());
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return books;
	}

	@Override
	public List<Book> findBook(Map<SearchParameter, String> parameters) throws ServiceException {
		Stream<Book> booksStream;

		List<Book> books;

		try {
			books = new ArrayList<>(bookDAO.getAllBooks().keySet());
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		booksStream = books.stream();

		for (Map.Entry<SearchParameter, String> pair : parameters.entrySet()) {
			booksStream = pair.getKey().getFilter(booksStream, pair.getValue());
		}
		return booksStream.sorted().collect(Collectors.toList());
	}

	@Override
	public boolean deleteBook(long bookId) throws ServiceException {
		boolean result;

		try {
			result = bookDAO.deleteBook(bookId);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return result;
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		if (!BookValidator.isCredentialValid(book)) {
			throw new ServiceException("Book data is incorrect.");
		}

		boolean result;

		try {
			result = bookDAO.deleteBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}
}