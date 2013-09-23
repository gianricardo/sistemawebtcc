$(document).ready(function() {
	SISTEMA.usuario = new Object();
	SISTEMA.usuario.consultarUsuario = function(){
		$.ajax({
			 type: "POST",
			 url: "../ConsultarUsuario",
			 success: function (data) {
				 console.dir(data);
				 $("#id").val(data.usuarioID);
				 $("#usuario").val(data.usuario);
				 $("#senha").val(data.senha);
				 $("#nome").val(data.nome);
			 },
			 error: function (rest) {
				 alert("erro na chamada ajax");		   
			 }
		});
	};
	
	SISTEMA.usuario.consultarUsuario();
});