$(document).ready(function() {
	$("#menu-ul li").mouseover(function() {
		$(this).addClass("li-mouse-over");
	});
	$("#menu-ul li").mouseout(function() {
		$(this).removeClass("li-mouse-over");
	});
	
	$("#menu-ul a").click(function( e ){ 
		var href = $( this ).attr('href');  
		if(href != "../logout.jsp"){
			e.preventDefault();  
			$("#content").load(href);  
		}
    });
	
	SISTEMA = new Object();
	SISTEMA.ajax = new Object();
	SISTEMA.ajax.post = function(){
		$.ajax({
			 type: "POST",
			 url: "../VerificaAdm",
			 success: function (data) {
				 if(data.usuarioAdm == "1"){
					 $("#cadastroAdm").css("display","block");
			 	 }
			 },
			 error: function (rest) {
				 alert("erro na chamada ajax");		   
			 }
		}
		);
	};
	SISTEMA.ajax.post();
	
	SISTEMA.ajax.iniciarRotina = function(){
		$.ajax({
			 type: "POST",
			 url: "../RotinaServlet",
			 success: function (data) {
				 alert("Rotina iniciada!");
			 },
			 error: function (rest) {
				 alert("Erro ao iniciar a rotina!");		   
			 }
		}
		);
	};
});

