<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.BrandDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>BRAND</title>
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
		List<BrandDTO> list = (List<BrandDTO>) request.getAttribute("list");
	%>
<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Category</th>
            <th></th>
			<th></th>
		</tr>
		<%
			for (BrandDTO b : list) {
		%>
		<tr>
			<td><a href=BrandServlet?mode=read&id=<%=b.getId()%>>
					<%=b.getName()%>
			</a></td>
			<td><%=b.getCategory()%></td>
			
			<td><a href=BrandServlet?mode=read&update=true&id=<%=b.getId()%>>Edit</a>
			</td>
			<td><a href=BrandServlet?mode=delete&id=<%=b.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="BrandServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="brand" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="category">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" placeholder="inserisci categoria"> 

  </div>
</select>

 <button type="submit" >Insert</button>
</div>
</div>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>