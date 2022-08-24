package by.jonline.module_5.task1.entity;

public class TextFile extends File {

	private static final long serialVersionUID = 4641000932829974265L;

	private StringBuilder content = new StringBuilder();

	public TextFile() {
	}

	public TextFile(String name) {
		super(name);
	}

	public void setContent(StringBuilder content) {
		if (content != null) {
			this.content = content;
		}
	}

	@Override
	public StringBuilder getContent() {
		return content;
	}

	@Override
	public <T> boolean addContent(T t) {
		if (t != null && t.getClass() == String.class) {
			content.append(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContent() {
		if (content.length() == 0) {
			return false;
		}
		content.setLength(0);
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj) || getClass() != obj.getClass())
			return false;

		TextFile other = (TextFile) obj;

		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.toString().contentEquals(other.content))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [name=").append(getName()).append(", content=")
				.append(content.toString()).append("]");
		return builder.toString();
	}
}