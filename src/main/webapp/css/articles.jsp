<%@ page import="it.contrader.dto.ArticleDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Article Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Article Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
<a  href="homeadmin.jsp">Back to Home</a>
<a class="active" href="ArticleServlet?mode=articlelist">Articles</a>
 <a href="BrandServlet?mode=brandlist">Brands</a>
  <a href="PlatformServlet?mode=platformlist">Platforms</a>
  <a href="FeedbackServlet?mode=feedbacklist">Feedbacks</a>

 <a href="LogoutServlet" id="logout">Logout</a>
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
      <label for="na">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="na" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="desc">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="desc" name="description" placeholder="inserisci descrizione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="pri">Price</label>
    </div>
   		 <div class="col-75">
   		 <input type="text" id="pri" name="price" placeholder="inserisci prezzo"> 
   	</div>
</div>
 <button type="submit" >Insert</button>    
	</form>
	</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>