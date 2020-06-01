<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PlatformDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Platform Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Platform</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Back to Home</a>
  <a class="active" href="PlatformServlet?mode=platformlist">Platforms</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PlatformDTO p = (PlatformDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PlatformServlet?mode=update&id=<%=p.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="platform" name="name" value=<%=p.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<%=p.getDescription()%>> 
			
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="website">website</label>
    </div>
   		 <div class="col-75">
<input type="text" id="website" name="website" value=<%=p.getWebsite()%>> 
  					</div>
		
    </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>