package by.jonline.module_6.home_library.service.util;

import by.jonline.module_6.home_library.entity.User;

public class UserValidator {

	private static final String NAME_AND_SURNAME = "([A-Za-z]{1,20})|([А-Яа-я]{1,20})";
	private static final String LOGIN = "\\w{5,15}";
	private static final String PASSWORD = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
	private static final String EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

	private UserValidator() {

	}

	public static boolean isCredentialValid(String login, String password) {
		return login.matches(LOGIN) && password.matches(PASSWORD);
	}

	public static boolean isCredentialValid(User user) {
		if (user.getName() == null || !user.getName().matches(NAME_AND_SURNAME) || user.getSurname() == null
				|| !user.getSurname().matches(NAME_AND_SURNAME)) {
			return false;
		}
		if (user.getLogin() == null || !user.getLogin().matches(LOGIN) || user.getPassword() == null
				|| !user.getPassword().matches(PASSWORD)) {
			return false;
		}
		return user.getEmail() != null && user.getEmail().matches(EMAIL);
	}
}