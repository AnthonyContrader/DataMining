<%@ page import="it.contrader.dto.PlatformDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Platform Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Platform Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a  href="homeadmin.jsp">Back to Home</a>
<a class="active" href="PlatformServlet?mode=platformlist">Platforms</a>
<a href="ArticleServlet?mode=articlelist">Articles</a>
  <a href="BrandServlet?mode=brandlist">Brands</a>
   <a href="FeedbackServlet?mode=feedbacklist">Feedbacks</a>
 
   <a href="LogoutServlet" id="logout">Logout</a>

</div>

 <div class="main">
	<%
		List<PlatformDTO> list = (List<PlatformDTO>)request.getAttribute("list");
	%>
<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Website</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PlatformDTO p : list) {
		%>
		<tr>
			<td><a href="PlatformServlet?mode=read&id"=<%=p.getId()%>>
					<%=p.getName()%>
			</a></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getWebsite()%></td>
			<td><a href=PlatformServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=PlatformServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="PlatformServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="platform" name="name" placeholder="inserisci name">
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
      <label for="website">Website</label>
    </div>
   		 <div class="col-75">
   		 <input type="text" id="website" name="website" placeholder="inserisci indirizzo web"> 
   		 	
</div>
 <button type="submit" >Insert</button>
</div>
</div>
     
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>