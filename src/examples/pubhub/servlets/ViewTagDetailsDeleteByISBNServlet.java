package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.dao.TagDAOImpl;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class ViewTagDetailsServlet
 */
//This is a "View" servlet, and has been named accordingly. All it does is send the user to a new JSP page
//But it also takes the opportunity to populate the session or request with additional data as needed.
@WebServlet("/ViewTagDetailsDeleteByISBN")
public class ViewTagDetailsDeleteByISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTagDetailsDeleteByISBNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// The tagDetailsDeleteByISBN.jsp page needs to have the details of the selected tag saved to the request,
		// Otherwise it won't know what details to display. Ergo, we need to fetch those details before we
		// Actually redirect the user.
		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");	
		String rb = request.getParameter("radioTagDeletion");
		
		TagDAO dao = DAOUtilities.getTagDAO();		

		Tag tag = dao.getTagByISBNTagName(isbn13, tagName);

		if (tag == null) {
			tag = new Tag();			
			tag.setIsbn13(request.getParameter("isbn13")); 
			tag.setTagName(request.getParameter("tagName"));
		}
	
		request.getSession().setAttribute("tag", tag);
		request.setAttribute("radioTagDeletion", rb);			
		request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);					
	}

}
