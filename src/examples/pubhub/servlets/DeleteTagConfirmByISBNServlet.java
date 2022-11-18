package examples.pubhub.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.dao.TagDAOImpl;
import examples.pubhub.model.Tag;

/**
 * Servlet implementation class DeleteTagServlet
 */
@WebServlet("/DeleteTagConfirmByISBN")
public class DeleteTagConfirmByISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTagConfirmByISBNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean isValid = true;
		int option = 1;		
		int tagCount;
		
		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");
		String rb = request.getParameter("radioTagDeletion");

		Tag tag = new Tag();
		
		if (rb.equals("tagName")){ 
			option = 1;
			if (tagName.isEmpty()) {
				isValid = false;
				
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));
				request.setAttribute("tag", tag);	
				request.setAttribute("radioTagDeletion", rb);				
						
				request.getSession().setAttribute("message", "Tag Name is empty for selected radio button");
				request.getSession().setAttribute("messageClass", "alert-danger");
				request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);			
			}
		}
		if (rb.equals("tagNames")) {
			option = 2;
			if (tagName.isEmpty()) {
				isValid = false;
			
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));
				request.setAttribute("tag", tag);	
				request.setAttribute("radioTagDeletion", rb);				
						
				request.getSession().setAttribute("message", "Tag Name is empty for selected radio button");
				request.getSession().setAttribute("messageClass", "alert-danger");
				request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);			
			}
		}
		if (rb.equals("isbn")) {
			option = 3;
			if (!tagName.isEmpty()) {			
				isValid = false;
				
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));
				request.setAttribute("tag", tag);	
				request.setAttribute("radioTagDeletion", rb);				
				
				request.getSession().setAttribute("message", "Tag Name is filled for selected radio button. It should be empty");
				request.getSession().setAttribute("messageClass", "alert-danger");
				request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);						
			}
		}	
		
		if (isValid) {

			TagDAO daoTag = new TagDAOImpl(); 
			List<Tag> tagListDel = null;	

			switch (option) {
			case 1:
				tagListDel = daoTag.getTagByISBNTagNameList(isbn13, tagName);	
				break;
			case 2:
				tagListDel = daoTag.getTagsByISBNTagName(isbn13, tagName); 
				break;
			case 3:
				tagListDel = daoTag.getTagsByISBN(isbn13);
				break;
			}			
		
			if(tagListDel.size() != 0){							
				// Delete Tag Parameters and Attributes required to pass to the new JSP page 
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));								

				request.getSession().setAttribute("tag", tag);
				
				tagCount = tagListDel.size();
				request.setAttribute("tagCount", tagCount);
				
				// Populate the list into a variable that will be stored in the session
				request.getSession().setAttribute("delTags", tagListDel);
				
				request.setAttribute("radioTagDeletion", rb);

// since i am calling another servlet from my servlet, i will use a request dispatcher
// passing my variable to the request attribute to the other servlet				
				request.getRequestDispatcher("tagDetailsDeleteConfirmByISBN.jsp").forward(request, response);
			
			}else {
				//ASSERT: couldn't find Tag with isbn and tagName. Delete Tag failed.
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));
				request.setAttribute("tag", tag);	
				request.setAttribute("radioTagDeletion", rb);	
				
				request.getSession().setAttribute("message", "There was a problem deleting tag for this book");
				request.getSession().setAttribute("messageClass", "alert-danger");			
				request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);						

			}	
		}	
	}

}
