$(document).ready(function() {
	$("#divConfig a").click(function( e ){ 
		var href = $( this ).attr('href');  
		e.preventDefault();  
		$("#content").load(href);  
    });
});