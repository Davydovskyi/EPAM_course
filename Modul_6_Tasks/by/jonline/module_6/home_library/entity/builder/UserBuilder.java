package by.jonline.module_6.home_library.entity.builder;

import by.jonline.module_6.home_library.entity.Role;
import by.jonline.module_6.home_library.entity.User;

public class UserBuilder {

	private User user;

	public UserBuilder() {
		user = new User();
	}

	public UserBuilder withId(long id) {
		user.setId(id);
		return this;
	}

	public UserBuilder withName(String name) {
		user.setName(name);
		return this;
	}

	public UserBuilder withSurname(String surname) {
		user.setSurname(surname);
		return this;
	}

	public UserBuilder withLogin(String login) {
		user.setLogin(login);
		return this;
	}

	public UserBuilder withPassword(String password) {
		user.setPassword(password);
		return this;
	}

	public UserBuilder withEmail(String email) {
		user.setEmail(email);
		return this;
	}

	public UserBuilder withRole(Role role) {
		user.setRole(role);
		return this;
	}

	public User build() {
		return user;
	}
}