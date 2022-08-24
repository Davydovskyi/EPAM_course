package by.jonline.module_5.task4.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3855336952325673029L;

	public ServiceException() {
	}

	public ServiceException(String message, Throwable exception) {
		super(message, exception);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable exception) {
		super(exception);
	}
}