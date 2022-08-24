package by.jonline.module_4.aggregation_and_composition.task1.main;

import by.jonline.module_4.aggregation_and_composition.task1.entity.Sentence;
import by.jonline.module_4.aggregation_and_composition.task1.entity.Text;
import by.jonline.module_4.aggregation_and_composition.task1.entity.Word;
import by.jonline.module_4.aggregation_and_composition.task1.view.TextView;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы:
 * дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Main {

	public static void main(String[] args) {

		Text text = new Text();
		TextView textView = new TextView();

		Word title1 = new Word("Про");
		Word titile2 = new Word("уборку");

		Sentence title = new Sentence();
		title.addWord(title1);
		title.addWord(titile2);

		text.setTitle(title);
		textView.printTitle(text);

		Word mom = new Word("Мама");
		Word wash = new Word("Мыла");
		Word frame = new Word("Раму");

		Sentence momFirst = new Sentence();
		momFirst.addWord(mom);
		momFirst.addWord(wash);
		momFirst.addWord(frame);

		Sentence washFirst = new Sentence();
		washFirst.addWord(wash);
		washFirst.addWord(frame);
		washFirst.addWord(mom);

		text.addSentence(momFirst);
		text.addSentence(washFirst);

		textView.printText(text);
	}
}