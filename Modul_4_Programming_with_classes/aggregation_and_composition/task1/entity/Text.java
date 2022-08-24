package by.jonline.module_4.aggregation_and_composition.task1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Serializable {

	private static final long serialVersionUID = -5026327224379354205L;

	private Sentence title = new Sentence();
	private List<Sentence> sentences = new ArrayList<>();

	public Text() {
	}

	public Text(Sentence title, List<Sentence> sentences) {
		if (title != null) {
			this.title = title;
		}

		if (sentences != null) {
			this.sentences = sentences;
		}
	}

	public Sentence getTitle() {
		return title;
	}

	public void setTitle(Sentence title) {
		if (title != null) {
			this.title = title;
		}
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		if (sentences != null) {
			this.sentences = sentences;
		}
	}

	public void addWord(Word word) {
		if (word == null) {
			return;
		}

		if (!sentences.isEmpty()) {
			sentences.get(sentences.size() - 1).addWord(word);
		} else {
			Sentence sentence = new Sentence();
			sentence.addWord(word);
			sentences.add(sentence);
		}
	}

	public void addSentence(Sentence sentence) {
		if (sentence != null) {
			sentences.add(sentence);
		}
	}

	public void addText(Text text) {
		if (text != null) {
			sentences.addAll(text.getSentences());
		}
	}
}