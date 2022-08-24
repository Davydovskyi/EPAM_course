package by.jonline.module_6.home_library.service;

import java.util.stream.Stream;

import by.jonline.module_6.home_library.entity.Book;

public enum SearchParameter {

	BY_ID, BY_PUBLICATION_YEAR {
		@Override
		public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
			return booksStream.filter(book -> String.valueOf(book.getPublicationYear()).equals(parameter));
		}
	},
	BY_COUNT_OF_PAGE {
		@Override
		public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
			return booksStream.filter(book -> String.valueOf(book.getCountOfPages()).equals(parameter));
		}
	},
	BY_BOOK_TYPE {
		@Override
		public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
			return booksStream.filter(book -> book.getBookType().toString().equals(parameter.toUpperCase()));
		}
	},
	BY_TITLE {
		@Override
		public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
			return booksStream.filter(book -> book.getTitle().toLowerCase().contains(parameter.toLowerCase()));
		}
	},
	BY_AUTHOR {
		@Override
		public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
			return booksStream.filter(book -> book.getAuthor().toLowerCase().contains(parameter.toLowerCase()));
		}
	};

	public Stream<Book> getFilter(Stream<Book> booksStream, String parameter) {
		return booksStream.filter(book -> String.valueOf(book.getId()).equals(parameter));
	}
}