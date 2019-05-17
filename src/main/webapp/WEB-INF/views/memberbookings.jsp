<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Booking</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Booking Room</h1>
				<p>Add a new one<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newBooking" class="form-horizontal"  >
			<fieldset>
				<legend>Add new booking</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="checkinDate"> Check-in Date</label>
					<div class="col-lg-10">
						<form:input id="checkinDate" path="checkinDate" type="text" class="form:input-large"/>
						<form:errors path="checkinDate" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="checkoutDate"> Check-out Date</label>
					<div class="col-lg-10">
						<form:input id="checkoutDate" path="checkoutDate" type="text" class="form:input-large"/>
						<form:errors path="checkoutDate" cssClass="text-danger"/>
					</div>
				</div>
 
<%--  							<form:hidden path="userCredentials.enabled" value="TRUE"  /> --%>
 

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
						<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">Available Rooms</h3>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Room Number</th>
						<th>Description</th>
						<th>Room Type</th>
						<th>Capacity</th>
						<th># Beds</th>
						<th>Price</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rooms}" var="room" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td>${room.roomNumber}</td>
							<td>${room.description}</td>
							<td>${room.getRoomType().description}</td>
							<td>${room.capacity}</td>
							<td>${room.numBed}</td>
							<td>${room.price}</td>
							<td><input type="checkbox" name="roomid" value="${room.id}">
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
