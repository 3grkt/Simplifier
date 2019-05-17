<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Rooms</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Our Rooms</h1>
				<p>All of the rooms in our hotels</p>
 			
 				<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
			</div>
 					<a href="<spring:url value="/rooms/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>	
 			
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${rooms}" var="room">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h4>Room number - ${room.roomNumber}</h4>
							<h4>Number bed -  ${room.numBed}</h4>
							<h4>Description - ${room.description}</h4>
							<h4>Price - ${room.price}</h4>
 						 <a href="<spring:url value="/rooms/${room.id}" />" class="btn btn-primary  btn-mini  ">View</a>
						 <a href="<spring:url value="/rooms/${room.id}/delete" />" class="btn btn-primary  btn-mini  ">Delete</a>
						 <a href="<spring:url value="/rooms/${room.id}/update" />" class="btn btn-primary  btn-mini  ">Update</a>
 				</h4>
 					</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
