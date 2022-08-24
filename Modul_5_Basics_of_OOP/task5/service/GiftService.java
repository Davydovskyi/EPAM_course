package by.jonline.module_5.task5.service;

import by.jonline.module_5.task5.bean.Gift;

public interface GiftService {

	int calculatePrice(Gift gift) throws ServiceException;
	Gift createGift(String[] params) throws ServiceException;
}