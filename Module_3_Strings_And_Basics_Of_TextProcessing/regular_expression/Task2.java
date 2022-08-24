package by.jonline.module_3.regular_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка, содержащая следующий текст (xml документ): 
 * <notes>
 *    <note id = "1">
 *       <to>Вася</to>
 *       <from>Света</from>
 *       <heading>Напоминание</heading>
 *       <body>Позвони мне завтра!</body>
 *    </note>
 *    <note id = "2">
 *        <to>Петя</to>
 *        <from>Маша</from>
 *        <heading>Важное напоминание</heading>
 *        <body/>
 *    </note>
 * </notes>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое 
 * узлов xml-документа и его тип (открывающий тег, закрывающий тег, 
 * содержимое тега, тег без тела).Пользоваться готовыми парсерами XML 
 * для решения данной задачи нельзя.
 */

public class Task2 {

	public static void main(String[] args) {

		String text = "<notes>\r\n" + " <note id = \"1\">\r\n" + " <to>Вася</to>\r\n" + " <from>Света</from>\r\n"
				+ " <heading>Напоминание</heading>\r\n" + " <body>Позвони мне завтра!</body>\r\n" + " </note>\r\n"
				+ " <note id = \"2\">\r\n" + " <to>Петя</to>\r\n" + " <from>Маша</from>\r\n"
				+ " <heading>Важное напоминание</heading>\r\n" + " <body/>\r\n" + " </note>\r\n" + "</notes>";

		xmlAnalyser(text);
	}

	private static List<String> getNodes(String text) {

		List<String> nodes = new ArrayList<>();

		Pattern p = Pattern.compile("(</?[^>]+>|(?<=>).+(?=<))");
		Matcher m = p.matcher(text);

		while (m.find()) {
			nodes.add(m.group());
		}
		return nodes;
	}

	public static void xmlAnalyser(String text) {

		if (text == null) {
			return;
		}

		List<String> nodes;
		nodes = getNodes(text);

		for (String node : nodes) {

			if (node.endsWith("/>")) {
				System.out.println("Tег без тела: " + node);
			} else if (node.startsWith("</")) {
				System.out.println("Закрывающий тег: " + node);
			} else if (node.startsWith("<")) {
				System.out.println("Открывающий тег: " + node);
			} else {
				System.out.println("Содержимое тега: " + node);
			}
		}
	}
}