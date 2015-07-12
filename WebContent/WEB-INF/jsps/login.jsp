<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">



<body onload='document.f.j_username.focus();'
	style="background-image: url('${pageContext.request.contextPath}/static/img/home-bg.jpg')">
	<div class="row">
		<div class="col-md-4 col-md-offset-7">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-lock"></span> Login
				</div>
				<div class="panel-body">
					<form
						action='${pageContext.request.contextPath}/j_spring_security_check'
						name='f' method="post" class="form-horizontal" role="form">
						<div class="form-group">
							<c:if test="${param.error !=null}">

								<p class="error">Login Failed. Check Username and Password
									are correct.</p>

							</c:if>
							<label for="username" class="col-sm-3 control-label">
								Username</label>
							<div class="col-sm-9">
								<input type="username" name='j_username' value=''
									class="form-control" id="inputEmail3" placeholder="Username"
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">
								Password</label>
							<div class="col-sm-9">
								<input type="password" name='j_password' class="form-control"
									id="inputPassword3" placeholder="Password" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<div class="checkbox">
									<label> <input type="checkbox"
										name='_spring_security_remember_me' checked="checked" />
										Remember me
									</label>
								</div>
							</div>
						</div>
						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm">
									Sign in</button>

							</div>
						</div>
					</form>
				</div>
				<div class="panel-footer">
					Not Registred? <a
						href="${pageContext.request.contextPath}/registration">Register
						here</a>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
