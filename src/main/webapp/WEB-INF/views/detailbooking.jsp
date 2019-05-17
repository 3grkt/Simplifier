<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Booking</title>
</head>
<body>
	<section>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Booking</h3>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>Booking Date</th>
						<th>Client Name</th>
						<th>Check-in Date</th>
						<th>Check-out Date</th>
						<th></th><th></th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td>${booking.bookingDate}</td>
							<td>${booking.getUser().getFirstName()} ${booking.getUser().getLastName()}</td>
							<td>${booking.checkinDate}</td>
							<td>${booking.checkoutDate}</td>
							<td><a href=" <spring:url value="/bookings/detailbooking?id=${booking.id}&approve=true" /> "
									class="btn btn-primary"> Approve
								</a>
							</td>
							<td><a href=" <spring:url value="/bookings/detailbooking?id=${booking.id}&approve=false" /> "
									class="btn btn-warning"> Reject
								</a>
							</td>
						</tr>
				</tbody>
			</table>
		</div>
		<!-- 		Room booking -->
<!-- 		Booking list -->
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">Room booking request</h3>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Room Number</th>
						<th>Room Type</th>
						<th>Capacity</th>
						<th># beds</th>
						<th>Price</th>
						<th>Desc</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty booking.rooms}">
					<c:forEach items="${booking.rooms}" var="room" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td>${room.roomNumber}</td>
							<td>${room.getRoomType().getDescription()}</td>
							<td>${room.capacity}</td>
							<td>${room.numBed}</td>
							<td>${room.price}</td>
							<td>${room.description}</td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>

	</section>


</body>
</html>
