<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ArticleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>ARTICLE</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">



 <a  href="homeadmin.jsp">Back to Home</a>
 <br>
<br>
<br>
 <div class="main">
	<%
		List<ArticleDTO> list = (List<ArticleDTO>) request.getAttribute("list");
	%>

<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th></th>
			<th></th>
		</tr>
		
		
</body>
</html>