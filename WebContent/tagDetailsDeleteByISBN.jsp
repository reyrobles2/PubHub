	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">	
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
 			
		<h1>PUBHUB <small>Tag Details - ${tag.isbn13 }</small></h1>
		<hr class="tag-primary">
	

		<form action="DeleteTagConfirmByISBN" method="get" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${tag.isbn13 }" />

		  <div class="form-group">
		    <label for="tagName" class="col-sm-4 control-label">Tag Name</label>
		    <div class="col-sm-5">		    
		      <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Common word or phrase will delete the tags"  value="${tag.tagName }"  />
		 		 
  				<p>Please select deletion type:</p>
 				<div class="form-group">  
 					<label for="tagName"> 
  					<input type="radio" id="rb_tagName" name="radioTagDeletion" value="tagName"/>  					
 					Remove single Tag only for this Book
  					</label><br/>  					
  									
 					<label for="tagNames"> 
  					<input type="radio" id="rb_tagNames" name="radioTagDeletion" value="tagNames"/>
 					Remove by Tag Names for this Book
  					</label><br/>  					
  					
  					<label for="isbn">		
  					<input type="radio" id="rb_isbn" name="radioTagDeletion" value="isbn"/>
  					Remove all Tag Names for this Book
  					</label><br/>	
  										
  					<input type="hidden" id="rb" name="radioTagDeletion" value="${radioTagDeletion}"> 	  											  										
  				</div>
  				  				
  			</div>				
		  </div>
	    
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Delete</button>
		  	</div>	      
			  
		</form>

		<form action="TagSearchByISBN" method="get" class="form-horizontal" >
		  	 <div class="col-sm-offset-4 col-sm-1">	
		  	 	<input type="hidden" class="form-control" name="isbn13" required="required" value="${tag.isbn13}">
				<button type="submit" class="btn btn-primary">Cancel</button>
			</div>
		 </form>

		<form action="BookTagPublishing" method="get" class="form-horizontal" >
		  	 <div class="col-sm-offset-4 col-sm-1">	
				<button type="submit" class="btn btn-info">Book Tag Search</button>
			</div>
		 </form>
					
	  </div>
	</header>
 			
	<!-- Footer -->
	<jsp:include page="subFooterDelete.jsp" />		
	<jsp:include page="footer.jsp" />
