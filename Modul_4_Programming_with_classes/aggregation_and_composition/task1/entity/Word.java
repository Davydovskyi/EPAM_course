package by.jonline.module_4.aggregation_and_composition.task1.entity;

import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable {

	private static final long serialVersionUID = -2876448066873571696L;

	private String value = "";

	public Word() {
	}

	public Word(String value) {
		if (value != null) {
			this.value = value;
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value != null) {
			this.value = value;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Word other = (Word) obj;

		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [value=").append(value).append("]");
		return builder.toString();
	}
}