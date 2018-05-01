<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>register page</title>
</head>
	<div class="container ">
		<div class="row">
			<div class="col-sm-2">
				<p class="align-center">${common}</p>
			</div>
			<div class="col-sm-2">
				To edit settings, press
				<kbd>ctrl</kbd>
				+
				<kbd>enter</kbd>
				</kbd>
			</div>
		</div>
		<form:form class="form-horizontal" method="post"	action="${pageContext.request.contextPath}${actionUri}"		modelAttribute="loginDetails">
			<h3 class="form-signin-heading form-group col-sm-8">Please Sign	Up Here - Action Name path :
				${pageContext.request.contextPath}${actionUri}</h3>
			<div class="form-group col-sm-8">
				<label for="inputEmail" class="sr-only">Email address</label>
				<form:input path="name" type="email" id="inputEmail"
					class="form-control" placeholder="Email address" required="true" />
			</div>

			<div class="form-group col-sm-8">
				<label for="inputPassword" class="sr-only">Password</label>
				<form:input path="password" type="password" id="inputPassword"
					class="form-control" placeholder="Password"
					required="true" />
			</div>

		<div class="form-group col-sm-8">
			<div class="radio">
				<label><form:radiobutton path="sex" id="maleId"	value="M" checked="true" />Male</label>
			</div>
			<div class="radio">
				<label><form:radiobutton path="sex" id="femaleId" value="F" />Female</label>
			</div>
			<div class="radio">
				<label><form:radiobutton path="sex" id="transGenderId"	value="T" />TransGender</label>
			</div>
		</div>

	<div class="form-group col-sm-8">
			 <label for="country">Select Country</label>
			 <form:select path="skill" class="form-control">
			  		<form:option value="-1" label="Please Select Country"  selected="selected"/>
					<form:options items="${country}" />
			</form:select>

		</div>


		<div class="form-group col-sm-8">
			 <label for="skills">Select Skill</label>
			 <form:select path="skill" class="form-control">
			  		<form:option value="-1" label="Please Select Skill"  selected="selected"/>
					<form:options items="${loginDetails.skills}" />
			</form:select>

		</div>

		<div class="form-group col-sm-8">
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
			</div>
			<div class="form-group col-sm-8">
				<button class="btn btn-primary" type="submit">Sign Up</button>
				<button class="btn btn-primary" type="submit">Reset</button>
				<button class="btn btn-danger" type="submit">Cancel</button>
			</div>

		</form:form>
		<div class="row">
			<div class="text-justify col-sm-6">
				<h3>Spring MVC</h3>
				<p>The Spring Framework is an application framework and
					inversion of control container for the Java platform. The
					framework's core features can be used by any Java application, but
					there are extensions for building web applications on top of the
					Java EE platform. Although the framework does not impose any
					specific programming model</p>
			</div>
			<div class="text-justify col-sm-6">
				<h3>Hibernate</h3>
				<p>Hibernate ORM (Hibernate in short) is an object-relational
					mapping framework for the Java language. It provides a framework
					for mapping an object-oriented domain model to a relational
					database. Hibernate solves object-relational impedance mismatch
					problems by replacing direct, persistent database accesses with
					high-level object handling functions.</p>
			</div>
			<div class="text-justify col-sm-6">
				<h3>Bootstrap</h3>
				<p>Bootstrap is a free and open-source front-end library for
					creating websites and web applications. It contains HTML- and
					CSS-based design templates for typography, forms, buttons,
					navigation and other interface components, as well as optional
					JavaScript extensions. It aims to ease the development of dynamic
					websites and web applications</p>
			</div>
		</div>

	</div>
	<!-- /container -->
</body>
</html>