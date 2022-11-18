package examples.pubhub.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.model.BookTag;


public class TestDAO {

// Variable declaration		
	public static String isbn;
	public static String tagName;
	public static String tagName2;

	public static String title;
	public static String author;
	public static LocalDate publishDate;		
	public static double price;		
	public static byte[] content;	
	public static String fileName;
	
// BEGIN OF MAIN 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Test 1 - Read select on Books inner join on Tag table	
//		System.out.println("Select Books inner join Tag Tables");		
//		getAllBookTags();
//		System.out.println();

// Test 2 - Read select on Books left join on Tag table		
//		System.out.println("Select Books left join Tag Tables");			
//		getAllBooks();

// Test 3 - Read select on Books inner join on Tag table by Fields
//		getAllBookTagsByFields(); 	
		
// Test 4 - Reading Books & Tags separately
		// Reading Books - by ISBN and by Fields
//		System.out.println("Books Table Listing");		
//		getAllBooksTable();
//		System.out.println();		
//		getBooksByFields();

		
		// Reading Tags by ISBN
/*
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();	
*/
/*		
		isbn = "1111111111111";
		System.out.println("Tags Table Listing by ISBN = "+isbn);			
		getTagsByISBN(isbn);
		System.out.println();	
		
		isbn = "1111111111112";
		System.out.println("Tags Table Listing by ISBN = "+isbn);				
		getTagsByISBN(isbn);	
		
		// Reading Tags by ISBN and Tag Name
		isbn = "1111111111111";
		tagName = "Barron";
		System.out.println("Tags Table Listing by ISBN & Tag Name = "+isbn + " "+tagName);				
		getTagsByISBNTagName(isbn, tagName);	
*/
/*		
		// Reading Tags by Tag Name
//		tagName = "Barron";
		tagName = "and";
		System.out.println("Tags Table Listing by Tag Name = "+tagName);				
		getTagsByTagName(tagName);			
*/				
		
		
// Test 5 - Adding Books & Tags separately
/*
		// Test adding a new Book only
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();			
*/
//		System.out.println("Adding to Book Table");		
//        isbn = "1111111111115";
//		title = "Effects of COVID-19";
//		author = "CDC";
//		publishDate = LocalDate.now();
//		price = 9.99;  
//		content = null;
		
//        isbn = "1111111111116";
//		title = "Standards of Marketing";
//		author = "John Doe";
//		publishDate = LocalDate.now();
//		price = 25.25;  
//		content = null;

/*	
		isbn = "1111111111124";
		title = "The 7 Core Standards Of Marketing";
		author = "Green On The Inside Administrator";
		publishDate = LocalDate.now();
		price = 0.99;  
//		fileName = "The 7 Core Standards Of Marketing";
		content = null;
*/
/*		
		isbn = "1111111111120";
		title = "Emma";
		author = "Jane Austen";
		publishDate = LocalDate.now();
		price = 35;		
		
		addBook(isbn, title, author, publishDate, price, content);			
		System.out.println();			
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();	
*/		
/*
		// Test adding a new Tag only
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();	
		
//		isbn = "1111111111112";
//		tagName = "Coding";		
		isbn = "1111111111116";
		tagName = "Marketing, Doe";		
		addTag(isbn, tagName);
		System.out.println();	
		
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();
*/

// Test 6 - Adding Books & Tags simultaneously	
/*		
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();
*/
/*		
		isbn = "1111111111117";
		title = "Speak with Confidence";
		author = "Gary Genard";
		publishDate = LocalDate.now();
		price = 49.99;  
		content = null;
		tagName = "public speaking, Genard";
*/
/*	
		isbn = "1111111111118";
		title = "The Count of Monte Cristo";
		author = "Alexandre Dumas";
		publishDate = LocalDate.now();
		price = 5.99;  
		content = null;
		tagName = " Adventure/Romance, Dumas";
*/
/*		
		isbn = "1111111111123";
		title = "The Great Gatsby";
		author = "F. Scott Fitzgerald";
		publishDate = LocalDate.now();
		price = 3.5;
		fileName = "the-great-gatsby.pdf";	
		tagName = "Novel, Fiction, Tragedy";
*/
/*		
		isbn = "1111111111119";
		title = "Anna Karenina";
		author = "Leo Tolstoy";
		publishDate = LocalDate.now();
		price = 15.5;
		fileName = "annakarenina.pdf";	
		tagName = "woman's scandals, passions and ultimate tragedy, Russia";		
*/
/*		
		isbn = "1111111111120";
		title = "Emma";
		author = "Jane Austen";
		publishDate = LocalDate.now();
		price = 25;
		fileName = "Emma.pdf";	
		tagName = "Romance novel";			
		
				
		addBookTag(isbn, title, author, publishDate, price, fileName, tagName);	
//		addBookTagL(isbn, title, author, publishDate, price, fileName, tagName);
		
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();	
*/	
		
// Test 7 - Updating Books & Tags separately
/*		
		// Update Books 				
		isbn = "1111111111118";
		title = "The Count of Monte Cristo";
		author = "Alexandre Dumas";
		publishDate = LocalDate.now();
		price = 12.99;  
		content = null;	
		getBookByISBN(isbn);		
		updateBook(isbn, title, author, publishDate, price);		
		getBookByISBN(isbn);		
*/
/*		
		// Update Book content
//		isbn = "1111111111118";
//		isbn = "1111111111119";
		isbn = "1111111111120";		
		
// default path is C:\Disk28\Personal02\Revature\workpubhub100\PubHub\
//		fileName = "The Count of Monte Cristo.pdf";		// ok
//		fileName = "C:\\Disk28\\Personal03\\Books\\C:\\Disk28\\Personal03\\Books\\Count_of_Monte_Cristo.txt";
//		fileName = "Count of Monte Cristo.txt"; // ok
//		fileName = "\\Files\\Count of Monte Cristo.txt";	
//		fileName = "annakarenina.pdf";
		fileName = "Emma.pdf";	
 
 		
		getBookByISBN(isbn);			
		updateBookContent(isbn, fileName);
		getBookByISBN(isbn);			
*/

/*		
		// Update Tags
		isbn = "1111111111113";
		tagName = "Walt Disney, children";	// new value
		tagName2 = "Disney, children"; 	// old value
		getTagsByISBN(isbn);			
		updateTag(isbn, tagName, tagName2);		
		getTagsByISBN(isbn);	
*/
		
		
// Test 8 - Updating Books & Tags simultaneously
/*		
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();	
*/
/*		
		isbn = "1111111111118";
		title = "The Count of Monte Cristo";
		author = "Alexandre Dumas";
		publishDate = LocalDate.now();
		price = 4.99;  
		content = null;		
		tagName = "Dumas, Monte Cristo, adventure, romance";	// new value
        tagName2 = " Adventure/Romance, Dumas"; // old value - exact value, composite key		
//		tagName2 = "Dumas"; 				// old value	
*/
/*  
 		isbn = "1111111111123";
		title = "The Great Gatsby";
		author = "F. Scott Fitzgerald";
		publishDate = LocalDate.now();
		price = 5.99;
//		content = null;
		fileName = "the-great-gatsby.pdf";	
//		tagName = "Novel, Fiction, Tragedy"; 
		tagName = "Novel, Fiction, Tragedy, Fitzgerald";  
		tagName2 = "Novel, Fiction, Tragedy";
*/
/*
		isbn = "1111111111120";
		title = "Emma";
		author = "Jane Austen";
		publishDate = LocalDate.now();
//		price = 25;
		price = 49.99;
		fileName = "Emma2.pdf";	
		tagName = "Romance novel, Austen";				
		tagName2 = "Romance novel";
		
		updateBookTag(isbn, title, author, publishDate, price, fileName,
					tagName, tagName2);		

		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();			
*/
		
// Test 9 - Deleting Books & Tags separately
/*	
		// Delete Books by ISBN - by cascade - auto delete Tags
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();	
		System.out.println("Tags Table Listing");		
		getAllTags();		
//		isbn = "1111111111118";
//		isbn = "1111111111112";
//		isbn = "1111111111114";
//		isbn = "1111111111115";
//		isbn = "1111111111116";		
		isbn = "1111111111120";			
//		isbn = "1111111111124";	
			
		deleteBookByISBN(isbn);
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();			
		System.out.println("Tags Table Listing");	
		getAllTags();
*/
/*		
		// Delete Tags by ISBN 
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();	
		isbn = "1111111111116";		
		deleteTagByISBN(isbn);
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();		
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();
*/		
/*	
		// Delete Tags by ISBN and Tag Name
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();	
		isbn = "1111111111115";
		tagName = "Covid";
		deleteTagByISBNTagName(isbn, tagName);	
		System.out.println("Tags Table Listing");		
		getAllTags();	
		System.out.println();	
		System.out.println("Books Table Listing");		
		getAllBooksTable();
		System.out.println();		
*/
		
// Test 10 - Deleting Books & Tags simultaneously
/*		
		// Delete by Tags & Books by ISBN 
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();
//		isbn = "1111111111113";
//		isbn = "1111111111112";
//		isbn = "1111111111114";
//		isbn = "1111111111115";
//		isbn = "1111111111116";		
//		isbn = "1111111111117";		
//		isbn = "1111111111118";		
		isbn = "1111111111120";			
//		isbn = "1111111111123";	
//		isbn = "1111111111124";			
		deleteBookTagByISBN(isbn);
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();		
*/		
/*	
		// Delete by Tags & Books by ISBN & Tag Name
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();		
		isbn = "1111111111117";
		tagName = "Genard";
		deleteBookTagByISBNTagName(isbn, tagName);
		System.out.println("Select Books inner join Tag Tables");		
		getAllBookTags();
		System.out.println();			
*/

	}
// END OF MAIN 
	
	public static void getAllBookTags() {
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 		
		List<BookTag> list;		

		list = daoBookTag.getAllBookTags(); 
		for (int i = 0; i < list.size(); i++){ 
			BookTag bt = list.get(i); 
			printBookTag(bt);
		}		
	}	

	public static void getAllBooks() {
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 		
		List<BookTag> list;		

		list = daoBookTag.getAllBooks(); 
		for (int i = 0; i < list.size(); i++){ 
			BookTag bt = list.get(i); 
			printBookTag(bt);
		}		
	}		

	public static void getAllBookTagsByFields() {
		
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 
		List<BookTag> list = new ArrayList<>();		
/*		
		// Search by Title
		title = "Wonderful World of Disney";
		System.out.println("Books & Tags Table Listing by Title = "+title);			
		list = daoBookTag.getBookTagsByTitle(title); 
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();
		
		// Search by Author
		author = "Russell Barron";
		System.out.println("Books & Tags Table Listing by Author = "+author);			
		list = daoBookTag.getBookTagsByAuthor(author); 
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();
		
		// Search by less than Price
		price = 10.00;
		System.out.println("Books & Tags Table Listing by Price < "+price);			
		list = daoBookTag.getBookTagsLessThanPrice(price); 
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();		
		
		// Search by ISBN
		isbn = "1111111111113";
//		isbn = "1111111111120";		
		System.out.println("Books & Tags Table Listing by ISBN = "+isbn);			
		list = daoBookTag.getBookTagByISBN(isbn);
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();		
		
		// Search by ISBN & Tag Name
		isbn = "1111111111113";
//		isbn = "1111111111120";
		tagName = "children"; // in DB is - Walt Disney, children
		System.out.println("Books & Tags Table Listing by ISBN & Tag Name = "+isbn+" "+tagName);			
		list = daoBookTag.getBookTagByISBNTagName(isbn, tagName);
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();			

*/		
		// Search by Tag Name
		tagName = "Adventure"; // this is a like command
		System.out.println("Books & Tags Table Listing by Tag Name = "+tagName);			
		list = daoBookTag.getBookTagByTagName(tagName);
		for (int i = 0; i < list.size(); i++){ 
			BookTag b = list.get(i); 
			printBookTag(b);
		}			
		System.out.println();			
	}
	
	public static void getAllBooksTable() {
		BookDAO daoBook = new BookDAOImpl(); 		
		List<Book> list;		

		list = daoBook.getAllBooks(); 
		for (int i = 0; i < list.size(); i++){ 
			Book bt = list.get(i); 
			printBook(bt);
		}		
	}			

	public static void getBooksByFields() {

		BookDAO daoBook = new BookDAOImpl(); 
		List<Book> list = new ArrayList<>();		
		
		// Search by Title
		title = "Wonderful World of Disney";
		System.out.println("Books Table Listing by Title = "+title);			
		list = daoBook.getBooksByTitle(title); 
		for (int i = 0; i < list.size(); i++){ 
			Book b = list.get(i); 
			printBook(b);
		}			
		System.out.println();
		
		// Search by Author
		author = "Russell Barron";
		System.out.println("Books Table Listing by Author = "+author);			
		list = daoBook.getBooksByAuthor(author); 
		for (int i = 0; i < list.size(); i++){ 
			Book b = list.get(i); 
			printBook(b);
		}			
		System.out.println();
		
		// Search by less than Price
		price = 10.00;
		System.out.println("Books Table Listing by Price < "+price);			
		list = daoBook.getBooksLessThanPrice(price); 
		for (int i = 0; i < list.size(); i++){ 
			Book b = list.get(i); 
			printBook(b);
		}			
		System.out.println();		
		
		// Search by ISBN
		isbn = "1111111111113";
//		isbn = "1111111111120";		
		System.out.println("Books Table Listing by ISBN = "+isbn);			
		Book b = daoBook.getBookByISBN(isbn);
		printBook(b);		 	
		
	}

	public static void getBookByISBN(String isbn) {
		BookDAO daoBook = new BookDAOImpl(); 		
		
		System.out.println("Books Table Listing by ISBN = "+isbn);			
		Book b = daoBook.getBookByISBN(isbn);
		printBook(b);		
	}
	
	public static void getAllTags() {
		TagDAO daoTag = new TagDAOImpl(); 		
		List<Tag> list;		

		list = daoTag.getAllTags(); 
		for (int i = 0; i < list.size(); i++){ 
			Tag t = list.get(i); 
			printTag(t);
		}		
	}
	
	public static void getTagsByISBN(String isbn) {
		TagDAO daoTag = new TagDAOImpl(); 
		List<Tag> list;			
		list = daoTag.getTagsByISBN(isbn); 		
		for (int i = 0; i < list.size(); i++){ 
			Tag t = list.get(i); 
			printTag(t);
		}
		if (list.size() == 0) {
			System.out.println(isbn + " not found in Tags table");
		}
	}

	public static void getTagsByISBNTagName(String isbn, String tagName) {
		TagDAO daoTag = new TagDAOImpl(); 
		List<Tag> list;			
		list = daoTag.getTagsByISBNTagName(isbn, tagName); 		
		for (int i = 0; i < list.size(); i++){ 
			Tag t = list.get(i); 
			printTag(t);
		}
		if (list.size() == 0) {
			System.out.println(isbn + " " + tagName +" not found in Tags table");
		}
	}
	
	public static void getTagsByTagName(String tagName) {
		TagDAO daoTag = new TagDAOImpl(); 
		List<Tag> list;			
		list = daoTag.getTagsByTagName(tagName); 		
		for (int i = 0; i < list.size(); i++){ 
			Tag t = list.get(i); 
			printTag(t);
		}
		if (list.size() == 0) {
			System.out.println(tagName +" not found in Tags table");
		}
	}	
	
	public static void addBook(String isbn, String title,
								String author, LocalDate publishDate,
								double price, byte[] content){										
		
		Book book = new Book();
		BookDAO daoBook = new BookDAOImpl(); 
		boolean bookFg;			
		
		book.setIsbn13(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublishDate(publishDate);
		book.setPrice(price);	
		book.setContent(content);	
		
		bookFg = daoBook.addBook(book);
        if (bookFg) {
        	System.out.println(isbn + " successfully added in Books table");
        }
        else {
        	System.out.println(isbn + " not added in Books table");		   	
        }			
	}	
	
	public static void addTag(String isbn, String tagName) {
		Tag tag = new Tag();
		TagDAO daoTag = new TagDAOImpl(); 
		boolean tagFg;			
		
		tag.setIsbn13(isbn);
		tag.setTagName(tagName);
		tagFg = daoTag.addTag(tag);
        if (tagFg) {
        	System.out.println(isbn + " " + tagName + " successfully added in Tags table");
        }
        else {
        	System.out.println(isbn + " " + tagName + " not added in Tags table");       	
        }			
	}		

	public static void addBookTag(String isbn, String title, String author,
			LocalDate publishDate, double price,
			String fileName, String tagName) {			
		
		Book book = new Book();		
		BookDAO daoBook = new BookDAOImpl();			
		BookTag bookTag = new BookTag();
		BookTagDAO daoBookTag = new BookTagDAOImpl();
		
		book = daoBook.getBookByISBN(isbn);
		if (book == null) {
			System.out.println(isbn + " not found in Books table");		
			
			bookTag.setIsbn13(isbn);
			bookTag.setTitle(title);
			bookTag.setAuthor(author);
			bookTag.setPublishDate(publishDate);
			bookTag.setPrice(price);
			bookTag.setContent(content);			
			bookTag.setTagName(tagName);			
			
			String returnStr = daoBookTag.addBookTag(bookTag, fileName);
			switch (returnStr) {
			case "000":
				System.out.println(isbn + " "+ tagName +" successfully added in Books & Tags table");
				break;
			case "001":
				System.out.println(isbn + " "+ tagName +" successfully added in Books & Tags table");	
				System.out.println(isbn + " "+ fileName +" not added in Books table");   				
				break;
			case "010":
				System.out.println(isbn + " successfully added in Books table");	
				System.out.println(isbn + " "+ tagName +" not added in Tags table");   	
				System.out.println(isbn + " "+ fileName +" successfully added in Books table");  		
			case "011":	
				System.out.println(isbn + " successfully added in Books table");	
				System.out.println(isbn + " "+ tagName +" not added in Tags table");  				
				System.out.println(isbn + " "+ fileName +" not added in Books table"); 					
			case "11":
				System.out.println(isbn + " "+ tagName +" not added in Books & Tags table");  			   
				break;	
			}
		}
		else {
			System.out.println(isbn + " exist in Books table");		
			printBook(book);
		}						
	}
		
	public static void addBookTagL(String isbn, String title, String author,
			LocalDate publishDate, double price,			
			String fileName, String tagName) {

		boolean bookFg;
		boolean bookContentFg;
		boolean tagFg;
		
		Book book = new Book();
		BookDAO daoBook = new BookDAOImpl();		
		Tag tag = new Tag();
		TagDAO daoTag = new TagDAOImpl(); 
		
		book = daoBook.getBookByISBN(isbn);
		if (book == null) {
			System.out.println(isbn + " not found in Books table");

			Book bk = new Book();
			bk.setIsbn13(isbn);
			bk.setTitle(title);
			bk.setAuthor(author);
			bk.setPublishDate(publishDate);
			bk.setPrice(price);
			bk.setContent(content);
// Add Book			
			bookFg = daoBook.addBook(bk);
			if (bookFg) {
				System.out.println(isbn + " successfully added in Books table");
				
				tag.setIsbn13(isbn);
				tag.setTagName(tagName);
// add Tag				
				tagFg = daoTag.addTag(tag);
				if (tagFg) {
					System.out.println(isbn + " " + tagName + " successfully added in Tags table");
				}
				else {
					System.out.println(isbn + " " + tagName + " not added in Tags table");       	
				}
// update book content				
				bookContentFg = daoBook.updateBookContent(bk.getIsbn13(), fileName);	
				if (bookContentFg) {
					System.out.println(isbn + " " + fileName + " successfully added in Books table");					
				}
				else {
					System.out.println(isbn + " " + fileName + " not added in Books table");										
				}
			}
			else {
				System.out.println(isbn + " not added in Books table");				
			}
		}
		else {
			System.out.println(isbn + " exist in Books table");		
			printBook(book);
		}		
	}	
	
	public static void updateBook(String isbn, String title,
									String author, LocalDate publishDate,
									double price) {			
		// Test method update existing record on Book Table		
		boolean bookFg;	

		Book book = new Book();
		BookDAO daoBook = new BookDAOImpl(); 

		book.setIsbn13(isbn);
		book.setAuthor(author);
		book.setTitle(title);
		book.setPublishDate(publishDate);
		book.setPrice(price);

		bookFg = daoBook.updateBook(book);
		if (bookFg) {		
			System.out.println(isbn + " successfully updated in Books table");
		}
		else {
			System.out.println(isbn + " not updated in Books table");       	       	
		}		
	}
	
	public static void updateBookContent(String isbn, String fileName) {
		// Test method update content field of an existing isbn on Book Table		
		boolean bookFg;	
		
		BookDAO daoBook = new BookDAOImpl(); 
		
		bookFg = daoBook.updateBookContent(isbn, fileName);
		if (bookFg) {		
			System.out.println(isbn + " content "+ fileName + " successfully updated in Books table");
		}
		else {
			System.out.println(isbn + " content "+ fileName + " not updated in Books table");       	       	
		}		
	}		
	
	
	public static void updateTag(String isbn, String tagName1, String tagName2)	{
		// Test method update existing record on Tag Table		
		boolean tagFg;	

		Tag tag = new Tag();
		TagDAO daoTag = new TagDAOImpl(); 

		tag.setIsbn13(isbn);
		tag.setTagName(tagName1);					// tagName1 = new value
		tagFg = daoTag.updateTag(tag, tagName2);	// tagName2 = old value
		if (tagFg) {		
			System.out.println(isbn + " " + tagName1 + " successfully updated in Tags table");
		}
		else {
			System.out.println(isbn + " " + tagName1 + " not updated in Tags table");       	       	
		}		
	}
	

	public static void updateBookTag(String isbn, String title, String author, 
									LocalDate publishDate, double price, String fileName,			
									String tagName1, String tagName2) {		
	
		// Test method update existing record on Book and Tag Table
		BookTag bookTag = new BookTag();
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 

		bookTag.setIsbn13(isbn);
		bookTag.setAuthor(author);
		bookTag.setTitle(title);
		bookTag.setPublishDate(publishDate);
		bookTag.setPrice(price);
		bookTag.setTagName(tagName1);		// tagName1 = new value, tagName2 = old value

		String returnStr = daoBookTag.updateBookTag(bookTag, fileName, tagName2); 
		switch (returnStr) {
		case "000":
			System.out.println(isbn + " " + tagName1 +" successfully updated in Books & Tags table");
			break;
		case "001":
			System.out.println(isbn + " successfully updated in Books table");
			System.out.println(isbn + " " + tagName1 +" successfully updated in Tags table");	
			System.out.println(isbn + " " + fileName +" not updated in Books table");			  
			break;
		case "010":    
			System.out.println(isbn + " successfully updated in Books table");
			System.out.println(isbn + " " + tagName1 +" not updated in Tags table");   
			System.out.println(isbn + " " + fileName +" successfully updated in Books table");				
			break;
		case "011":
			System.out.println(isbn + " successfully updated in Books table");			
			System.out.println(isbn + " " + tagName1 +" not updated in Tags table"); 	
			System.out.println(isbn + " " + fileName +" not updated in Books table");				
			break;
		case "100":
			System.out.println(isbn + " not updated in Books table");  
			System.out.println(isbn + " " + tagName1 +" successfully updated in Tags table");	
			System.out.println(isbn + " " + fileName +" successfully updated in Books table");				
			break;
		case "110":
			System.out.println(isbn + " not updated in Books table");  
			System.out.println(isbn + " " + tagName1 +" not updated in Tags table"); 		
			System.out.println(isbn + " " + fileName +" successfully updated in Books table");				
			break;		
		case "111":
			System.out.println(isbn + " " + tagName1 +" not updated in Books & Tags table");					
			System.out.println(isbn + " " + fileName +" not updated in Books table");			
			break;				
		}		
	}

	public static void deleteBookByISBN(String isbn) {
		// Test method delete Book Table by ISBN	   
		boolean bookFg;		
		BookDAO daoBook = new BookDAOImpl(); 

		bookFg = daoBook.deleteBookByISBN(isbn);
		if (bookFg) {		
			System.out.println(isbn + " successfully deleted in Books table");
		}
		else {
			System.out.println(isbn + " not deleted in Books table");       	       	
		}              				
	}

	public static void deleteTagByISBN(String isbn) {
		// Test method delete Tag Table by ISBN	   
		boolean tagFg;		
		TagDAO daoTag = new TagDAOImpl(); 

		tagFg = daoTag.deleteTagByISBN(isbn);
		if (tagFg) {		
			System.out.println(isbn + " successfully deleted in Tags table");
		}
		else {
			System.out.println(isbn + " not deleted in Tags table");       	       	
		}              		
	}

	public static void deleteTagByISBNTagNameList(String isbn, String tagName) {
		// Test method delete Tag Table by tag Name   
		boolean tagFg;		
		TagDAO daoTag = new TagDAOImpl(); 

		tagFg = daoTag.deleteTagByISBNTagNameList(isbn, tagName);
		if (tagFg) {		
			System.out.println(isbn + " "+ tagName + " successfully deleted in Tags table");
		}
		else {
			System.out.println(isbn + " "+ tagName + " not deleted in Tags table");       	       	
		}      
	}	

	public static void deleteBookTagByISBN(String isbn) {
		
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 
		String returnStr = daoBookTag.deleteBookTagByISBN(isbn);
		switch (returnStr) {
		case "00":
			System.out.println(isbn + " successfully deleted in Books & Tags table");
			break;
		case "01":
			System.out.println(isbn + " successfully deleted in Tags table");
			System.out.println(isbn + " not deleted in Books table");   
			break;
		case "11":
			System.out.println(isbn + " not deleted in Books & Tags table");  			  
			break;		
		}
	}
	
	public static void deleteBookTagByISBNTagName(String isbn, String tagName) {
		
		BookTagDAO daoBookTag = new BookTagDAOImpl(); 
		String returnStr = daoBookTag.deleteBookTagByISBNTagName(isbn, tagName);
		switch (returnStr) {
		case "00":
			System.out.println(isbn + " "+ tagName +" successfully deleted in Books & Tags table");
			break;
		case "01":
			System.out.println(isbn + " "+ tagName +" successfully deleted in Tags table");
			System.out.println(isbn + " not deleted in Books table");   
			break;
		case "11":
			System.out.println(isbn + " "+ tagName +" not deleted in Books & Tags table");  			  
			break;		
		}		
	}
	
	
// Printing methods	
	public static void printBookTag(BookTag bookTag) {
		System.out.println(bookTag.getIsbn13() +" "+ bookTag.getTitle() +" " + 
				bookTag.getAuthor() +" "+ bookTag.getPublishDate() +" "+ 
				bookTag.getPrice() + " "+ bookTag.getContent() +" "+
				bookTag.getTagName());		
	}		
	
	public static void printTag(Tag tag) {
		System.out.println(tag.getIsbn13() +" "+ tag.getTagName());		
	}	
	
	public static void printBook(Book book) {
		System.out.println(book.getIsbn13() +" "+ book.getTitle() +" " + 
				book.getAuthor() +" "+ book.getPublishDate() +" "+ 
				book.getPrice() + " "+ book.getContent());		
	}	
}
