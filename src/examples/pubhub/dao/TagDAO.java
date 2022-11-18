package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Tag;

/**
 * Interface for our Data Access Object to handle database queries related to Tags.
 */
public interface TagDAO {

	public List<Tag> getAllTags();
	public List<Tag> getTagsByISBN(String isbn);
	public List<Tag> getTagsByISBNTagName(String isbn, String tagName);	
	public List<Tag> getTagsByTagName(String tagName);	
	public List<Tag> getTagByISBNTagNameList(String isbn, String tagName);		
	public Tag getTagByISBNTagName(String isbn, String tagName);	
	
	public boolean addTag(Tag tag);
	public boolean updateTag(Tag tag, String tagName);
	public boolean deleteTagByISBN(String isbn);
	public boolean deleteTagByISBNTagNameList(String isbn, String tagName);		
	public boolean deleteTagByISBNTagName(String isbn, String tagName);	
}