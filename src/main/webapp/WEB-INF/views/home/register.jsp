<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../jspf/includes.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../jspf/headconfig.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
	<%@ include file="../jspf/navbar.jspf"%>
	<div class="container-fluid text-center">
		<div class="row content">
			<%@include file="../jspf/leftnav.jspf"%>
			<div class="col-sm-8 text-left">
				<h3>Please provide information for new user:</h3>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>

				<form:form method="post" modelAttribute="user" cssClass="form-horizontal">

					<div class="form-group">
						<div>Email:</div>
						<div class="col-xs-4">
							<form:input path="email" cssClass="form-control" />
							<form:errors path="email" />
						</div>
					</div>
					<div class="form-group">
						<div>Password:</div>
						<div class="col-xs-4">
							<form:password path="password" cssClass="form-control" />
							<form:errors path="password" />
						</div>
					</div>
					<div class="form-group">
						<div>Confirm password:</div>
						<div class="col-xs-4">
							<form:password path="confirmPassword" cssClass="form-control" />
							<form:errors path="confirmPassword" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary"
							value="Register new user">
					</div>
				</form:form>
				<br />
				<h3>
					<c:out value="${msg}"></c:out>
				</h3>
			</div>
		</div>
	</div>
	<%@ include file="../jspf/footer.jspf"%>
</body>
</html>