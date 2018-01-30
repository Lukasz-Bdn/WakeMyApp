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
				<h1>Add new website:</h1>

				<form:form method="post" modelAttribute="website">
					<div class="form-group">
						Name (any name by which you can identify your website):
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						Http address (needs to be full http or https address, example:
						https://www.google.com):
						<form:input path="stringUrl" cssClass="form-control" />
						<form:errors path="stringUrl" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						Select day range: 

						<form:checkboxes items="${website.days}" path="daysKeepAwake" />
						<form:errors path="daysKeepAwake" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						Current server time is
						<c:out value="${currentTime}" />
						, please select hours accordingly:
					</div>

					<div class="form-group">
							<form:select type="text" path="startHour" cssClass="form-control">
								<form:options items="${website.hours}" />
							</form:select>
							-
							<form:select type="text" path="stopHour" cssClass="form-control">
								<form:options items="${website.hours}" />
							</form:select>
							<form:errors path="startHour" cssClass="text-danger"/>
					</div>
					<input type="submit" class="btn btn-primary"
						value="Add new website">
				</form:form>
				<br />

			</div>
		</div>
	</div>
	<%@include file="../jspf/footer.jspf"%>
</body>
</html>