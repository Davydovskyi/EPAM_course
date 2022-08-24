package by.jonline.module_6.home_library.entity;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = 1932208582829493905L;

	private long id = 0;
	private String name = "Unknown name";
	private String surname = "Unknown surname";
	private String login = "Unknown login";
	private String password = "Unknown password";
	private String email = "Unknown email";
	private Role role = Role.READER;

	public User() {
	}

	public User(long id, String name, String surname, String login, String password, String email, Role role) {
		if (id > 0) {
			this.id = id;
		}
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
		if (surname != null && !surname.trim().isEmpty()) {
			this.surname = surname;
		}
		if (login != null && !login.trim().isEmpty()) {
			this.login = login;
		}
		if (password != null && !password.trim().isEmpty()) {
			this.password = password;
		}
		if (email != null && !email.trim().isEmpty()) {
			this.email = email;
		}
		if (role != null) {
			this.role = role;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname != null && !surname.trim().isEmpty()) {
			this.surname = surname;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if (login != null && !login.trim().isEmpty()) {
			this.login = login;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null && !password.trim().isEmpty()) {
			this.password = password;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.trim().isEmpty()) {
			this.email = email;
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		if (role != null) {
			this.role = role;
		}
	}

	@Override
	public int compareTo(User o) {
		return Long.compare(id, o.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", name=").append(name)
				.append(", surname=").append(surname).append(", login=").append(login).append(", password=")
				.append(password).append(", email=").append(email).append(", role=").append(role).append("]");
		return builder.toString();
	}
}