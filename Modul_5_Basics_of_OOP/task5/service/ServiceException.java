package by.jonline.module_5.task5.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -4719745256557753588L;

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