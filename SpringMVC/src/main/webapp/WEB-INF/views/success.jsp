<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
</head>
<body>

	<div>
		<p class="text-left text-primary">
		<h4>Hello, ${common}</h4>
		</p>
		<p class="text-left">
		<h4>
			private page : <a href="<c:url value='/j_spring_security_logout' />">Logout
		</h4>
		</a>
		</p>
	</div>
	<br>
	<P>
		<font color="green">${successMessage}.</font>
	</P>
	Email :
	<c:out value="${loginDetails.name}"></c:out>
	<br> Password :
	<c:out value="${loginDetails.password}"></c:out>
	<br>
	<c:if test="${emp ne null}">
Employee Name : <c:out value="${emp.nameOfEmployee}" />
		<br>
Employee Id : <c:out value="${emp.id}" />
		<br>
	</c:if>
	Controller Name :
	<c:out value="${controller}" />
	<br> Date :
	<fmt:formatDate value="${date}" pattern="dd-MM-yyyy" />
	<c:set var="count" value="0" scope="page" />
	<div class="table-responsive">
		<table class="table">

			<tr>
				<th>S.No</th>
				<c:forEach var="vals" items="${itemsIndex}">
					<th><c:out value="${vals}" /></th>
				</c:forEach>
			</tr>


			<c:set var="count" value="0" scope="page" />
			<c:forEach var="vals" items="${items}">
				<tr>
					<c:set var="count" value="${count + 1}" scope="page" />
					<td><c:out value="${count}" /></td>
					<td><c:out value="${vals.id}" /></td>
					<td><c:out value="${vals.itemBrand}" /></td>
					<td><c:out value="${vals.itemName}" /></td>
					<td><c:out value="${vals.itemPrice}" /></td>
					<td><fmt:formatDate value="${vals.itemMfd}"
							pattern="dd-MM-yyyy" /></td>
							
					<td><c:out value="${vals.itemDescription}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
<div class="jumbotron">
	
	
<%-- <c:redirect url="/admin/register"/> --%>
<!-- Expression language EL --><br>
<div class="row">
<div class="text-justify col-sm-2">
<c:set var="name" value="this is sample text" scope="page">
	</c:set>
	<c:set var="text" value="[-my-name-is-sushil-kumar-bhaskar-]"
		scope="page">
	</c:set>
	length : ${fn:length(name)}<br>
	<c:set var="newval" value='${fn:split(name, " ")}' />
	<c:set var="val" value='${fn:join(newval, "\")}' />
	<br> val :
	<c:out value="${val}"></c:out>
	<c:forEach var="array" items='${fn:split(name, " ")}'>
		<c:out value="${array}" />
	</c:forEach>
	<br>
	<c:choose>
		<c:when test='${fn:contains(name,"sample")}'>
sample found
</c:when>
		<c:otherwise>
			<c:set var="var" value="${fn:substring(name,6,8)}" />
			<c:out value="${var}" />
		</c:otherwise>
	</c:choose>
	<br>
	<c:set var="count" value="0" scope="page" />
	<c:forTokens items="${text}" delims="-" var="item">
		<c:set var="count" value="${count + 1}" />
		<c:out value="${item}" />
	</c:forTokens>
	<br> count : =
	<c:out value="${count}" />
</div>
<div class="text-justify col-sm-4">
Hit : ${cookie.hitCounter.value}<br>
Headers : ${header["Accept-Encoding"]}<br>
Browser : ${header["User-Agent"]}<br>
Server : ${pageContext.servletContext.serverInfo}<br>
session ID  : ${cookie.JSESSIONID.value}<br>
${ cookie.hitCounter.value >12 ? "<p>greater than 12</p>" : "<p>less than 12</p>"}
</div>

<div class="text-justify col-sm-4">
Boolean : ${56<5}
</div>

</div>
</div>
</html>
