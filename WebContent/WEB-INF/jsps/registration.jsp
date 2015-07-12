<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy Research - Registration</title>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/registration.css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	function onLoad() {

		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);
		$("#details").submit(canSubmit);
	}
	
	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		
		if(password != confirmpass) {
			alert("Passwords do not match!")
			return false;
		}
		else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password'/>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnMatchedPasswords.user.password'/>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>
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
					<sf:form
						name='f' method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/doRegistration" id="details" commandName="users">
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">Username</label>
							<div class="col-sm-9">
								<sf:input type="text" name="username" class="form-control"
									id="user_name" placeholder="Username" path="username" /> <sf:errors path="username" cssClass="formerror"></sf:errors>
							</div>
						</div>
							<div class= "divclass">
						<label id ="vaildateUser" class="error"></label></div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<sf:input type="password" name='password' class="form-control"
									id="password" placeholder="Password" path="password" /><sf:errors path="password" cssClass="formerror"></sf:errors> 
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Confirm
								Password</label>
							<div class="col-sm-9">
								<input type="password" name='Confirmpassword'
									class="form-control" id="confirmpass"
									placeholder="Confirm Password">
							</div>
							<div class= "divclass" id="matchpass"></div></td>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<sf:input type="text" name='email' class="form-control"
									id="inputPassword3" placeholder="Email" path="email" /><sf:errors path="email" cssClass="formerror"></sf:errors>
							</div>
						</div>
						
							<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">City</label>
							<div class="col-sm-9">
								<sf:input type="text" name='city' class="form-control"
									id="inputPassword3" placeholder="City" path="city" /> <sf:errors path="city" cssClass="formerror"></sf:errors>
							</div>
						</div>
							<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Country</label>
							<div class="col-sm-9">
								<sf:input type="text" name='country' class="form-control"
									id="inputPassword3" placeholder="Country" path="country" /><sf:errors path="country" cssClass="formerror"></sf:errors>
							</div>
						</div>
				
						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm">Register</button>
							</div>
						</div>
					</sf:form>
				</div>

			</div>
		</div>
	</div>

</body>