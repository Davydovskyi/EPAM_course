package by.jonline.module_6.home_library.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = -9191314798272268341L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
}