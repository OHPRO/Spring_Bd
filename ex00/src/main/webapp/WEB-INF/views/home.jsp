<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<script> //제이쿼리가서 API받아와서 바꿔서 사용하면 된다.
$.ajax({
	  method: "GET",
	  url: "doJSON",
	  dataType: "jSON"
	  success: function(result){
		  alert(result.name);
		  alert(result.["name"]);
		  alert(result.['name']);
	  }
	});
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
