package by.jonline.module_5.task4.dao;

import by.jonline.module_5.task4.dao.impl.FileTreasureDAO;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private TreasureDAO treasureDAO = new FileTreasureDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public TreasureDAO getTreasureDAO() {
		return treasureDAO;
	}
}