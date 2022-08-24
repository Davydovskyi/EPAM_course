package by.jonline.module_5.task4.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.dao.DAOException;
import by.jonline.module_5.task4.dao.DAOProvider;
import by.jonline.module_5.task4.service.ServiceException;
import by.jonline.module_5.task4.service.TreasureService;

public class TreasureServiceImpl implements TreasureService {

	private final DAOProvider provider = DAOProvider.getInstance();

	@Override
	public List<Treasure> getTreasures(List<Treasure> treasures, boolean isFull, int count) throws ServiceException {
		try {
			provider.getTreasureDAO().loadTreasure(treasures, isFull, count);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return treasures;
	}

	@Override
	public List<Treasure> getMostExpensiveTreasure(List<Treasure> treasures) throws ServiceException {
		List<Treasure> result = new ArrayList<>();
		if (treasures == null || treasures.isEmpty()) {
			return result;
		}

		List<Treasure> sortedList = new ArrayList<>();
		sortedList.addAll(treasures);

		Collections.sort(sortedList);
		Treasure maxValueTreasure = sortedList.get(sortedList.size() - 1);

		for (int i = sortedList.size() - 1; i >= 0; i--) {
			if (maxValueTreasure.getValue() == sortedList.get(i).getValue()) {
				result.add(sortedList.get(i));
			} else {
				return result;
			}
		}
		return result;
	}

	@Override
	public List<Treasure> getTreasuresForAmount(List<Treasure> treasures, int amount) throws ServiceException {
		List<Treasure> result = new ArrayList<>();

		if (treasures == null || treasures.isEmpty() || amount < 1) {
			return result;
		}

		List<Treasure> list = new ArrayList<>();
		list.addAll(treasures);
		Collections.shuffle(list);

		for (Treasure treasure : list) {
			if (treasure.getValue() <= amount) {
				result.add(treasure);
				amount -= treasure.getValue();

				if (amount == 0) {
					return result;
				}
			}
		}
		return result;
	}
}