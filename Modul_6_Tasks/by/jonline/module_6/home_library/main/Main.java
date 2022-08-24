package by.jonline.module_6.home_library.main;

import by.jonline.module_6.home_library.controller.Controller;
import by.jonline.module_6.home_library.controller.impl.ControllerImpl;

/**
 * Cоздать консольное приложение “Учет книг в домашней библиотеке”.
 * 
 * Общие требования к заданию: 
 * • Система учитывает книги как в электронном, так и в бумажном варианте. 
 * • Существующие роли: пользователь, администратор. 
 * • Пользователь может просматривать книги в каталоге книг, осуществлять поиск
 * книг в каталоге. 
 * • Администратор может модифицировать каталог. 
 * • *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail
 * всем пользователям. 
 * • **При просмотре каталога желательно реализовать постраничный просмотр. 
 * • ***Пользователь может предложить добавить книгу в
 * библиотеку, переслав её администратору на e-mail. 
 * • Каталог книг хранится в текстовом файле. 
 * • Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде.
 */

public class Main {

	public static void main(String[] args) {
		Controller controller = new ControllerImpl();

		String request = "FIND_BOOK' 'name=by_title' 'value=сол' 'name=BY_AUTHOR' 'value=не' 'name=BY_BOOK_TYPE' 'value=e_book";
		String result;

		result = controller.doAction(request);
		System.out.println(result);
	}
}