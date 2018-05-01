<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ajax call Example</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#buttonId").click(function(){
		console.log("hello");
		$.ajax({
			type:'GET',
			url: '${pageContext.request.contextPath}/call',
			success:function(result){
				$('#display').html(result);				
			}
		});
	});
	
	$("#name").click(function(){
		var name=$("#textId").val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/getname/'+name,
			success:function(result){
				$('#display1').html(result);
			},
			error:function(result){
				$('#display1').html(result);
			}
		});
	});
	
});

$(document).ready(function(){
	
	$('#jsonId').click(function(){
		var name1=$("#nameId").val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/json/'+name1,
			success:function(result){
				console.log(result);
				/* var data=jQuery.parseJSON(result);
					console.log("data " + data.id);
					console.log("data " + data.nameOfEmployee);
					var result = "Id=" + data.id + "<br>"+  "Name=" + data.nameOfEmployee; */
						   $.each(result, function (index, value) {
						      console.log(index + '=' + value.nameOfEmployee);
						   });
				$('#display2').html(result);
			},
			error:function(){
				console.log(result);
				$('#display2').html(result);
			}
			
		});
	});
	
});



</script>

</head>

<body>
<fieldset>
<legend>Ajax call Example</legend>
<form action="">
<input type="button" id="buttonId" value="click"><br>
<input type="text" id="textId" required><input type="button" id="name" value="say hello" ><br>
<input type="text" id="nameId"><input type="button" id="jsonId" value="GO"><br>
</form>
<span id="display"></span>
<span id="display1"></span>
<span id="display2"></span>
</fieldset>

</body>
</html>