SISTEMA = new Object();
	SISTEMA.ajax = new Object();
	SISTEMA.ajax.get = function(){
		$.ajax({
			 type: "GET",
			 url: "192.168.1.3/i=222222",
			 success: function (data) {
				 if(data.botao-enviar){
					 $("#input").css("display","block");
			 	 }
			 },
			 error: function (rest) {
				 alert("erro na chamada ajax");		   
			 }
		}
		);
	};