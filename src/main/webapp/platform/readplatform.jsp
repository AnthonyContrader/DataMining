<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PlatformDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Read Platform</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  
  <a class="active"  href="PlatformServlet?mode=platformlist">Platform</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%PlatformDTO p = (PlatformDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Description</th>
		<th>Website</th>
	</tr>
	<tr>
		<td><%=p.getName()%></td>
		<td> <%=p.getDescription()%></td>
		<td> <%=p.getWebsite()%></td>
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