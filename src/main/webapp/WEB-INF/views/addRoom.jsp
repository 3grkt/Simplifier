<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Rooms</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Our rooms</h1>
				<p>Add a new one<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newRoom" class="form-horizontal"  >
			<fieldset>
				<legend>Add new room</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="roomNumber"><spring:message
							code="room.number" /></label>
					<div class="col-lg-10">
						<form:input id="roomNumber" path="roomNumber" type="text" class="form:input-large"/>
						<form:errors path="roomNumber" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message
							code="room.description" /></label>
					<div class="col-lg-10">
						<form:input id="description" path="description" type="text" class="form:input-large"/>
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="price"><spring:message
							code="room.price" /></label>
					<div class="col-lg-10">
						<form:input id="price" path="price" type="text" class="form:input-large"/>
						<form:errors path="price" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="roomType"><spring:message
							code="room.type" /></label>
					<div class="col-lg-10">

						<form:select id="roomType" path="roomType" >
						  <c:forEach items="${roomTypeList}" var="roomType">
    						<form:option value="${roomType}">${roomType.description}</form:option>
  							</c:forEach>
						<form:errors path="roomType" cssClass="text-danger"/>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="capacity"><spring:message
							code="room.capacity" /></label>
					<div class="col-lg-10">
						<form:input id="capacity" path="capacity" type="text" class="form:input-large"/>
						<form:errors path="capacity" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="numBed"><spring:message
							code="room.beds" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="numBed" path="numBed" type="text" class="form:input-large"/>
							<form:errors path="numBed" cssClass="text-danger"/>
						</div>
					</div>
				</div> 
				<form:hidden path="available" value="TRUE"  />
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
