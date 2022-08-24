package by.jonline.module_3.regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее
 * выполнять с текстом три различных операции: отсортировать абзацы по
 * количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений
 * заданного символа, а в случае равенства – по алфавиту.
 */

public class Task1 {

	public static void main(String[] args) {

		String text = "I was born an idiot - but I'm cleverer than people think. I can think things OK, but when I have to say them or write them down, sometimes they come out all wrong."
				+ " When I was born, my Mom named me Forrest. My daddy died just after I was born."
				+ " He worked on the ships. One day a big box of bananas fell down on my daddy and killed him.\r\n"
				+ "I don't like bananas much. Only banana cake. I like that all right.\r\n"
				+ "At first when I was growing up, I played with everybody. But then some boys hit me, and my Mom didn't want me to play with them again."
				+ " I tried to play with girls, but they all ran away from me.\r\n"
				+ "I went to an ordinary school for a year. Then the children started laughing and running away from me."
				+ " But one girl, Jenny Curran, didn't run away, and sometimes she walked home with me. She was nice.\r\n"
				+ "Then they put me into another kind of school, and there were some strange boys there."
				+ " Some couldn't eat or go to the toilet without help. I stayed in that school for five or six years."
				+ " But when I was thirteen, I grew six inches in six months! And by the time I was sixteen, I was bigger and heavier than all the other boys in the school.";

		String message = "Выберите действие:\n1. Отсортировать абзацы по количеству предложений."
				+ "\n2. В каждом предложении отсортировать слова по длине."
				+ "\n3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту."
				+ "\n0. Выйти.";

		userChoice(text, message);
	}

	public static void userChoice(String text, String message) {

		String choice;
		choice = enterFromConsole(message, "\\d");

		String[] result = new String[0];

		switch (Integer.parseInt(choice)) {
		case 1:
			result = sortParagraphsByCountOfSentences(text);
			break;
		case 2:
			result = sortWordsInSentence(text);
			break;
		case 3:
			String ch;
			ch = enterFromConsole("Введите символ.", ".");
			result = sortLexemesInSentence(text, ch);
			break;
		case 0:
			break;
		default:
			userChoice(text, "Неверный выбор. Выберите действие ещё раз.");
		}

		for (String string : result) {
			System.out.println(string);
		}
	}

	public static String[] splitIntoParagraphs(String text) {

		if (text == null) {
			return new String[0];
		}

		return text.trim().split("[\\r\\n]+");
	}

	public static String[] splitIntoSentences(String text) {// плохо работает, если будут сокращения: "etc.", "А.А.
															// Майкл". Или другие конструкции в зависимости от языка.
		if (text == null) {
			return new String[0];
		}

		return text.trim().split("[.!?]+");
	}

	public static String[] splitIntoWords(String text) {

		if (text == null) {
			return new String[0];
		}

		String tempText = text.trim().replaceAll("[\\p{Punct}\\d]", "");

		return tempText.split("\\s+");
	}

	public static String[] splitIntoLexemes(String text) {// лексема - часть текста, ограниченная пробельными символами.

		if (text == null) {
			return new String[0];
		}

		return text.trim().split("\\s+");
	}

	public static int getCountOfConcreteCharacter(String text, String ch) {

		if (text == null) {
			return 0;
		}

		Pattern p = Pattern.compile(ch, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);

		int count = 0;
		while (m.find()) {
			count++;
		}
		return count;
	}

	public static String[] sortLexemesInSentence(String text, String ch) {

		String[] sentences;
		sentences = splitIntoSentences(text);

		StringBuilder builder = new StringBuilder();

		String[] lexems;

		for (int i = 0; i < sentences.length; i++) {

			lexems = splitIntoLexemes(sentences[i]);

			int compare;
			int countOfConcreteChar1;
			int countOfConcreteChar2;

			boolean sorted = false;
			while (!sorted) {
				sorted = true;

				for (int j = 0; j < lexems.length - 1; j++) {
					countOfConcreteChar1 = getCountOfConcreteCharacter(lexems[j], ch);
					countOfConcreteChar2 = getCountOfConcreteCharacter(lexems[j + 1], ch);

					compare = lexems[j].compareToIgnoreCase(lexems[j + 1]);

					if (countOfConcreteChar1 < countOfConcreteChar2
							|| countOfConcreteChar1 == countOfConcreteChar2 && compare > 0) {
						sorted = false;
						swap(lexems, j, j + 1);
					}
				}
			}

			for (String lexem : lexems) {
				builder.append(lexem).append(" ");
			}

			sentences[i] = builder.toString();
			builder.setLength(0);
		}
		return sentences;
	}

	public static String[] sortWordsInSentence(String text) {

		String[] sentences;
		sentences = splitIntoSentences(text);

		StringBuilder builder = new StringBuilder();

		String[] words;
		for (int k = 0; k < sentences.length; k++) {

			words = splitIntoWords(sentences[k]);

			int d = words.length / 2;
			while (d > 0) {
				for (int i = 0; i < words.length - d; i++) {
					int j = i;
					while (j >= 0 && words[j].length() > words[j + d].length()) {
						swap(words, j, j + d);
						j = j - d;
					}
				}
				d = d / 2;
			}

			for (String word : words) {
				builder.append(word).append(" ");
			}

			sentences[k] = builder.toString();
			builder.setLength(0);
		}
		return sentences;
	}

	public static String[] sortParagraphsByCountOfSentences(String text) {

		String[] paragraphs;
		paragraphs = splitIntoParagraphs(text);

		int d = paragraphs.length / 2;
		while (d > 0) {
			for (int i = 0; i < paragraphs.length - d; i++) {
				int j = i;
				while (j >= 0
						&& splitIntoSentences(paragraphs[j]).length > splitIntoSentences(paragraphs[j + d]).length) {
					swap(paragraphs, j, j + d);
					j = j - d;
				}
			}
			d = d / 2;
		}
		return paragraphs;
	}

	private static void swap(String[] array, int id1, int id2) {
		String temp = array[id1];
		array[id1] = array[id2];
		array[id2] = temp;
	}

	public static String enterFromConsole(String message, String pattern) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(message);

		while (!scanner.hasNext(pattern)) {
			scanner.next();
		}
		return scanner.next(pattern);
	}
}