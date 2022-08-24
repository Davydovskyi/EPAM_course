package by.jonline.module_5.task4.controller;

import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.service.ServiceException;

public interface Command {

	public List<Treasure> excute(List<Treasure> treasures, String request) throws ServiceException;
}