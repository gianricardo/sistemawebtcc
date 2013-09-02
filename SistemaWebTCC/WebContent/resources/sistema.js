$(document).ready(function() {
	$("#menu-ul li").mouseover(function() {
		$(this).addClass("li-mouse-over");
	});
	$("#menu-ul li").mouseout(function() {
		$(this).removeClass("li-mouse-over");
	});
	
	$("#menu-ul a").click(function( e ){  
        e.preventDefault();  
        var href = $( this ).attr('href');  
        $("#content").load(href);  
    });
});

