<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="images/favicon.ico">

<title>Home page</title>

<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="layout/header.jsp" />

	<c:url value="/logout" var="logoutUrl" />


	<!-- body goes here -->
	<div class="container" id="content">
				<h1>Hello ${greeting} </h1>
				<p> ${tagline} </p>
  					Welcome  ${member.firstName} !
 
			</div>	 

	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>

	<script>
	var login = function() {
		$.ajax({
			type : "GET",
			url : "/Simplifier/login",
			success : function(data) {
				$('#content').html(data);
			},

			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
		var loadRooms = function() {
			$.ajax({
				type : "GET",
				url : "/simplifier/rooms",
				success : function(data) {
					$('#content').html(data);
				},

				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
		var loadMembers = function(){
			$.ajax({
				type : "GET",
				url : "/simplifier/members",
				success : function(data){
					$('#content').html(data);
				},
				error : function(e){
					alert('Error: ' + e);
				}
			});
		}
		var loadRoomBooking = function(){
			$.ajax({
				type : "GET",
				url : "/simplifier/roombooking",
				success : function(data){
					$('#content').html(data);
				},
				error : function(e){
					alert('Error: ' + e);
				}
			});
		}
		var loadApproveBooking = function() {
			$.ajax({
				type : "GET",
				url : "/simplifier/approvebooking",
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