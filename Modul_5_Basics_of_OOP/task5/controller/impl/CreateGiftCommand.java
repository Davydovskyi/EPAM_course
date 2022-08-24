package by.jonline.module_5.task5.controller.impl;

import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.controller.Command;
import by.jonline.module_5.task5.service.GiftService;
import by.jonline.module_5.task5.service.ServiceException;
import by.jonline.module_5.task5.service.ServiceProvider;

public class CreateGiftCommand implements Command {

	private ServiceProvider provider = ServiceProvider.getInstance();
	private GiftService service = provider.getService();

	@Override
	public Gift execute(String request) throws ServiceException {

		String[] tempParams;
		tempParams = request.split(" ");

		String[] params;
		params = new String[tempParams.length - 1];
		System.arraycopy(tempParams, 1, params, 0, tempParams.length - 1);

		return service.createGift(params);
	}
}