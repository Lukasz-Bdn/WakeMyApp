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
			<div class="col-sm-9 text-left">
				<h1>Welcome</h1>
				<p>I created this app to manage my Heroku applications awake time, but now it is open to use for everyone! 
				This tool will send a http 'GET' request to given website and will keep doing it every 20 minutes.
				You can specify days and hour range, when you want your websites to be pinged.</p>
				
				<p>For example: 
				
				<ul>
				<li>If you are job hunting and want your apps to always be ready for recruiters. you can keep them awake, 
				from Monday to Friday between 9 am and 6 pm.</li>
				<li>If you know you want to present an app to someone at given time, you can make sure it will be
				available at that time, without delay.</li>
				</ul>
				</p>
				<hr>
				<h3>How to use it in 3 simple steps:</h3>
				<ol>
					<li>Use the register button above and create new account. If you already have account log in.</li>
					<li>After logging in go to 'Your websites' menu.</li>
					<li>Click 'Add new website' button, provide address and time, when you want you application to be awake.</li>
					<li>Use the menu button to select 'Test ping now' option. 
						This will send 'GET' request to your web and return status.</li>
					<li>Status 200 means OK, if status of your response is different, check 
						<a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">Wikipedia</a> for explanation.</li>
				</ol>
			</div>
		</div>
	</div>

	<%@include file="../jspf/footer.jspf"%>
</body>
</html>
