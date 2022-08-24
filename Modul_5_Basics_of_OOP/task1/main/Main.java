package by.jonline.module_5.task1.main;

import by.jonline.module_5.task1.entity.Directory;
import by.jonline.module_5.task1.entity.File;
import by.jonline.module_5.task1.logic.FileManager;
import by.jonline.module_5.task1.view.TextView;

/**
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить,
 * удалить.
 */

public class Main {

	public static void main(String[] args) {

		String fileName = "New File(2)";

		TextView view = new TextView();
		FileManager manager = new FileManager();

		Directory mainDirectory = new Directory("Main");
		Directory resource = new Directory("Resource");
		mainDirectory.addDirectory(resource);

		manager.createFile(resource, "New File(1)");
		manager.createFile(mainDirectory, fileName);

		File file1 = manager.getFile(mainDirectory, "New File(2)");
		file1.addContent("asdfj");
		manager.renameFile(mainDirectory, fileName, "File");

		view.viewContent(file1);

	}
}