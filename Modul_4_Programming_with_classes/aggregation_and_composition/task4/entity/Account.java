package by.jonline.module_4.aggregation_and_composition.task4.entity;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -6195962248815128830L;

	private static long commonNumber = 1000000000;
	private long number;
	private boolean accountStatusOpen = true;
	private long accountBalance;

	public Account() {
		this(0);
	}

	public Account(long accountBalance) {
		this.accountBalance = accountBalance;
		this.number = commonNumber++;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		if (number > 0) {
			this.number = number;
		}
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		if (isAccountStatusOpen()) {
			this.accountBalance = accountBalance;
		}
	}

	public boolean isAccountStatusOpen() {
		return accountStatusOpen;
	}

	public void setAccountStatusOpen(boolean accountStatusOpen) {
		this.accountStatusOpen = accountStatusOpen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountBalance ^ (accountBalance >>> 32));
		result = prime * result + (accountStatusOpen ? 1231 : 1237);
		result = prime * result + (int) (number ^ (number >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Account other = (Account) obj;

		if (accountBalance != other.accountBalance)
			return false;
		if (accountStatusOpen != other.accountStatusOpen)
			return false;
		return number == other.number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [number=").append(number).append(", accountStatusOpen=")
				.append(accountStatusOpen).append(", accountBalance=").append(accountBalance).append("]");
		return builder.toString();
	}
}