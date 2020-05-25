<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ArticleDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Edit Article</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  
  <a class="active" href="ArticleServlet?mode=articlelist">Articles</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<br>

<div class="main">

<%ArticleDTO a = (ArticleDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ArticleServlet?mode=update&id=<%=a.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=a.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="name">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<%=a.getDescription()%>> 	
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Price</label>
    </div>
   		 <div class="col-75">
		 <input type="text" id="price" name="price" value=<%=a.getPrice()%>> 
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>