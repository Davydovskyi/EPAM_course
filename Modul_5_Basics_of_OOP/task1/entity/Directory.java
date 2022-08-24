package by.jonline.module_5.task1.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Directory implements Serializable, Comparable<Directory> {

	private static final long serialVersionUID = -7208056133660292150L;

	private String name = "New Directory";
	private Set<File> files = new TreeSet<>();
	private Set<Directory> directories = new TreeSet<>();

	public Directory() {
	}

	public Directory(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	public Directory(String name, Set<File> files, Set<Directory> directories) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
		if (files != null) {
			this.files = files;
		}
		if (directories != null) {
			this.directories = directories;
		}
	}

	public String getName() {
		return name;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		if (files != null) {
			this.files = files;
		}
	}

	public Set<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(Set<Directory> directories) {
		if (directories != null) {
			this.directories = directories;
		}
	}

	public boolean addFile(File file) {
		if (file != null) {
			return files.add(file);
		}
		return false;
	}

	public boolean addDirectory(Directory directory) {
		if (directory != null) {
			return directories.add(directory);
		}
		return false;
	}

	@Override
	public int compareTo(Directory o) {
		return name.compareToIgnoreCase(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directories == null) ? 0 : directories.hashCode());
		result = prime * result + ((files == null) ? 0 : files.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Directory other = (Directory) obj;

		if (directories == null) {
			if (other.directories != null)
				return false;
		} else if (!directories.equals(other.directories))
			return false;
		if (files == null) {
			if (other.files != null)
				return false;
		} else if (!files.equals(other.files))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append(", files=")
				.append(files.toString()).append(", directories=").append(directories.toString()).append("]");
		return builder.toString();
	}
}