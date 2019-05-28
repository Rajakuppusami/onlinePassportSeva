<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
</head>
<body style="background-color: #e9ecef;">

<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="adminhome">Passport Seva</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link active" href="adminhome">Home</a>
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
              <!-- <a class="dropdown-item" href="editprofile">Edit</a> -->
              <a class="dropdown-item" href="adminlogout">Logout</a>
            </div>
          </li>
         <!--  <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Other Pages
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              
              
              
            </div>
          </li> -->
			</ul>
		</div>
	</div>
	</nav>
	
	<div class="jumbotron">
		 <h1 class="display-4">Payment History</h1>
		 <hr class="my-4">
		 <div class="table-responsive">
		 <table class="table table-striped table-bordered table-sm" id="dtBasicExample" cellspacing="0" width="100%">
			 <thead class="thead-dark">
	            <tr>
	            	<th>S.no</th>
	                <th>APPLICANT ID</th>
	                <th>APPLICATION ID</th>
	                <th>LOCATION</th>
	                <th>DATE (DD-MM-YYYY)</th>
	                <th>TIME (HH:SS)</th>
	                <th>PAYMENT STATUS</th>
	            </tr>
	       	</thead>
	       	<tbody>
	        	<c:forEach items="${scheduleList}" var="schedule" varStatus="loop">
	        		<tr>
	        			<th scope="row">${loop.index+1}</th>
	        			<td>${schedule.applicantId }</td>
	        			<td>${schedule.applicationId }</td>
	        			<td>${schedule.passportOffice }</td>
	        			<td>${sdf.format(schedule.scheduleDate)}</td>
	        			<td>${sdft.format(schedule.scheduleDateTime) }</td>
	        			<td>SUCCESS</td>
	        		</tr>
	        	</c:forEach>    
	        </tbody>
		</table>
		</div>
	</div>
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js "></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!--===============================================================================================-->
	<script src="resources/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
</body>
</html>