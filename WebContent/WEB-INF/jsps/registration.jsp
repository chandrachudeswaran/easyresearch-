<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy Research - Registration</title>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body
	style="background-image: url('${pageContext.request.contextPath}/static/img/home-bg.jpg')">
	<div class="row">
		<div class="col-md-4 col-md-offset-7">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-info-sign"></span> Registration
				</div>
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/doRegistration" name='f' method="post" class="form-horizontal" role="form" >
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">Username</label>
							<div class="col-sm-9">
								<input type="text" name="username" 
									class="form-control" id="inputEmail3" placeholder="Username">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<input type="password" name='password' class="form-control" id="inputPassword3" placeholder="Password" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Confirm Password</label>
							<div class="col-sm-9">
								<input type="password" name='Confirmpassword' class="form-control" id="inputPassword3" placeholder="Confirm Password" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<input type="text" name='email' class="form-control" id="inputPassword3" placeholder="Email" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">City</label>
							<div class="col-sm-9">
								<input type="text" name='city' class="form-control" id="inputPassword3" placeholder="City" required>
							</div>
						</div>
								<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Country</label>
							<div class="col-sm-9">
								<input type="text" name='country' class="form-control" id="inputPassword3" placeholder="Country" required>
							</div>
						</div>
						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm">Register</button>
							</div>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	
</body>
