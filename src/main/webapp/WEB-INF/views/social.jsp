<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star wars Network</title>
</head>
<body>
	<div>
		<f:form modelAttribute="MessageForm" method="post" action="chargerMessage">
			<table>
				<tr>
					<td> Message :</td>
					<td><f:input path="hashtag" /></td>
					<td><f:errors path="hashtag"></f:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="poster" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	
	<div>
		 <c:forEach var="msg" items="${MessageForm.msg}">
		 <p>
		    <c:out value="${msg.content}"/>
		 </p> 
		</c:forEach>
	</div>
</body>
</html>