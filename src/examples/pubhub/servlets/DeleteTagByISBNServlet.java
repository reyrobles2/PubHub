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
@WebServlet("/DeleteTagByISBN")
public class DeleteTagByISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTagByISBNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean isSuccess = false;
		boolean isValid = true;
		int option = 1;
		
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
//			Tag tag = new Tag();
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
				// Delete Tag 
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));								
				request.getSession().setAttribute("tag", tag);				

				switch (option) {
				case 1:
					isSuccess = daoTag.deleteTagByISBNTagName(tag.getIsbn13(), tag.getTagName());
					break;
				case 2:
					isSuccess = daoTag.deleteTagByISBNTagNameList(tag.getIsbn13(), tag.getTagName());
					break;
				case 3:
					isSuccess = daoTag.deleteTagByISBN(tag.getIsbn13());
					break;
				}				
			}else {
				//ASSERT: couldn't find Tag with isbn and tagName. Delete Tag failed.
				isSuccess = false;
			}
		
			if(isSuccess){
				tag.setIsbn13(request.getParameter("isbn13")); 
				tag.setTagName(request.getParameter("tagName"));
				request.setAttribute("tag", tag);		
				request.setAttribute("radioTagDeletion", rb);				
				request.getSession().setAttribute("message", "Tag successfully deleted");
				request.getSession().setAttribute("messageClass", "alert-success");
// use the redirect method and pass the isbn13 and to retrigger reading the new tags for 
// for the isbn (minus the deleted ones), otherwise in the jsp will still display the old data 
// which is wrong 				
				response.sendRedirect("TagSearchByISBN?isbn13=" + isbn13);
				
			}else {
				request.getSession().setAttribute("message", "There was a problem deleting tag for this book");
				request.getSession().setAttribute("messageClass", "alert-danger");
				request.getRequestDispatcher("tagDetailsDeleteByISBN.jsp").forward(request, response);
			}	
		}
	}

}
