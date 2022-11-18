package examples.pubhub.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Implementation for the BookTagDAO, responsible for querying the database for Book & Tag objects.
 */
public class BookTagDAOImpl implements BookTagDAO {

	Connection connection = null;	// Our connection to the database
	PreparedStatement stmt = null;	// We use prepared statements to help protect against SQL injection
	
	/*------------------------------------------------------------------------------------------------*/
	
	
	@Override
	public List<BookTag> getAllBookTags() {
		
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();	// Get our database connection from the manager
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 ORDER BY Books.isbn_13, Book_Tags.tag_name";			// Our SQL query
			stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
			
			ResultSet rs = stmt.executeQuery();			// Queries the database

			// So long as the ResultSet actually contains results...
			while (rs.next()) {
				// We need to populate a BookTag object with info for each row from our query result
				BookTag bookTag = new BookTag();

				// Each variable in our BookTag object maps to a column in a row from our results.
				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setAuthor(rs.getString("author"));

				// The SQL DATE datatype maps to java.sql.Date... which isn't well supported anymore. 
				// We use a LocalDate instead, because this is Java 8.		
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());				
				bookTag.setPrice(rs.getDouble("price"));

				// The PDF file is tricky; file data is stored in the DB as a BLOB - Binary Large Object. It's
				// literally stored as 1's and 0's, so this one data type can hold any type of file.					
				bookTag.setContent(rs.getBytes("content"));
				bookTag.setTagName(rs.getString("tag_name"));
															
				// Finally we add it to the list of Tag objects returned by this query.
				bookTags.add(bookTag);			
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}
		
		// return the list of BookTag objects populated by the DB.
		return bookTags;
	}


	/*------------------------------------------------------------------------------------------------*/


	@Override
	public List<BookTag> getAllBooks() {
		
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();	// Get our database connection from the manager
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books LEFT JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 ORDER BY Books.isbn_13, Book_Tags.tag_name";			// Our SQL query
			stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
			
			ResultSet rs = stmt.executeQuery();			// Queries the database

			// So long as the ResultSet actually contains results...
			while (rs.next()) {
				// We need to populate a BookTag object with info for each row from our query result
				BookTag bookTag = new BookTag();

				// Each variable in our BookTag object maps to a column in a row from our results.
				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setAuthor(rs.getString("author"));

				// The SQL DATE datatype maps to java.sql.Date... which isn't well supported anymore. 
				// We use a LocalDate instead, because this is Java 8.		
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());				
				bookTag.setPrice(rs.getDouble("price"));

				// The PDF file is tricky; file data is stored in the DB as a BLOB - Binary Large Object. It's
				// literally stored as 1's and 0's, so this one data type can hold any type of file.					
				bookTag.setContent(rs.getBytes("content"));
				bookTag.setTagName(rs.getString("tag_name"));
															
				// Finally we add it to the list of Tag objects returned by this query.
				bookTags.add(bookTag);			
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}
		
		// return the list of BookTag objects populated by the DB.
		return bookTags;
	}


	/*------------------------------------------------------------------------------------------------*/

	@Override
	public List<BookTag> getBookTagsByTitle(String title) {
		
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Books.title LIKE ? ORDER BY Books.isbn_13, Book_Tags.tag_name";	// Note the ? in the query
			stmt = connection.prepareStatement(sql);
			
			// This command populate the 1st '?' with the title and wildcards, between ' '
			stmt.setString(1, "%" + title + "%");	
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTag bookTag = new BookTag();

				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));
				bookTag.setTagName(rs.getString("tag_name"));				
				
				bookTags.add(bookTag);
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}

	
	/*------------------------------------------------------------------------------------------------*/
	
	
	@Override
	public List<BookTag> getBookTagsByAuthor(String author) {
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Books.author LIKE ? ORDER BY Books.isbn_13, Book_Tags.tag_name";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, "%" + author + "%");
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTag bookTag = new BookTag();

				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));
				bookTag.setTagName(rs.getString("tag_name"));
				
				bookTags.add(bookTag);
				
			}
			
			rs.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}

	
	/*------------------------------------------------------------------------------------------------*/
	

	@Override
	public List<BookTag> getBookTagsLessThanPrice(double price) {
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Books.price < ? ORDER BY Books.isbn_13, Book_Tags.tag_name";
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, price);;
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTag bookTag = new BookTag();

				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));
				bookTag.setTagName(rs.getString("tag_name"));
				
				bookTags.add(bookTag);
			}
		
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}

	
	/*------------------------------------------------------------------------------------------------*/
	

	@Override
	public List<BookTag> getBookTagByISBN(String isbn) {
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Books.isbn_13 = ? ORDER BY Books.isbn_13, Book_Tags.tag_name";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTag bookTag = new BookTag();
				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));		
				bookTag.setTagName(rs.getString("tag_name"));	
				
				bookTags.add(bookTag);
			}
			
			rs.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}


	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public List<BookTag> getBookTagByISBNTagName(String isbn, String tagName) {
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Books.isbn_13=? AND Book_Tags.tag_name LIKE ? ORDER BY Books.isbn_13, Book_Tags.tag_name";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);
			stmt.setString(2, "%" + tagName + "%");
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTag bookTag = new BookTag();
				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));		
				bookTag.setTagName(rs.getString("tag_name"));	
				
				bookTags.add(bookTag);
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}


	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public List<BookTag> getBookTagByTagName(String tagName) {
		List<BookTag> bookTags = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT Books.isbn_13, Books.title, Books.author, Books.publish_date, Books.price, Books.content, Book_Tags.tag_name FROM Books INNER JOIN Book_Tags ON Books.isbn_13 = Book_Tags.isbn_13 WHERE Book_Tags.tag_name LIKE ? ORDER BY Books.isbn_13, Book_Tags.tag_name";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, "%" + tagName + "%");
			
			ResultSet rs = stmt.executeQuery();


			while (rs.next()) {
				BookTag bookTag = new BookTag();
				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setAuthor(rs.getString("author"));
				bookTag.setTitle(rs.getString("title"));
				bookTag.setPublishDate(rs.getDate("publish_date").toLocalDate());
				bookTag.setPrice(rs.getDouble("price"));
				bookTag.setContent(rs.getBytes("content"));		
				bookTag.setTagName(rs.getString("tag_name"));	
				
				bookTags.add(bookTag);
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}


	/*------------------------------------------------------------------------------------------------*/
	
	
	@Override
	public String addBookTag(BookTag bookTag, String fileName) {
		boolean bookFg;
		boolean bookContentFg;
		boolean tagFg;

		bookFg = addBook(bookTag);
		if (bookFg) {				
			// if true, we can add our tag to the DB				
			tagFg = addTag(bookTag);		
			if (tagFg) {
				// if addTag is true, we can update the book content
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "000";
				else
					return "001";
			}
			else {
				// if addTag is false, we can still update the book content
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "010";
				else
					return "011";
			}
					
		}
		else {
			return "11";			
		}					
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	public boolean addBook(BookTag bookTag) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO Books VALUES (?, ?, ?, ?, ?, ?)"; // Were using a lot of ?'s here...
			stmt = connection.prepareStatement(sql);

			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getIsbn13());
			stmt.setString(2, bookTag.getTitle());
			stmt.setString(3, bookTag.getAuthor());
			stmt.setDate(4, Date.valueOf(bookTag.getPublishDate()));
			stmt.setDouble(5, bookTag.getPrice());

			stmt.setBytes(6, bookTag.getContent());

			// If we were able to add our book to the DB, we want to return true. 
			// This if statement both executes our query, and looks at the return 
			// value to determine how many rows were changed
			if (stmt.executeUpdate() != 0)
				return true;				
			else
				return false;
			

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}	
	}


	/*------------------------------------------------------------------------------------------------*/


	public boolean addTag(BookTag bookTag) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO Book_Tags VALUES (?, ?)"; // Were using a lot of ?'s here...
			stmt = connection.prepareStatement(sql);

			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getIsbn13());
			stmt.setString(2, bookTag.getTagName());

			// If we were able to add our tag to the DB, we want to return true. 
			// This if statement both executes our query, and looks at the return 
			// value to determine how many rows were changed
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}		
	}


	/*------------------------------------------------------------------------------------------------*/


	public boolean updateBookContent(String isbn, String fileName) {

		InputStream is = null;
		
		File file = new File(fileName);
		System.out.println(file.exists()?"File exists":"The file does not exist! Did you delete "+fileName+"?");
		System.out.println(file.getAbsolutePath());
		try {
			is = new FileInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE Books SET content=? WHERE isbn_13=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setBinaryStream(1, is, file.length());
			stmt.setString(2, isbn);
			
			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		
	}	
	
	
	/*------------------------------------------------------------------------------------------------*/
	
	
	@Override
	public String updateBookTag(BookTag bookTag, String fileName, String tagName) {
		boolean bookFg;
		boolean bookContentFg;
		boolean tagFg;
		
		bookFg = updateBook(bookTag);
		if (bookFg) {
			// if true, we can update tag to the DB	
			tagFg = updateTag(bookTag, tagName);		
			if (tagFg) {
				// if update tag is true, we can update book content to the DB
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "000";
				else
					return "001";					
			}
			else {
				// if update tag is false, we can still update book content to the DB
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "010";
				else
					return "011";								
			}
		}
		else {
			// if false, we can still update tag to the DB
			tagFg = updateTag(bookTag, tagName);		
			if (tagFg) {
				// if update tag is true, we can update book content to the DB
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "100";
				else
					return "111";					
			}
				
			else {
				// if update tag is false, we can still update book content to the DB
				bookContentFg = updateBookContent(bookTag.getIsbn13(), fileName);
				if (bookContentFg)
					return "110";
				else
					return "111";							
			}
		}	
	}

	/*------------------------------------------------------------------------------------------------*/

	
	public boolean updateBook(BookTag bookTag) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE Books SET title=?, author=?, price=? WHERE isbn_13=?";			
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, bookTag.getTitle());
			stmt.setString(2, bookTag.getAuthor());
			stmt.setDouble(3, bookTag.getPrice());
			stmt.setString(4, bookTag.getIsbn13());
			
			System.out.println(stmt);

			if (stmt.executeUpdate() != 0) 
				return true;

			else 
				return false;	

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}			
	}

	/*------------------------------------------------------------------------------------------------*/


	public boolean updateTag(BookTag bookTag, String tagName) {	
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE Book_Tags SET tag_name=? WHERE isbn_13=? AND tag_name=?";			
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, bookTag.getTagName());	// new value
			stmt.setString(2, bookTag.getIsbn13());
			stmt.setString(3, tagName);					// old value

			System.out.println(stmt);

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}	
	}
		
	
	/*------------------------------------------------------------------------------------------------*/
	

	@Override
	public String deleteBookTagByISBN(String isbn) {
		boolean bookFg;
		boolean tagFg;

		tagFg = deleteTagByISBN(isbn);
		if (tagFg) {
			// if true, we can delete book in the DB				
			bookFg = deleteBookByISBN(isbn);		
			if (bookFg) 
				return "00";
			else
				return "01";	
		}
		else {
			return "11";			
		}			
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	public boolean deleteBookByISBN(String isbn) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM Books WHERE isbn_13=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		
	}

	
	/*------------------------------------------------------------------------------------------------*/
	
	
	public boolean deleteTagByISBN(String isbn) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM Book_Tags WHERE isbn_13=?";
			stmt = connection.prepareStatement(sql);			
					
			stmt.setString(1, isbn);

			if (stmt.executeUpdate() != 0)
				return true;	
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}		
	}
	
	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public String deleteBookTagByISBNTagName(String isbn, String tagName) {
		boolean bookFg;
		boolean tagFg;

		tagFg = deleteTagByISBNTagName(isbn, tagName);
		if (tagFg) {
			// if true, we can delete Book in the DB				
			bookFg = deleteBookByISBN(isbn);		
			if (bookFg) 
				return "00";
			else
				return "01";	
		}
		else {
			return "11";			
		}					
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	public boolean deleteTagByISBNTagName(String isbn, String tagName) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM Book_Tags WHERE isbn_13=? AND tag_name LIKE ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);
			stmt.setString(2, "%" + tagName + "%");		

			if (stmt.executeUpdate() != 0)
				return true;	
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}		
	}	
	
	
	/*------------------------------------------------------------------------------------------------*/

	
	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
}
