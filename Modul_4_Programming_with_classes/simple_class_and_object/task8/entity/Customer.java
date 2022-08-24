package by.jonline.module_4.simple_class_and_object.task8.entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

	private static final long serialVersionUID = -8876019446538148827L;

	private static int totalID = 1;
	private int id;
	private String firstName;
	private String lastName;
	private String patronymic;
	private String address;
	private long creditCardNumber;
	private long accountNumber;

	public Customer() {
		this("", "", "", "", 0, 0);
		this.id = 0;
	}

	public Customer(String firstName, String lastName, String patronymic, String address, long creditCardNumber,
			long accountNumber) {
		this.id = totalID++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.address = address;

		if (creditCardNumber > 0) {
			this.creditCardNumber = creditCardNumber;
		}

		if (accountNumber > 0) {
			this.accountNumber = accountNumber;
		}
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

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		if (creditCardNumber > 0) {
			this.creditCardNumber = creditCardNumber;
		}
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		if (accountNumber > 0) {
			this.accountNumber = accountNumber;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (creditCardNumber ^ (creditCardNumber >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Customer other = (Customer) obj;

		if (accountNumber != other.accountNumber)
			return false;
		if (!Objects.equals(address, other.address)) {
			return false;
		}
		if (creditCardNumber != other.creditCardNumber)
			return false;
		if (!Objects.equals(firstName, other.firstName)) {
			return false;
		}
		if (id != other.id)
			return false;
		if (!Objects.equals(lastName, other.lastName)) {
			return false;
		}
		return Objects.equals(patronymic, other.patronymic);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", patronymic=").append(patronymic).append(", address=")
				.append(address).append(", creditCardNumber=").append(creditCardNumber).append(", accountNumber=")
				.append(accountNumber).append("]");
		return builder.toString();
	}
}