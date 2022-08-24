package by.jonline.module_5.task4.service;

import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;

public interface TreasureService {

	public List<Treasure> getTreasures(List<Treasure> treasures, boolean isFull, int count) throws ServiceException;

	public List<Treasure> getMostExpensiveTreasure(List<Treasure> treasures) throws ServiceException;

	public List<Treasure> getTreasuresForAmount(List<Treasure> treasures, int amount) throws ServiceException;
}