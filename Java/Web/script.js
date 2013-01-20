$(document).ready(function(){
	$(".row a").on("click", function(e){
		e.preventDefault();
		
		if($(this).hasClass("sel")) { 
			// already selected 
		} else {
			$("a.sel").removeClass("sel");
			$(this).addClass("sel");
			
			var rid = $(this).attr('id');
			var value = '[value="'+rid+'"]';
			
			$('input:radio[name="category"]').filter(value).attr('checked', true);			
		}
	});
});