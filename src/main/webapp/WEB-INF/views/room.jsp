 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Room</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>One of our Room</h1>
				
			</div>
   			
 							<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
 				<a href="<spring:url value="/members/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>	
 				<br>
 		</div>
	</section>

	<section class="container">
		<div class="row">
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h3><spring:message	code="room.number" /> - ${room.roomNumber}</h3>
							<h3><spring:message	code="room.type" /> -  ${room.roomType.description}</h3>
							<p><spring:message 	code="room.description" /> -         ${room.description}</p>
							<p><spring:message	code="room.price" /> -       ${room.price} </p>
							<p><spring:message	code="room.capacity" /> -      ${room.capacity} </p>
							<p><spring:message	code="room.beds" /> -      ${room.numBed} </p>
							

						</div>
					</div>
				</div>
 
		</div>
	</section>
</body>
</html>
