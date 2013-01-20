$(document).ready(function() {
 
	var sDetails = {"servers":[
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090}, 
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                        	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1", "port" : 9090},
	                         	{"env" : "dev", "domain" : "domain1", "instances" :"instances1,instances2,instances1instances1", "port" : 9090} 
	                        ]};
	
	
	
	
	
	
    //Stops the submit request
//    $("#myAjaxRequestForm").submit(function(e){
//           e.preventDefault();
//    });
//    
    //checks for the button click event
   /* $(".serverBtn").click(function(e){
           console.log("id\t" + this.id);
            //get the form data and then serialize that
//            dataString = $("#myAjaxRequestForm").serialize();
            
            //get the form data using another method
           var data_1 = $(this).prev().text();
           console.log(data_1);
           
            dataString = "serverName=" + data_1;
            
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
           
            $.ajax({
                type: "POST",
                url: "serverCheck",
                data: dataString,
                dataType: "html",
                
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                    //our country code was correct so we have some information to display
                	
//                     if(data.success){
                    	 console.log(data);
                    	 $('#serverA_div').html(data);
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     console.log("Something really bad happened " + textStatus);
                     $('#serverA_div').html(jqXHR.responseText);
                },
                
                //capture the request before it was sent to server
                beforeSend: function(jqXHR, settings){
                    //disable the button until we get the response
                    $('.serverBtn').attr("disabled", true);
                },
                
                //this is called after the response or error functions are finsihed
                //so that we can take some action
                complete: function(jqXHR, textStatus){
                    //enable the button 
                    $('.serverBtn').attr("disabled", false);
                }
      
            });        
    });*/
    
    
    var dyna_tabs = {    	    
    	    tabs: null,

    	    init: function (id) {
    	        var tabs = $('<div></div>').append('<div id="'+ id + '"></div>');
    	        $('body').append(tabs);

    	        var list = $('<ul></ul').append('<li><a href="#"></a></li>');
    	        tabs.append(list);
    	        tabs.tabs();

    	        // remove the dummy tab
    	        tabs.tabs('remove', 0);
    	        tabs.hide();
    	        this.tabs = tabs;
    	    },

    	    add: function (tab_id, tab_name, tab_content) {
    	        if (this.tabs != null) {
    	            if (this.tabs.css('display') == 'none') {
    	                this.tabs.show();
    	            }
    	            var data = $('<div id="'+tab_id+'"></div>').append(tab_content);
    	            this.tabs.append(data).tabs('add', '#' + tab_id, tab_name);
    	            this.tabs.tabs('select', '#' + tab_id);
    	        } else {
    	            alert('Tabs not initialized!');
    	        }
    	    }

    	};

    
    	    dyna_tabs.init('mytabs');

    	    var tab_counter = 1;
    	    var tabContent = '';
    	    for( var index = 0; index < sDetails.servers.length; index++ ){
    	    	var instace = sDetails.servers[index].instances;
    	    	instance = instace.substring(0,instace.indexOf('.wellsfargo.com'));
//    	    	console.log("instance\t" + instance);
    	    	
				tabContent += '	<div id=' + sDetails.servers[index].domain  +'_' + instance + '>'    	    	
				+ 'Domain:\t' + sDetails.servers[index].domain 
    	    	+ '&nbsp;'
    	    	+ 'Instance Name:\t' +  sDetails.servers[index].instances
    			+ '&nbsp;'
    	    	+ 'Port:\t' +  sDetails.servers[index].port
    	    	+ '&nbsp;'	
				+ '</div>'
				+ '<div style="display:none;">' + 'domain=' + sDetails.servers[index].domain +',' + 'instances=' 
				+ sDetails.servers[index].instances + ',' + 'port='+  sDetails.servers[index].port
				+ '</div>'
    	    	+ '<div class="chkStatus_div"> <a class="tsc_flat" id='+ index +'_btn href="#">check status</a><div class="status_div"></div></div>';	  	    

    	    }
    	    
    		dyna_tabs.add(
    	            'Tab' +  sDetails.servers[0].env, 
    	            'Tab #' + sDetails.servers[0].env, 
    	            tabContent
    	     ); 	    
    	        
			$('.chkStatus_div').css('padding','5px');
			$('.tsc_flat').css('background', 'none repeat scroll 0 0 #222222')
				.css('border-bottom', '1px solid rgba(0, 0, 0, 0.25)')
				.css('border-radius','5px 5px 5px 5px')
				.css('box-shadow','0 1px 1px rgba(0, 0, 0, 0.2)')
				.css('color','#FFFFFF')
				.css('cursor','pointer')
				.css('display','inline-block')
				.css('padding','5px 10px 6px')
				.css('position','relative')
				.css('text-decoration','none')
				.css('text-shadow','0 -1px 1px rgba(0, 0, 0, 0.1)');
	
			$(".tsc_flat").click(function(e){
				console.log($(this).attr('id'));
				console.log($(this).attr('class'));
				//console.log($(this).attr('class'));
				console.log($(this).parents('.chkStatus_div').attr('class'));
				console.log($(this).parent().prev().html());				
				var dataString = $(this).parent().prev().text().replace(/,/g,'&');
				var statusDiv = $(this).next(".status_div");
			
				$.ajax({
		                type: "POST",
		                url: "serverCheck",
		                data: dataString,
		                dataType: "html",
		                
		                //if received a response from the server
		                success: function( data, textStatus, jqXHR) {               	

		                    	 console.log(data);
		                    	 statusDiv.html(data);
		                },
		                
		                //If there was no resonse from the server
		                error: function(jqXHR, textStatus, errorThrown){
		                     console.log("Something really bad happened " + textStatus);
		                     statusDiv.html(jqXHR.responseText);
		                },		                
		               
		                beforeSend: function(jqXHR, settings){
		                    //disable the button until we get the response
		                    $('.tsc_flat').attr("disabled", true);
		                },	                
		                
		                complete: function(jqXHR, textStatus){
		                    //enable the button 
		                    $('.tsc_flat').attr("disabled", false);
		                }
		      
		            });     
			});

 
});