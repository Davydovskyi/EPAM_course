package by.jonline.module_5.task4.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1152202536760421949L;

	public DAOException() {
	}

	public DAOException(String message, Throwable exception) {
		super(message, exception);
	}

	public DAOException(Throwable exception) {
		super(exception);
	}

	public DAOException(String message) {
		super(message);
	}
}