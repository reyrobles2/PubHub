package examples.pubhub.model;

import java.time.LocalDate;

public class Tag {

	private String isbn13;			// International Standard Book Number, unique
	private String tagName;
	
	// Constructor used when fields are specified	
	public Tag(String isbn13, String tagName) {
		super();
		this.isbn13 = isbn13;
		this.tagName = tagName;
	}

	// Default constructor
	public Tag() {
		super();
		this.isbn13 = null;
		this.tagName = null;
	}	
	
	public String getIsbn13() {
		return isbn13;
	}


	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	
	
}
