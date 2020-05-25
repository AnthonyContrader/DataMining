<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.FeedbackDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>FEEDBACK</title>
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
      <label for="vote">Vote</label>
    </div>
    <div class="col-75">
      <input type="text" id="feedback" name="vote" placeholder="inserisci un voto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="review">Review</label>
    </div>
    <div class="col-75">
      <input type="text" id="review" name="review" placeholder="inserisci una recenzione"> 

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