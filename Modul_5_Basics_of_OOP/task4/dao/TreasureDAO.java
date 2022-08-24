package by.jonline.module_5.task4.dao;

import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;

public interface TreasureDAO {

	public List<Treasure> loadTreasure(List<Treasure> treasures, boolean isFull, int count) throws DAOException;
}