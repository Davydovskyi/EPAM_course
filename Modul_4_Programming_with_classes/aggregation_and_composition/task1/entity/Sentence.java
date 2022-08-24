package by.jonline.module_4.aggregation_and_composition.task1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Serializable {

	private static final long serialVersionUID = -4014007346482339087L;

	private List<Word> words = new ArrayList<>();

	public Sentence() {
	}

	public Sentence(List<Word> words) {
		if (words != null) {
			this.words = words;
		}
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		if (words != null) {
			this.words = words;
		}
	}

	public void addWord(Word word) {
		if (word != null) {
			words.add(word);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Sentence other = (Sentence) obj;

		return Objects.equals(words, other.words);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [words=").append(words).append("]");
		return builder.toString();
	}
}