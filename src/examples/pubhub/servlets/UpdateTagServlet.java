package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class UpdateTagServlet
 */
@WebServlet("/UpdateTag")
public class UpdateTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isSuccess= false;
		
		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");   // tagName  = Old Value
		String tagName2 = request.getParameter("tagName2"); // tagName2 = New Value
		
		TagDAO daoTag = DAOUtilities.getTagDAO();
		
		Tag tag = daoTag.getTagByISBNTagName(isbn13, tagName);		
		
		if(tag != null){
			// The only field we want to update is tagName. 
			// Note: tagName is also a secondary key, we could not update one value to tagName
			//       for the isbn+tagName combination, it will error out for potential duplicate keys
			//       and so it has to be a unique key combination
			tag.setIsbn13(isbn13);
			tag.setTagName(tagName2); // tagName2 = New Value
			
			request.setAttribute("tag", tag);
			isSuccess = daoTag.updateTag(tag, tagName); // tagName = Old Value
		}else {
			//ASSERT: couldn't find book with isbn. Update failed.
			isSuccess = false;
		}
		
		if(isSuccess){
			request.getSession().setAttribute("message", "Tag successfully updated");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("ViewTagDetails?isbn13=&tagName=" + isbn13 + tagName);
		}else {
			request.getSession().setAttribute("message", "There was a problem updating this Tag");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("tagDetails.jsp").forward(request, response);
		}
	}

}
