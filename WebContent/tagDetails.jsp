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
		
		<form action="UpdateTag" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${tag.isbn13 }" />

		  <div class="form-group">
		    <label for="tagName" class="col-sm-4 control-label">Tag Name</label>
		    <div class="col-sm-5">
		      <input type="hidden" class="form-control" id="tagName" name="tagName" placeholder="Tag Name" required="required" value="${tag.tagName }" />		    
		      <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Tag Name" required="required" value="${tag.tagName }" readonly />
		    </div>
	      </div>
	      
		  <div class="form-group">
		    <label for="tagName2" class="col-sm-4 control-label">New Tag Name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="tagName2" name="tagName2" placeholder="New Tag Name" required="required" />
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Update</button>
		    </div>
		  </div>
		</form>

	  </div>
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
