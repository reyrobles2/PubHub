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
	
		<h1>PUBHUB <small>Book Tags for Deletion - ${tag.isbn13 }</small></h1>
		<hr class="tag-primary">
		
		  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${tag.isbn13 }" />
	      <input type="hidden" class="form-control" id="tagName" name="tagName" value="${tag.tagName }"  />
		  <input type="hidden" class="form-control" id="tagCount" name="tagCount" value="${tagCount}" />
		  
		 <div class="form-group">		
			<table class="table table-striped table-hover table-responsive pubhub-datatable">
				<thead>
					<tr>
						<td>ISBN-13:</td>
						<td>Tag Name:</td>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="delTag" items="${delTags}">
						<tr>
							<td><c:out value="${delTag.isbn13}" /></td>													
							<td><c:out value="${delTag.tagName}" /></td>
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<p id="delConfirmText"></p><br>
		
			<div class="col-sm-offset-4 col-sm-1">
		  	<form action="DeleteTag" method="post" class="form-horizontal" >
		  		<input type="hidden" class="form-control" name="isbn13" required="required" value="${tag.isbn13}">
				<input type="hidden" class="form-control" name="tagName" value="${tag.tagName}">
				<input type="hidden" class="form-control" name="radioTagDeletion" value="${radioTagDeletion}">
				<button type="submit" class="btn btn-info">Confirm Delete</button>
		 	</form>
		 	</div>

		  	<div class="col-sm-offset-4 col-sm-1">				
			<form action="ViewTagDetailsDelete" method="get" class="form-horizontal" >
		  		<input type="hidden" class="form-control" name="isbn13" required="required" value="${tag.isbn13}">
				<input type="hidden" class="form-control" name="tagName" value="${tag.tagName}">		
				<input type="hidden" class="form-control" name="radioTagDeletion" value="${radioTagDeletion}">					
				<button type="submit" class="btn btn-primary">Cancel</button>
		 	</form>
		 	</div>
		 			  	
		  	<div class="col-sm-offset-4 col-sm-1">				
			<form action="TagSearch" method="get" class="form-horizontal" >
				<button type="submit" class="btn btn-info">Tag Search</button>
		 	</form>
		 	</div>
		 	
		  	<div class="col-sm-offset-4 col-sm-1">						 	
		 		<button onclick="window.print()" class="btn btn-primary">Print this page</button>
		 	</div>
		 	
	  </div>
	</header>
					
	<!-- Footer -->
	<jsp:include page="subFooterDeleteConfirm.jsp" />		
	<jsp:include page="footer.jsp" />
