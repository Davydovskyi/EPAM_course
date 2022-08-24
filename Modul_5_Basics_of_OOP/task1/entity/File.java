package by.jonline.module_5.task1.entity;

import java.io.Serializable;

public abstract class File implements Serializable, Comparable<File> {

	private static final long serialVersionUID = 6740911378074763721L;

	private String name = "New File";

	public File() {
	}

	public File(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
	}

	@Override
	public int compareTo(File o) {
		return name.compareToIgnoreCase(o.name);
	}

	public abstract Object getContent();

	public abstract <T> boolean addContent(T t);

	public abstract boolean deleteContent();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		File other = (File) obj;

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
		builder.append(getClass().getSimpleName()).append(" [name=").append(name).append("]");
		return builder.toString();
	}
}