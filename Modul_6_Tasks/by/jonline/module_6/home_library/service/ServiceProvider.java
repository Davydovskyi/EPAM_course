package by.jonline.module_6.home_library.service;

import by.jonline.module_6.home_library.service.impl.BookServiceImpl;
import by.jonline.module_6.home_library.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private final UserService userService = new UserServiceImpl();
	private final BookService bookService = new BookServiceImpl();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}
}