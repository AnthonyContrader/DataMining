<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.FeedbackDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Feedback Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a  href="homeadmin.jsp">Back to Home</a>
<a class="active" href="FeedbackServlet?mode=feedbacklist">Feedbacks</a>
 <a href="ArticleServlet?mode=articlelist">Articles</a>
  <a href="BrandServlet?mode=brandlist">Brands</a>
  <a href="PlatformServlet?mode=platformlist">Platforms</a>
 

  </div>
<div class="main">
	<%
		List<FeedbackDTO> list = (List<FeedbackDTO>) request.getAttribute("list");
	%>
	
<br>

	<table>
		<tr>
			<th>Vote</th>
			<th>Review</th>
            <th></th>
			<th></th>
		</tr>
		<%
			for (FeedbackDTO f : list) {
		%>
		<tr>
			<td><a href=FeedbackServlet?mode=read&id=<%=f.getId()%>>
					<%=f.getVote()%>
			</a></td>
			<td><%=f.getReview()%></td>
			
			<td><a href=FeedbackServlet?mode=read&update=true&id=<%=f.getId()%>>Edit</a>
			</td>
			<td><a href=FeedbackServlet?mode=delete&id=<%=f.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="FeedbackServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="feedback">Vote</label>
    </div>
    <div class="col-75">
      <input type="number" min="0" max="5" id="feedback" name="vote" placeholder="inserisci voto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="review">Review</label>
    </div>
    <div class="col-75">
      <input type="text" id="review" name="review" placeholder="inserisci recensione"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>

