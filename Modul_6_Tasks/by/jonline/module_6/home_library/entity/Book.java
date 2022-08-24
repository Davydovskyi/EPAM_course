package by.jonline.module_6.home_library.entity;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {

	private static final long serialVersionUID = -1322740113322771602L;

	private long id = 1;
	private String title = "Unknown title";
	private String author = "Unknown author";
	private int publicationYear = 2022;
	private BookType bookType = BookType.PAPER_BOOK;
	private int countOfPages = 0;

	public Book() {
	}

	public Book(long id, String title, String author, int publicationYear, BookType bookType, int countOfPages) {
		if (id > 0) {
			this.id = id;
		}
		if (title != null && !title.trim().isEmpty()) {
			this.title = title;
		}
		if (author != null && !author.trim().isEmpty()) {
			this.author = author;
		}
		if (publicationYear > 0) {
			this.publicationYear = publicationYear;
		}
		if (bookType != null) {
			this.bookType = bookType;
		}
		if (countOfPages > 0) {
			this.countOfPages = countOfPages;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && !title.trim().isEmpty()) {
			this.title = title;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author != null && !author.trim().isEmpty()) {
			this.author = author;
		}
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		if (publicationYear > 0) {
			this.publicationYear = publicationYear;
		}
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		if (bookType != null) {
			this.bookType = bookType;
		}
	}

	public int getCountOfPages() {
		return countOfPages;
	}

	public void setCountOfPages(int countOfPages) {
		if (countOfPages > 0) {
			this.countOfPages = countOfPages;
		}
	}

	@Override
	public int compareTo(Book o) {
		return Long.compare(id, o.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookType == null) ? 0 : bookType.hashCode());
		result = prime * result + countOfPages;
		result = prime * result + publicationYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookType != other.bookType)
			return false;
		if (countOfPages != other.countOfPages)
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", title=").append(title)
				.append(", author=").append(author).append(", publicationYear=").append(publicationYear)
				.append(", bookType=").append(bookType).append(", countOfPages=").append(countOfPages).append("]");
		return builder.toString();
	}
}