<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ArticleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Read Article</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  
  <a class="active"  href="ArticleServlet?mode=articlelist">Articles</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ArticleDTO a = (ArticleDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
	</tr>
	<tr>
		<td><%=a.getName()%></td>
		<td> <%=a.getDescription()%></td>
		<td> <%=a.getPrice()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>