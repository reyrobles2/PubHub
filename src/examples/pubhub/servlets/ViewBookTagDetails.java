package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.dao.BookTagDAOImpl;
import examples.pubhub.model.BookTag;

/**
 * Servlet implementation class ViewBookTagDetails
 */
@WebServlet("/ViewBookTagDetails")
public class ViewBookTagDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookTagDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// The BookTagDetails.jsp page needs to have the details of the selected Book Tag saved to the request,
		// Otherwise it won't know what details to display. Ergo, we need to fetch those details before we
		// Actually redirect the user.
		String tagName = request.getParameter("tagName");

		// Grab the list of Book Tags for the given tagName from the Database		
		BookTagDAO daoBookTag = new BookTagDAOImpl();
		List<BookTag> BookTagList = daoBookTag.getBookTagByTagName(tagName);	 
		
		// Populate the list into a variable that will be stored in the session
		request.getSession().setAttribute("booktags", BookTagList);
		
		request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);		
	}

}
