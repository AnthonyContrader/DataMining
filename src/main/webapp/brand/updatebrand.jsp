<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BrandDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Edit Brand</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  
  <a class="active" href="BrandServlet?mode=brandlist">Brands</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%BrandDTO b = (BrandDTO) request.getAttribute("dto");%>


<form id="floatleft" action="BrandServlet?mode=update&id=<%=b.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="brand">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="article" name="name" value=<%=b.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="category">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" value=<%=b.getCategory()%>> 
	  </div>
	  
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>