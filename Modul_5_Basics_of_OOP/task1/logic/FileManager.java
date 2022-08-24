package by.jonline.module_5.task1.logic;

import java.util.Set;

import by.jonline.module_5.task1.entity.Directory;
import by.jonline.module_5.task1.entity.File;
import by.jonline.module_5.task1.entity.TextFile;

public class FileManager {

	public boolean createFile(Directory directory, String name) {
		if (directory != null && isValidName(name) && !isFileNameExist(directory, name)) {
			directory.addFile(new TextFile(name));
			return true;
		}
		return false;
	}

	public boolean renameFile(Directory directory, String oldName, String newName) {
		File file;
		file = getFile(directory, oldName);
		if (file != null && isValidName(newName) && !isFileNameExist(directory, newName)) {
			file.setName(newName);
			return true;
		}
		return false;
	}

	public boolean deleteFile(Directory directory, String name) {
		if (directory == null) {
			return false;
		}

		File file;
		file = getFile(directory, name);
		return directory.getFiles().remove(file);
	}

	public File getFile(Directory directory, String name) {
		if (directory == null) {
			return null;
		}
		return getFile(directory.getFiles(), name);
	}

	public Directory getDirectory(Directory directory, String name) {
		if (isValidName(name)) {
			for (Directory dir : directory.getDirectories()) {
				if (dir.getName().equalsIgnoreCase(name)) {
					return dir;
				}
			}
		}
		return null;
	}

	private File getFile(Set<File> files, String name) {
		for (File file : files) {
			if (file.getName().equalsIgnoreCase(name)) {
				return file;
			}
		}
		return null;
	}

	private boolean isFileNameExist(Directory directory, String name) {
		if (directory == null) {
			return false;
		}
		return getFile(directory.getFiles(), name) != null;
	}

	private boolean isValidName(String name) {
		return name != null && !name.trim().isEmpty();
	}
}