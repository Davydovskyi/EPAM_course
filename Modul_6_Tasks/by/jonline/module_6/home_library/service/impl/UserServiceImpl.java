package by.jonline.module_6.home_library.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import by.jonline.module_6.home_library.dao.DAOException;
import by.jonline.module_6.home_library.dao.DAOProvider;
import by.jonline.module_6.home_library.dao.UserDAO;
import by.jonline.module_6.home_library.entity.Book;
import by.jonline.module_6.home_library.entity.Role;
import by.jonline.module_6.home_library.entity.User;
import by.jonline.module_6.home_library.service.ServiceException;
import by.jonline.module_6.home_library.service.UserService;
import by.jonline.module_6.home_library.service.util.BookValidator;
import by.jonline.module_6.home_library.service.util.EmailSender;
import by.jonline.module_6.home_library.service.util.PasswordHashing;
import by.jonline.module_6.home_library.service.util.UserValidator;

public class UserServiceImpl implements UserService {

	private final DAOProvider provider = DAOProvider.getInstance();
	private final UserDAO userDAO = provider.getUserDAO();

	@Override
	public Role singIn(String login, String password) throws ServiceException {
		if (!UserValidator.isCredentialValid(login, password)) {
			throw new ServiceException("Login and password are incorrect.");
		}

		User user = null;

		try {
			user = userDAO.singIn(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (user != null) {
			String[] hashedPassword;
			hashedPassword = user.getPassword().split("\\.");

			if (PasswordHashing.verifyPassword(password, hashedPassword[0], hashedPassword[1])) {
				return user.getRole();
			}
		}
		return null;
	}

	@Override
	public boolean registration(User user) throws ServiceException {
		if (!UserValidator.isCredentialValid(user)) {
			throw new ServiceException("User information is incorrect.");
		}

		boolean result;

		String salt;
		String hashedPassword;

		salt = PasswordHashing.generateSalt();
		hashedPassword = PasswordHashing.hashPassword(user.getPassword(), salt);

		user.setPassword(hashedPassword + "." + salt);
		try {
			result = userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean suggestBook(Book book) throws ServiceException {
		if (!BookValidator.isCredentialValid(book)) {
			throw new ServiceException("Book information is incorrect.");
		}

		List<User> users;
		try {
			users = userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		List<String> adminEmail = new ArrayList<>();
		for (User user : users) {
			if (user.getRole() == Role.ADMIN) {
				adminEmail.add(user.getEmail());
			}
		}

		String[] recipients = adminEmail.toArray(new String[0]);
		String subject = "Есть предложение добавить новую книгу.";
		String text = String.format("Название: %s%nАвтор: %s%nГод издания: %d%nКоличество страниц: %d%n",
				book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getCountOfPages());

		try {
			EmailSender.sendEmail(subject, text, recipients);
		} catch (MessagingException e) {
			throw new ServiceException(e);
		}
		return true;
	}

	@Override
	public boolean sentNewBookNotification(Book book) throws ServiceException {
		List<User> users;
		try {
			users = userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		String[] recipients;
		recipients = users.stream().filter(user -> user.getRole() == Role.READER).map(User::getEmail)
				.toArray(String[]::new);
		String subject = "Появилась новая книга.";
		String text = String.format("Название: %s%nАвтор: %s%nГод издания: %d%nКоличество страниц: %d%n",
				book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getCountOfPages());

		try {
			EmailSender.sendEmail(subject, text, recipients);
		} catch (MessagingException e) {
			throw new ServiceException(e);
		}
		return true;
	}
}