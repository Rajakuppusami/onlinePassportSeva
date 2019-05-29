<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<title>Insert title here</title>
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
						<li class="nav-item"><a class="nav-link active" href="home">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">About</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Contact</a>
						</li>
						<!-- <li class="nav-item">
		            <a class="nav-link" href="services.html">Services</a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="contact.html">Contact</a>
		          </li> -->
		         <!-- <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		              Portfolio
		            </a>
		            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
		              <a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
		              <a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
		              <a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>
		              <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
		              <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
		            </div>
		          </li> -->
		          <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		              Profile
		            </a>
		            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		              <a class="dropdown-item" href="editprofile">Edit</a>
		              <a class="dropdown-item" href="logout">Logout</a>
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
		<div class="accordion mt-5" id="accordionExample">
		  <div class="card">
		    <div class="card-header" id="headingOne">
		      <h2 class="mb-0">
		        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		          Reschedule Appointment
		        </button>
		      </h2>
		    </div>
		
		    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
		      <div class="card-body">
		        <form action="" method="post">
		        	<div class="form-group">
					    <label for="username">Username</label>
					    <input type="text" class="form-control" id="username" placeholder="name@example.com" value="" readonly >
					</div>
		        	<div class="form-group">
					    <label for="emailid">Email Id</label>
					    <input type="email" class="form-control" id="emailid" placeholder="name@example.com" value="" readonly >
					</div>
					<div class="form-group">
					    <label for="applicantionid">Application Id</label>
					    <input type="text" class="form-control" id="applicantionid" placeholder="" value="" readonly >
					</div>
					<div class="form-group">
					    <label for="reason">Reason</label>
					    <textarea class="form-control" id="reason"></textarea>
					</div>
					<div class="custom-control custom-checkbox">
					  <input type="checkbox" class="custom-control-input" id="customCheck1">
					  <label class="custom-control-label" for="customCheck1">I Agree</label>
					</div>
					<br>
					<button class="btn btn-primary" type="submit">Submit form</button>
		        </form>
		      </div>
		    </div>
		  </div>
		  <div class="card">
		    <div class="card-header" id="headingTwo">
		      <h2 class="mb-0">
		        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		         	Cancell Appointment
		        </button>
		      </h2>
		    </div>
		    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
		      <div class="card-body">
		        <form>
		        	<div class="form-group">
					    <label for="username">Username</label>
					    <input type="text" class="form-control" id="username" placeholder="name@example.com" value="">
					</div>
		        	<div class="form-group">
					    <label for="emailid">Email Id</label>
					    <input type="email" class="form-control" id="emailid" placeholder="name@example.com" value="">
					</div>
					<div class="form-group">
					    <label for="applicantionid">Applicant Id</label>
					    <input type="text" class="form-control" id="applicantionid" placeholder="" value="">
					</div>
					<div class="form-group">
					    <label for="reason">Reason</label>
					    <textarea class="form-control" id="reason"></textarea>
					</div>
					<div class="custom-control custom-checkbox">
					  <input type="checkbox" class="custom-control-input" id="customCheck1">
					  <label class="custom-control-label" for="customCheck1">I Agree</label>
					</div>
					<br>
					<button class="btn btn-primary" type="submit">Submit form</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>