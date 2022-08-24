package by.jonline.module_5.task4.controller.impl;

import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.controller.Command;
import by.jonline.module_5.task4.service.ServiceException;
import by.jonline.module_5.task4.service.ServiceProvider;
import by.jonline.module_5.task4.service.TreasureService;

public class GetTreasureCommand implements Command {

	@Override
	public List<Treasure> excute(List<Treasure> treasures, String request) throws ServiceException {
		TreasureService service = ServiceProvider.getInstance().getService();

		String[] params;
		params = request.split("\\s+");

		service.getTreasures(treasures, Boolean.parseBoolean(params[1].split("=")[1]), Integer.parseInt(params[2].split("=")[1]));

		return treasures;
	}
}