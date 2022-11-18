package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;
import examples.pubhub.dao.BookDAO;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;

/*
 * This servlet will take you to the list of Tags for an ISBN
 */
/**
 * Servlet implementation class TagSearchServlet
 */
@WebServlet("/TagSearchByISBN")
public class TagSearchByISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn13 = request.getParameter("isbn13");
		
		// Grab the list of Tags from the Database
		TagDAO dao = DAOUtilities.getTagDAO();
		List<Tag> tagList = dao.getTagsByISBN(isbn13);

		Book book = new Book();
		book.setIsbn13(request.getParameter("isbn13")); 
		
		
		// Populate the list into a variable that will be stored in the session
		request.getSession().setAttribute("tags", tagList);
		request.setAttribute("radioTagDeletion", "tagName"); //Note: "tagName" here is not the Tag.tagName but the default value of radiobutton option 1 value "tagName" 
		request.setAttribute("book", book);
		request.getRequestDispatcher("tagSearchByISBN.jsp").forward(request, response);
	}
}

