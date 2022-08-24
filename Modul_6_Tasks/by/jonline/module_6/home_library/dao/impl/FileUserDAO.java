package by.jonline.module_6.home_library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.jonline.module_6.home_library.dao.DAOException;
import by.jonline.module_6.home_library.dao.UserDAO;
import by.jonline.module_6.home_library.entity.Role;
import by.jonline.module_6.home_library.entity.User;
import by.jonline.module_6.home_library.entity.builder.UserBuilder;

public class FileUserDAO implements UserDAO {

	private static final String USERS_SOURCE = "src/sources/users.txt";
	private static final String PARAM_DELIMETER = "' '";
	private static final String DELIMETER = "' '";

	@Override
	public User singIn(String login) throws DAOException {
		List<User> users;
		users = getAllUsers();

		for (User user : users) {
			if (user.getLogin().equalsIgnoreCase(login)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean registration(User user) throws DAOException {
		List<User> users;
		users = getAllUsers();

		for (User u : users) {
			if (u.getLogin().equalsIgnoreCase(user.getLogin()) || u.getEmail().equalsIgnoreCase(user.getEmail())) {
				return false;
			}
		}

		long lastId = users.size();
		user.setId(++lastId);

		StringBuilder builder = new StringBuilder();
		builder.append(user.getId()).append(DELIMETER).append(user.getName()).append(DELIMETER)
				.append(user.getSurname()).append(DELIMETER).append(user.getLogin()).append(DELIMETER)
				.append(user.getPassword()).append(DELIMETER).append(user.getEmail()).append(DELIMETER)
				.append(user.getRole());

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_SOURCE, true))) {
			writer.write(builder.toString());
			writer.newLine();
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return true;
	}

	@Override
	public List<User> getAllUsers() throws DAOException {
		List<User> users = new ArrayList<>();

		String line = null;
		String[] params = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(USERS_SOURCE))) {
			while ((line = reader.readLine()) != null) {
				params = line.split(PARAM_DELIMETER);
				User user = new UserBuilder().withId(Integer.parseInt(params[0])).withName(params[1])
						.withSurname(params[2]).withLogin(params[3]).withPassword(params[4]).withEmail(params[5])
						.withRole(Role.valueOf(params[6])).build();
				users.add(user);
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return users;
	}
}