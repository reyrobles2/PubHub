package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public interface BookTagDAO {

	public List<BookTag> getAllBookTags();	
	public List<BookTag> getAllBooks();
	public List<BookTag> getBookTagsByTitle(String title);
	public List<BookTag> getBookTagsByAuthor(String author);
	public List<BookTag> getBookTagsLessThanPrice(double price);
	public List<BookTag> getBookTagByISBN(String isbn);
    public List<BookTag> getBookTagByISBNTagName(String isbn, String tagName);	
    public List<BookTag> getBookTagByTagName(String tagName);	  
	
	public String addBookTag(BookTag bookTag, String fileName);
	public String updateBookTag(BookTag bookTag, String fileName, String tagName);
	public String deleteBookTagByISBN(String isbn);	
	public String deleteBookTagByISBNTagName(String isbn, String tagName);		
}
