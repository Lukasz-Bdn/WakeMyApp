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


				<h3>Login:</h3>
				<form:form method="post" cssClass="form-horizontal">
					<div class="form-group">

						<div class="col-xs-4">
							<label for="username">Email</label> <input type="text"
								id="username" name="username" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label for="password">Password</label> <input type="password"
								id="password" name="password" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<input type="hidden"
		name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-primary">Log in</button>
					</div>
				</form:form>


			</div>
		</div>
	</div>


	<%@ include file="../jspf/footer.jspf"%>
</body>
</html>