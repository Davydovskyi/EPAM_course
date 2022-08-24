package by.jonline.module_4.aggregation_and_composition.task4.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Serializable {

	private static final long serialVersionUID = 7727210067671583479L;

	private static int commonId = 1;
	private int id;
	private String firstName;
	private String lastName;
	private List<Account> accounts;

	public Client() {
		this("", "");
	}

	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = commonId++;
		this.accounts = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		if (accounts != null) {
			this.accounts = accounts;
		}
	}

	public void addAccount(Account account) {
		if (account != null) {
			accounts.add(account);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Client other = (Client) obj;

		if (!Objects.equals(accounts, other.accounts))
			return false;
		if (!Objects.equals(firstName, other.firstName))
			return false;
		if (!Objects.equals(lastName, other.lastName))
			return false;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", accounts=").append(accounts).append("]");
		return builder.toString();
	}
}