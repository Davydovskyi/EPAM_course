package by.jonline.module_5.task5.controller;

import by.jonline.module_5.task5.bean.Gift;
import by.jonline.module_5.task5.service.ServiceException;

public interface Command {

	Gift execute(String request) throws ServiceException;
}