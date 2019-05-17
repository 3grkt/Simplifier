<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><spring:message
					code="application.name" /></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false""><spring:message code="menu.manage" /><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:manageRooms()"><spring:message
										code="menu.manage.room" /></a></li>
							<li><a href="javascript:manageMembers()"><spring:message
							code="menu.manage.member" /></a></li>
						</ul>					
					</li>					
				</sec:authorize>

				
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><spring:message code="menu.room" />
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
						
							<li><a href="javascript:loadRooms()"><spring:message
										code="menu.room.view" /></a></li>
								
							<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_AMIN','ROLE_SUPERVISOR')">
							<li><a href="javascript:loadRoomBooking()"><spring:message
							code="menu.room.booking" /></a></li>
							</sec:authorize>		
							<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERVISOR')">
							<li><a href="javascript:loadApproveBooking()"><spring:message
										code="menu.room.approve" /></a></li>
							</sec:authorize>
						</ul></li>				
	
			</ul>
			<sec:authorize access="isAuthenticated()" var="isAuthenticated" />
			<c:if test="${not isAuthenticated}">
  			<!-- do stuff -->
  						<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:login()"><span
						class="glyphicon glyphicon-log-in"></span> <spring:message
							code="login.label" /></a></li>
				<li><a href="<spring:url value='/register' />" > Register</a></li>
			</ul>
			</c:if>
			<spring:url var="logoutUrl" value='/logout' />
			
<%-- 			<sec:authorize access="isAnonymous()">
			
			</sec:authorize> --%>
			<sec:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<spring:url value='/logout' />"><span
						class="glyphicon glyphicon-log-out"></span> <spring:message
							code="logout.label" /></a></li>
			</ul>
			</sec:authorize>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>