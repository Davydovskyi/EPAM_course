package by.jonline.module_6.home_library.service;

import java.util.List;
import java.util.Map;

import by.jonline.module_6.home_library.entity.Book;

public interface BookService {

	boolean addNewBook(Book book) throws ServiceException;

	Map<Book, Integer> showAllBooks() throws ServiceException;

	List<Book> findBook(Map<SearchParameter, String> parameters) throws ServiceException;

	boolean deleteBook(long bookId) throws ServiceException;

	boolean deleteBook(Book book) throws ServiceException;
}