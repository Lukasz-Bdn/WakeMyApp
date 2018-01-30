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
				<h1>Your websites:</h1>

		<table class="table table-bordered">
			<thead>
				<tr class="table-light">
					<th scope="col">Name</th>
					<th scope="col">Address</th>
					<th scope="col">Days</th>
					<th scope="col">Hours</th>
					<th scope="col">Menu</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userWebsites}" var="website">
					<tr class="table-light">
						<td><c:out value="${website.name}" /></td>
						<td><c:out value="${website.stringUrl}" /></td>
						<td><c:out value="${website.daysKeepAwake}" /></td>
						<td><c:out value="${website.startHour}" />-<c:out value="${website.stopHour}" /></td>
						
						<td>
							<div class="btn-group">
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">Actions</button>
									<div class="dropdown-menu">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/website/remove/${website.id}">Remove</a> 
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/website/edit/${website.id}">Update</a>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

				<hr>
				<a href="${pageContext.request.contextPath}/website/add"><button >Add new website</button></a>
			</div>
			<%@include file="../jspf/rightnav.jspf"%>
		</div>
	</div>

	<%@include file="../jspf/footer.jspf"%>
</body>
</html>
