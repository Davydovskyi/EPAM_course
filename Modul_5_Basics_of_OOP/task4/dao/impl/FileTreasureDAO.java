package by.jonline.module_5.task4.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import by.jonline.module_5.task4.bean.Treasure;
import by.jonline.module_5.task4.dao.DAOException;
import by.jonline.module_5.task4.dao.TreasureDAO;

public class FileTreasureDAO implements TreasureDAO {

	private static final String FILE_NAME = "src/by/jonline/module_5/task4/source/treasure.txt";
	private static final String SYSTEM_RATH;

	static {
		SYSTEM_RATH = System.getProperty("user.dir");
	}

	@Override
	public List<Treasure> loadTreasure(List<Treasure> treasures, boolean isFull, int cout) throws DAOException {

		int counter = 0;

		String path;
		path = FILE_NAME.replace("/", File.separator);

		File file = new File(SYSTEM_RATH + File.separator + path);

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line;
			String[] params;
			while ((line = reader.readLine()) != null && (isFull || counter < cout)) {
				params = line.split("\\s+");
				treasures.add(new Treasure(params[0], Integer.parseInt(params[1])));
				counter++;
			}
		} catch (FileNotFoundException e) {
			throw new DAOException("File not Found", e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return treasures;
	}
}