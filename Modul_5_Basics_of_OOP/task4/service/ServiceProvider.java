package by.jonline.module_5.task4.service;

import by.jonline.module_5.task4.service.impl.TreasureServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private TreasureService service = new TreasureServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public TreasureService getService() {
		return service;
	}
}