package by.jonline.module_6.home_library.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -2861348308113055845L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}