	SISTEMA.ajax.get = function(){
		$.ajax({
			 type: "GET",
			 url: "http://192.168.1.3/i="+$("#campoTextoAlimentacaoImediata").val(),
			 success: function (data) {
				 alert("Alimentou!");
			 },
			 error: function (rest) {
				 alert("erro na chamada ajax");		   
			 }
		}
		);
	};