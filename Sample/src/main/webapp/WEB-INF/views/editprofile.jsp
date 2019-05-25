<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css"/>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css" >
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/css-hamburgers/hamburgers.min.css" >
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/datepicker/css/jquery-uiv1.12.1.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="resources/css/util.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<!--===============================================================================================-->
<style type="text/css">
body{
	background-color: #ebeeef;
}
</style>
</head>
<body>

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
<div class="limiter" style="margin-top: 70px!important;">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title"
					style="background-image: url("resources/images/passport.png");">
					<span class="login100-form-title-1"> REGISTRATION FORM </span>
				</div>

				<form class="login100-form validate-form" action="editprofile" method="post" >
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Firstname is required">
						<span class="label-input100">First Name</span> <input
							class="input100" type="text" name="name"
							placeholder="Enter firstname" value="${applicant.name}"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Surname is required">
						<span class="label-input100">Surname</span> <input
							class="input100" type="text" name="surname"
							placeholder="Enter surname" value="${applicant.surname}"> <span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="DOB is required">
						<span class="label-input100">DOB</span>
						<p>
							<input type="text" id="datepicker" size="30" name="dateOfBirth" value="${dob}">
						</p>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="EMAILID is required">
						<span class="label-input100">EMAILID</span> <input
							class="input100" type="text" name="emailId"
							placeholder="Enter EMAILID" value="${applicant.emailId}"> <span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Mobile Number is required">
						<span class="label-input100">Mobile Number</span> <input
							class="input100" type="text" name="Mobile_number"
							placeholder="Enter Mobile Number" value=""> <span
							class="focus-input100"></span>
					</div>
					<!-- <div class="wrap-input100 validate-input m-b-26"
						data-validate="Login is required">
						<span class="label-input100">LOGIN ID</span> <input
							class="input100" type="text" name="applicantId"
							placeholder="Enter Login Id"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-18"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" name="password"
							placeholder="Enter password"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-18"
						data-validate="Password is required">
						<span class="label-input100">Confirm Password</span> <input
							class="input100" type="password" name="pass"
							placeholder="Confirm password"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<span class="label-input100" >Hint Question</span> <select
							class="form-control" id="sel1" name="hintQuestion">
							<option >Select..</option>
							<option value="Who is your childhood friend?">Who is your childhood friend?</option>
							<option value="Who is your favourite hero?">Who is your favourite hero?</option>
							<option value="What is your pet's name?">What is your pet's name?</option>
						</select>
					</div>
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Answer is required">
						<span class="label-input100">Hint Answer</span> <input
							class="input100" type="text" name="hintAnswer"
							placeholder="Enter Hint Answer"> <span
							class="focus-input100"></span>
					</div> -->
					
					<!--<div class="dropdown">
  					<button onclick="myFunction()" class="dropbtn">Dropdown</button>
  					<div id="myDropdown" class="dropdown-content">
    					<a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div
</div>>-->



					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Save Changes</button>
						<a href="home" class="btn btn-link">exit</a>
					</div>
					<%-- <div class="${errorcss}" role="alert">${errormessage}</div> --%>
				</form>
			</div>
		</div>
	</div>

<!--===============================================================================================-->
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/bootstrap/js/popper.js" ></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/vendor/daterangepicker/daterangepicker.js" ></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/countdowntime/countdowntime.js" ></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/datepicker/js/jquery-1.12.4.js" ></script>
	<script src="resources/vendor/datepicker/js/jquery-ui.js"></script>
	<!--===============================================================================================-->
	<script src="resources/js/main.js"></script>
</body>
</html>