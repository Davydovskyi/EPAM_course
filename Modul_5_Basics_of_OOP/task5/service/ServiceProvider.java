package by.jonline.module_5.task5.service;

import by.jonline.module_5.task5.service.impl.GiftServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private GiftService service = new GiftServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public GiftService getService() {
		return service;
	}
}