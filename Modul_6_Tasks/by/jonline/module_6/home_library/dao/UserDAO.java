package by.jonline.module_6.home_library.dao;

import java.util.List;

import by.jonline.module_6.home_library.entity.User;

public interface UserDAO {

	User singIn(String login) throws DAOException;

	boolean registration(User user) throws DAOException;
	
	List<User> getAllUsers() throws DAOException;
}