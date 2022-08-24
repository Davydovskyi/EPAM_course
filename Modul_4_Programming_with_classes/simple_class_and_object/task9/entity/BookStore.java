package by.jonline.module_4.simple_class_and_object.task9.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookStore implements Serializable {

	private static final long serialVersionUID = -6585310095046920368L;

	private List<Book> books;

	public BookStore() {
		books = new ArrayList<>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		if (book != null) {
			books.add(book);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		BookStore other = (BookStore) obj;

		return Objects.equals(books, other.books);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [books=").append(books).append("]");
		return builder.toString();
	}
}