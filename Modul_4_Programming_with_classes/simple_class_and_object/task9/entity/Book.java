package by.jonline.module_4.simple_class_and_object.task9.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements Serializable {

	private static final long serialVersionUID = -2459272222256862635L;

	private static int totalID = 1;
	private int id;
	private String title;
	private List<String> authors;
	private String publisher;
	private int year;
	private int numberOfPages;
	private double price;
	private String bindingType;

	public Book() {
		this("", new ArrayList<>(), "", 0, 0, 0, "");
		this.id = 0;
	}

	public Book(String title, List<String> authors, String publisher, int year, int numberOfPages, double price,
			String bindingType) {
		this.id = totalID++;
		this.title = title;

		if (authors != null) {
			this.authors = authors;
		} else {
			this.authors = new ArrayList<>();
		}

		this.publisher = publisher;

		if (year > 0) {
			this.year = year;
		}
		if (numberOfPages > 0) {
			this.numberOfPages = numberOfPages;
		}
		if (price > 0) {
			this.price = price;
		}

		this.bindingType = bindingType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		if (authors != null) {
			this.authors = authors;
		}
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		if (numberOfPages > 0) {
			this.numberOfPages = numberOfPages;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bindingType == null) ? 0 : bindingType.hashCode());
		result = prime * result + id;
		result = prime * result + numberOfPages;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Book other = (Book) obj;

		if (id != other.id)
			return false;
		if (year != other.year)
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (!Objects.equals(authors, other.authors)) {
			return false;
		}
		if (!Objects.equals(bindingType, other.bindingType)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (!Objects.equals(publisher, other.publisher)) {
			return false;
		}
		return Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [id=").append(id).append(", title=").append(title)
				.append(", authors=").append(authors.toString()).append(", publisher=").append(publisher)
				.append(", year=").append(year).append(", numberOfPages=").append(numberOfPages).append(", price=")
				.append(price).append(", bindingType=").append(bindingType).append("]");
		return builder.toString();
	}
}