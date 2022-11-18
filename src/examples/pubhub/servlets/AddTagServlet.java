package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.dao.TagDAOImpl;
import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class AddTagServlet
 */
//@WebServlet(description = "Add Tag to a Book Servlet", urlPatterns = { "/AddTagServlet" })
//@MultipartConfig // This annotation tells the server that this servlet has
//// complex data other than forms

//Notice the lack of the @WebServlet annotation? This servlet is mapped the old
//fashioned way - Check the web.xml!
public class AddTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
    public AddTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("tag.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean isSuccess= false;
		String isbn13 = request.getParameter("isbn13");
		
		BookDAO daoBook = DAOUtilities.getBookDAO();
		Book book = daoBook.getBookByISBN(isbn13);
		TagDAO daoTag = new TagDAOImpl();		
		Tag tag = new Tag();
		
		if(book != null){
			// Add Tag to a Book
			tag.setIsbn13(request.getParameter("isbn13")); 
			tag.setTagName(request.getParameter("tagName"));

			request.setAttribute("tag", tag);
			isSuccess = daoTag.addTag(tag);
		}else {
			//ASSERT: couldn't find book with isbn. Add Tag failed.
			isSuccess = false;
		}
		
		if(isSuccess){
			request.getSession().setAttribute("message", "Tag successfully added");
			request.getSession().setAttribute("messageClass", "alert-success");

			// We use a redirect here instead of a forward, because we don't
			// want request data to be saved. Otherwise, when
			// a user clicks "refresh", their browser would send the data
			// again!
			// This would be bad data management, and it
			// could result in duplicate rows in a database.
			response.sendRedirect(request.getContextPath() + "/TagSearch");			
		}else {
			request.getSession().setAttribute("message", "There was a problem adding tag for this book");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("tag.jsp").forward(request, response);
		}	
	}
}
