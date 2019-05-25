<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendor/daterangepicker/daterangepicker.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendor/datepicker/css/jquery-uiv1.12.1.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
</head>
<body style="background-image: url(resources/images/bg-02.jpg);">
<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="home">Passport Seva</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="home">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">About</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a>
				</li>
				<li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		              Profile
		            </a>
		            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		              <a class="dropdown-item" href="editprofile">Edit</a>
		              <a class="dropdown-item" href="logout">Logout</a>
		            </div>
		        </li>
			</ul>
		</div>
	</div>
	</nav>

	<form action="eform" method="post" class="needs-validation" novalidate>
		<div class="container" style ="margin-top: 70px;">
			<div class="row m-3" >
				<div class="col-sm-3"></div>
				<div class="col-sm-6 card" style="padding:20px;">
					<h3>
						<center>E-Application Form</center>
					</h3>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label> First Name </label> <input type="text" name="name"
								class="form-control" placeholder="First name"
								value="${qualifiedapplicants.name}" required>
							<div class="invalid-feedback">Please provide a name.</div>
						</div>
						<div class="form-group col-md-6">
							<label> Surname </label> <input type="text" name="surName"
								class="form-control" placeholder="Last name"
								value="${qualifiedapplicants.surName}" required>
							<div class="invalid-feedback">Please provide a surname.</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label> Email id </label> <input type="text" name="emailId"
								class="form-control" placeholder="Email ID"
								value="${qualifiedapplicants.emailId}" required>
							<div class="invalid-feedback">Please provide a unique and
								valid emailId.</div>
						</div>
						<div class="form-group col-md-6">
							<label> Mobile Number </label> <input type="text"
								name="mobileNumber" class="form-control"
								placeholder="Mobile Number"
								value="${qualifiedapplicants.mobileNumber}" required>
							<div class="invalid-feedback">Please provide a unique and
								valid Mobile Number.</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label> Place of Birth </label> <input type="text"
								name="placeOfBirth" class="form-control"
								placeholder="Place of Birth"
								value="${qualifiedapplicants.placeOfBirth}" required>
							<div class="invalid-feedback">Please provide a date.</div>
						</div>
						<div class="form-group col-md-6">
							<label> Date of Birth </label> <input type="text"
								name="dateOfBirth" class="form-control " id="datepicker"
								placeholder="Date of Birth" value="${dateOfBirth}" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" required>
							<div class="invalid-feedback">Please provide a place.</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label> Father's Name </label> <input type="text"
								name="fatherName" class="form-control"
								placeholder="Father's Name"
								value="${qualifiedapplicants.fatherName}" required>
							<div class="invalid-feedback">Please provide a name.</div>
						</div>
						<div class="form-group col-md-6">
							<label> Mother's Name </label> <input type="text"
								class="form-control" placeholder="Mother's Name" required>
							<div class="invalid-feedback">Please provide a name.</div>
						</div>
					</div>
					<div class="form-group">
						<label> Aadhar Number </label> <input type="text"
							name="aadharNumber" class="form-control"
							placeholder="Aadhar Number" maxlength="11"  value="${qualifiedapplicants.aadharNumber}" required>
						<div class="invalid-feedback">Please provide a Aadhar
							Number.</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-2">Gender</div>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${ qualifiedapplicants.gender == 'F'}">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender1" value="F" checked="checked"> <label
											class="form-check-label" for="Gender1"> Female </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender2" value="M"> <label
											class="form-check-label" for="Gender2"> Male </label>
									</div>
								</c:when>
								<c:when test="${ qualifiedapplicants.gender == 'M'}">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender1" value="F" > <label
											class="form-check-label" for="Gender1"> Female </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender2" value="M" checked="checked"> <label
											class="form-check-label" for="Gender2"> Male </label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender1" value="F" > <label
											class="form-check-label" for="Gender1"> Female </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gender"
											id="Gender2" value="M"> <label
											class="form-check-label" for="Gender2"> Male </label>
									</div>
								</c:otherwise>
							</c:choose>
							<!-- <div class="form-check">
								<input class="form-check-input" type="radio" name="gender"
									id="Gender1" value="F"> <label
									class="form-check-label" for="Gender1"> Female </label>
							</div> -->
							<!-- <div class="form-check">
								<input class="form-check-input" type="radio" name="gender"
									id="Gender2" value="M"> <label
									class="form-check-label" for="Gender2"> Male </label>
							</div> -->
						</div>
					</div>
					<div class="form-group row">
						<div class="col">
							<h3>Declaration</h3>
							I owe allegiance to the sovereignty , unity &amp; integrity of
							India, and have not voluntarily acquired citizenship or travel
							document of any other country. I am aware that under the Passport
							Act, 1967 it is a criminal offence to furnish any false
							information or to suppress any material information with a view
							to obtaining passport or travel document.
						</div>
					</div>

					<div class="">
						<input class="" type="checkbox" name="declaration"
							id="declaration" value="true" checked="checked"> <label
							class="form-check-label" for="declaration"  > I Agree </label>
					</div>
					<input type="hidden" name="operation" value="${operation}" >
					<input class="btn btn-primary" type="submit" value="${buttonvalue}">
					<center><input class="btn btn-primary ${resetcss}" type="reset" value="Reset" ></center>
					<center><a href="home" class="${homecss}">exit</a></center>
					<div class="${errorcss}" role="alert">${errormessage}</div>
				</div>
			</div>
		</div>
	</form>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/animsition/js/animsition.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/popper.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/select2/select2.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/daterangepicker/moment.min.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/daterangepicker/daterangepicker.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/countdowntime/countdowntime.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/resources/vendor/datepicker/js/jquery-1.12.4.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/datepicker/js/jquery-ui.js" />"></script>
	<!--===============================================================================================-->
	<script>
	(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
	$( "#datepicker" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      //showOn: "button",
	      //buttonImage: "resources/images/calendar.gif",
	      //buttonImageOnly: true,
	      buttonText: "Select date",
	      dateFormat: "dd-mm-yy",
	      showAnim: "slideDown"
	    });	
	</script>
</body>
</html>