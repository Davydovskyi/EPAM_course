package by.jonline.module_6.home_library.service;

import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.Role;
import by.jonline.module_6.home_library.entity.User;

public interface UserService {

	Role singIn(String login, String password) throws ServiceException;

	boolean registration(User user) throws ServiceException;

	boolean suggestBook(Book book) throws ServiceException;

	boolean sentNewBookNotification(Book book) throws ServiceException;
}