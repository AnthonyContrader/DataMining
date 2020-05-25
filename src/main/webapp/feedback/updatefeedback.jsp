<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/mikitostyle.css" rel="stylesheet">
<title>Edit Feedback</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a class="active" href="FeedbackServlet?mode=feedbacklist">Feedbacks</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%FeedbackDTO f = (FeedbackDTO) request.getAttribute("dto");%>

<form id="floatleft" action="FeedbackServlet?mode=update&id=<%=f.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="feedback">Vote</label>
    </div>
    <div class="col-75">
      <input type="text" id="feedback" name="vote" value=<%=f.getVote()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="review">Review</label>
    </div>
    <div class="col-75">
      <input type="text" id="review" name="review" value=<%=f.getReview()%>> 
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>