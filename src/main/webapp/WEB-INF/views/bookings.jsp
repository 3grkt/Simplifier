<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Bookings</title>
</head>
<body>
	<section>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Pending Bookings</h3>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Booking Date</th>
						<th>Check-in Date</th>
						<th>Check-out Date</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookings}" var="booking" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td>${booking.bookingDate}</td>
							<td>${booking.checkinDate}</td>
							<td>${booking.checkoutDate}</td>
							<td><a href="javascript:loadDetailBooking(${booking.id})" class="btn btn-primary"> Detail
								</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>


	</section>

	<script>

		var loadDetailBooking = function(bookingID) {
			$.ajax({
				type : "GET",
				url : "/Simplifier/bookings/detailbooking?id=" + bookingID,
				success : function(data) {
					$('#content').html(data);
				},

				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		
	</script>
</body>
</html>
