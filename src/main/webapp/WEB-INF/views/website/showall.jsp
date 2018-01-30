<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../jspf/includes.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>WakeMyApp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../jspf/headconfig.jspf"%>
</head>
<body>
	<%@include file="../jspf/navbar.jspf"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<%@include file="../jspf/leftnav.jspf"%>
			<div class="col-sm-8 text-left">
				<h1>All websites:</h1>

				<table class="table table-bordered table-hover">
					<thead>
						<tr class="table-light">
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Days</th>
							<th scope="col">Hours</th>
							<th scope="col">Last ping</th>
							<th scope="col">Status</th>
							<th scope="col">User</th>
							<th scope="col">Menu</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${websites}" var="website">
							<tr class="table-light">
								<td><c:out value="${website.name}" /></td>
								<td><c:out value="${website.stringUrl}" /></td>
								<td><c:out value="${website.daysKeepAwake}" /></td>
								<td><c:out value="${website.startHour}" />-<c:out
										value="${website.stopHour}" /></td>
								<td><c:out value="${website.lastPingDate}" /></td>
								<td><c:out value="${website.lastPingStatus}" /></td>										
								<td><c:out value="${website.user.email}" /></td>
								<td>
									<div class="dropdown">
										<button class="btn btn-primary dropdown-toggle" type="button"
											data-toggle="dropdown">
											Menu<span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a
												href="${pageContext.request.contextPath}/website/edit/${website.id}">Edit</a></li>
											<li><a
												href="${pageContext.request.contextPath}/website/remove/${website.id}">Delete</a></li>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@include file="../jspf/footer.jspf"%>
</body>
</html>
