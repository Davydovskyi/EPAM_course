package by.jonline.module_5.task5.controller.impl;

import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.controller.Command;
import by.jonline.module_5.task5.service.ServiceException;

public class NoCommand implements Command{

	@Override
	public Gift execute(String request) throws ServiceException {
		return null;
	}
}