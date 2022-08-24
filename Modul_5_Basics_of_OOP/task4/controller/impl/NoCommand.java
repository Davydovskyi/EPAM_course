package by.jonline.module_5.task4.controller.impl;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.controller.Command;
import by.jonline.module_5.task4.service.ServiceException;

public class NoCommand implements Command {

	@Override
	public List<Treasure> excute(List<Treasure> treasures, String request) throws ServiceException {
		return new ArrayList<>();
	}
}