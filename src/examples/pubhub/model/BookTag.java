package examples.pubhub.model;

import java.time.LocalDate;

public class BookTag {
	
	private String isbn13;			// International Standard Book Number, unique
	private String title;
	private String author;
	private LocalDate publishDate;	// Date of publish to the website	
	private double price;	
	private byte[] content;	
	private String tagName;

	public BookTag(String isbn13, String title, String author, LocalDate publishDate, 
					double price, byte[] content, String tagName) {
		super();
		this.isbn13 = isbn13;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
		this.content = content;
		this.tagName = tagName;
	}

	// Default constructor
	public BookTag() {
		this.isbn13 = null;
		this.title = null;
		this.author = null;
		this.publishDate = LocalDate.now();
		this.content = null;
		this.tagName = null;		
	}
	
	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
