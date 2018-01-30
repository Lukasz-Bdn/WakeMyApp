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
				<h1>All registered users:</h1>

				<table class="table table-bordered">
					<thead>
						<tr class="table-light">
							<th scope="col">Email</th>
							<th scope="col">Enabled</th>
							<th scope="col">User role</th>
							<th scope="col">Websites</th>
							<th scope="col">Menu</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr class="table-light">
								<td><c:out value="${user.email}" /></td>
								<td><c:out value="${user.enabled}" /></td>
								<td><c:out value="${user.userRole}" /></td>
								<td><c:out value="${user.numWebsites}" /></td>

								<td>
									<div class="dropdown">
										<button class="btn btn-primary dropdown-toggle" type="button"
											data-toggle="dropdown">
											Menu<span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a
												href="${pageContext.request.contextPath}/user/toggleenable/${user.id}">Enable/disable</a></li>
										</ul>
									</div>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<%@include file="../jspf/rightnav.jspf"%>
		</div>
	</div>

	<%@include file="../jspf/footer.jspf"%>
</body>
</html>
