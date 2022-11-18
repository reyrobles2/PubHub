/**
 * 
 */
		var count  = document.getElementById('tagCount').value;
		var isbn13 = document.getElementById('isbn13').value;
		if (count >1) {
			var text = "You have " + count + " tags to delete for this Book "+ isbn13;
		}else{
			var text = "You have " + count + " tag to delete for this Book "+ isbn13;			
		}				
		document.getElementById("delConfirmText").innerHTML = text;		