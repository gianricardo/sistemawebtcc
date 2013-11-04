$(document).ready(function() {
	$("#divConfig a").click(function( e ){ 
		var href = $( this ).attr('href');  
		e.preventDefault();  
		$("#content").load(href);  
	});
	
	$.ajax({
		 type: "POST",
		 url: "../VerificaAdm",
		 success: function (data) {
			 if(data.usuarioAdm == "1"){
				 $("#configAdmRotina").css("display","block");
			 }
		 },
		 error: function (rest) {
			 alert("erro na chamada ajax");		   
		 }
	}
	);
	
});

