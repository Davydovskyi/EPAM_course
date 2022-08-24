package by.jonline.module_6.home_library.dao;

import by.jonline.module_6.home_library.dao.impl.FileBookDAO;
import by.jonline.module_6.home_library.dao.impl.FileUserDAO;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private final UserDAO userDAO = new FileUserDAO();
	private final BookDAO bookDAO = new FileBookDAO();

	private DAOProvider() {

	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}
}