/**
 * 
 */
					var text = document.getElementById('rb').value;								
		 			switch (text){
			 			case 'tagName':
			 			    document.getElementById('rb_tagName').checked = true;
			 				break;
			 			case 'tagNames':
			 			    document.getElementById('rb_tagNames').checked = true;
			 				break;
		 				case 'isbn':
			 			    document.getElementById('rb_isbn').checked = true;
		 					break;
		 				default:
		 					document.getElementById('rb_tagName').checked = true;
		 			}