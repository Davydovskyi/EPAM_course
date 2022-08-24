package by.jonline.module_4.simple_class_and_object.task9.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.jonline.module_4.simple_class_and_object.task9.entity.Book;
import by.jonline.module_4.simple_class_and_object.task9.entity.BookStore;
import by.jonline.module_4.simple_class_and_object.task9.logic.BookLogic;
import by.jonline.module_4.simple_class_and_object.task9.view.BookView;

/**
 * Создать класс Book, спецификация которого приведена ниже. Определить
 * конструкторы, set- и get- методы и метод toString(). Создать второй класс,
 * агрегирующий массив типа Book, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль. Book: id,
 * название, автор(ы), издательство, год издания, количество страниц, цена, тип
 * переплета. Найти и вывести: a) список книг заданного автора; b) список книг,
 * выпущенных заданным издательством; c) список книг, выпущенных после заданного
 * года.
 */

public class Main {

	public static void main(String[] args) {

		BookStore bookStore = new BookStore();
		BookLogic bookLogic = new BookLogic();
		BookView bookView = new BookView();

		bookStore.addBook(new Book("Философия JAVA", new ArrayList<>(Arrays.asList("Брюс Эккель")), "Минск", 2015, 1159,
				50, "Мягкий"));
		bookStore.addBook(new Book("JAVA Библиотека профессионала Том 1",
				new ArrayList<>(Arrays.asList("Кей Хорсманн")), "Диалектика", 2019, 864, 53, "Мягкий"));
		bookStore.addBook(new Book("Изучаем JAVA", new ArrayList<>(Arrays.asList("Берт Бейтс", "Кэти Сьерра")), "Питер",
				2021, 850, 60, "Интегральный"));
		bookStore.addBook(new Book("Java 8. Карманный справочник",
				new ArrayList<>(Arrays.asList("Роберт Лигуори", "Патриция Лигуори")), "Вильямс", 2016, 450, 34,
				"Твердый"));
		bookStore.addBook(new Book("Программирование на Java для детей, родителей, бабушек и дедушек",
				new ArrayList<>(Arrays.asList("Яков Файн")), "Москва", 2011, 210, 23, "Твердый"));

		List<Book> booksByAuthor;
		booksByAuthor = bookLogic.getBooksByAuthor(bookStore.getBooks(), "Кэти Сьерра");
		if (booksByAuthor.isEmpty()) {
			bookView.printErrorMessage("Книги данного автора не найдены.");
		} else {
			bookView.printBooks("Книги данного автора:", booksByAuthor);
		}

		List<Book> booksByPublisher;
		booksByPublisher = bookLogic.getBooksByPublisher(bookStore.getBooks(), "Питер");
		if (booksByPublisher.isEmpty()) {
			bookView.printErrorMessage("Книги данного издательства не найдены.");
		} else {
			bookView.printBooks("Книги данного издательства:", booksByPublisher);
		}

		List<Book> booksByYear;
		booksByYear = bookLogic.getBooksByYear(bookStore.getBooks(), 2011);
		if (booksByYear.isEmpty()) {
			bookView.printErrorMessage("Книги не найдены.");
		} else {
			bookView.printBooks("Книги выпущенные после указанного года:", booksByYear);
		}
	}
}