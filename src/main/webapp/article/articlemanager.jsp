<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ArticleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Article Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a  href="homeadmin.jsp">Back to Home</a>
<a class="active" href="ArticleServlet?mode=articlelist">Articles</a>
 </div>
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
		<%
			for (ArticleDTO a : list) {
		%>
		<tr>
			<td><a href=ArticleServlet?mode=read&id=<%=a.getId()%>>
					<%=a.getName()%>
			</a></td>
			<td><%=a.getDescription()%></td>
			<td><%=a.getPrice()%></td>
			<td><a href=ArticleServlet?mode=read&update=true&id=<%=a.getId()%>>Edit</a>
			</td>
			<td><a href=ArticleServlet?mode=delete&id=<%=a.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ArticleServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" placeholder="inserisci descrizione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="price">Price</label>
    </div>
   		 <div class="col-75">
   		 <input type="text" id="price" name="price" placeholder="inserisci prezzo"> 
   	</div>
</div>
 <button type="submit" >Insert</button>    
	</form>
	</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>