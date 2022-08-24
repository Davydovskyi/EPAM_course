package by.jonline.module_4.aggregation_and_composition.task1.view;

import by.jonline.module_4.aggregation_and_composition.task1.entity.Sentence;
import by.jonline.module_4.aggregation_and_composition.task1.entity.Text;
import by.jonline.module_4.aggregation_and_composition.task1.entity.Word;

public class TextView {

	public void printTitle(Text text) {
		StringBuilder builder = new StringBuilder();
		for (Word word : text.getTitle().getWords()) {
			builder.append(word.getValue().trim()).append(" ");
		}
		builder.setCharAt(builder.length() - 1, '.');
		System.out.println(builder.toString());
	}

	public void printText(Text text) {

		StringBuilder builder = new StringBuilder();

		for (Sentence sentence : text.getSentences()) {
			for (Word word : sentence.getWords()) {
				builder.append(word.getValue().trim()).append(" ");
			}
			builder.setCharAt(builder.length() - 1, '.');
			builder.append(" ");
			System.out.print(builder.toString());
			builder.setLength(0);
		}
	}
}