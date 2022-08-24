package by.jonline.module_6.home_library.dao;

import java.util.Map;

import by.jonline.module_6.home_library.entity.Book;

public interface BookDAO {

	Map<Book, Integer> getAllBooks() throws DAOException;

	boolean addBook(Book book) throws DAOException;

	boolean deleteBook(long idBook) throws DAOException;

	boolean deleteBook(Book book) throws DAOException;
}