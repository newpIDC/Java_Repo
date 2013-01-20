<%@page language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    	<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    	<script>
    		$(function(){
        			$('#tab0').tabs();
        			$('#tab1').tabs();
    		});
    	</script>
    	
	</head>
	<body>
		<form id="jqueyForn" action="#">
		<a id="id_0"></a>
		
			<div id="tabs0">
				<ul> 
					<li><a href="#tab00"></a></li>
					<li><a href="#tab01"></a></li>
				</ul>
				<div id="tab00"> tab00</div>
				<div id="tab01"> tab01</div>
			</div>
			<div id="tabs1">
				<ul>
					<li><a href="#tab10"></a></li>
					<li><a href="#tab11"></a></li>					
				</ul>
				<div id="tab10"> tab10 </div>
				<div id="tab11"> tab11 </div>
			</div>
			
		</form>
	</body>
	
</html>