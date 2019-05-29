<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home|Passport</title>
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%-- welcome to home ${username}
	<a href="e-form">E-Form </a>
	<a href="scheduleappointment">Schedule Appointment</a>
	<a href="checkavailablity">Check Appointment Availability Status</a>
	<a href=""></a> --%>
	<!-- Navigation -->
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

	<header>
	<img src="resources/images/passport-world-map-hero-1400x500.jpg" class="img-fluid" alt="Responsive image">
	</header>

	<!-- Page Content -->
	<div class="container">

		<center>
			<h1 class="my-4">Welcome to Online Passport Seva</h1>
		</center>

		<!-- Marketing Icons Section -->
		<div class="row">

			<div class="col-4 md-3 ">
				<div class="card h-100">
					<center>
						<h5 class="card-header">E-form Application</h5>
					</center>
					<div class="card-body">
						<img src="resources/images/appl.jpg" class="card-img-top">
						<p class="card-text"></p>
					</div>
					<div class="card-footer">
						<%-- <c:choose>
							
						</c:choose> --%>
						<a href="eform" class="btn btn-primary">Click here </a>
					</div>
				</div>
			</div>

			<div class="col-4  md-3">
				<div class="card h-100">
					<center>
						<h5 class="card-header">Scheduling</h5>
					</center>
					<div class="card-body">
						<img src="resources/images/sch.jpg" class="card-img-top">
						<p class="card-text"></p>
					</div>
					<div class="card-footer">
						<a href="scheduleappointment" class="btn btn-primary ${schedulebuttoncss}">Click here </a>
					</div>
				</div>
			</div>
			<div class="col-4 md-3">
				<div class="card h-100">
					<center>
						<h5 class="card-header">Documents Required</h5>
					</center>
					<div class="card-body">
						<img src="resources/images/images.jpeg" class="card-img-top">
						<p class="card-text"></p>
					</div>
					<div class="card-footer">
						<a href="document" target="_blank" class="btn btn-primary">Click here </a>
					</div>
				</div>
			</div>
		</div>

		<!-- /.row -->

		<!-- Portfolio Section -->
		<!--
    <h2>Portfolio Heading</h2>

    <div class="row">
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project One</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Two</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Three</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Four</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Five</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Six</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
          </div>
        </div>
      </div>
    </div>-->
		<!-- /.row -->
		<div class="row mt-3">
			<div class="col-6  md-3">
				<div class="card h-100">
					<center>
						<h5 class="card-header">View your Schedule</h5>
					</center>
					<div class="card-body">
						<div class="">
						  <div class="">
						    <ul class="list-group">
							  <li class="list-group-item"><div class="row"><div class="col-sm-3"><b>Application Id</b></div><div class="col-sm-9">:${applicationid}</div></div></li>
							  <li class="list-group-item"><div class="row"><div class="col-sm-3"><b>Passport Office</b></div><div class="col-sm-9">:${passportoffice}</div></div></li>
							  <li class="list-group-item"><div class="row"><div class="col-sm-3"><b>Scheduled Date</b></div><div class="col-sm-9">:${scheduleddate}</div></div></li>
							  <li class="list-group-item"><div class="row"><div class="col-sm-3"><b>Scheduled Time</b></div><div class="col-sm-9">:${scheduledtime}</div></div></li>
							  <li class="list-group-item"><div class="row"><div class="col-sm-3"><b>Payment Status</b></div><div class="col-sm-9">:${paymentstatus}</div></div></li>
							</ul>
						  </div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6  md-3">

				<div class="card h-100">
					<center>
						<h5 class="card-header">Rescheduling and Cancelling</h5>
					</center>
					<div class="card-body">
						<img src="resources/images/clock.jpeg" class="card-img-top">
						<p class="card-text"></p>
					</div>
					<div class="card-footer">
						<a href="resheduleandcancel" class="btn btn-primary">Click here </a>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		
		<!-- Features Section -->
		<br>
		<div class="row">
			<div class="col-lg-6">
				<h2>Modern Business Features</h2>
				<p>The Modern Business template by Start Bootstrap includes:</p>
				<ul>
					<li><strong>Bootstrap v4</strong></li>
					<li>jQuery</li>
					<li>Font Awesome</li>
					<li>Working contact form with validation</li>
					<li>Unstyled page elements for easy customization</li>
				</ul>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Corporis, omnis doloremque non cum id reprehenderit, quisquam totam
					aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis
					quia dolorum ducimus unde.</p>
			</div>
			<div class="col-lg-6">
				<img src="resources/images/Indian-passport.jpg" class="card-img-top">
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Call to Action Section -->
		<!--<div class="row mb-4">
      <div class="col-md-8">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
      </div>
      <div class="col-md-4">
        <a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
      </div>
    </div>-->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2019</p>
	</div>
	<!-- /.container --> </footer>
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<div class="alert alert-success" role="alert">
  			<h3 class="">${modelbodycontent}</h3>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	<input type="hidden" id="modelcss" value="${modelscript}">
	<!-- <input type="hidden" id="modelcss" value="show"> -->
	<!-- Bootstrap core JavaScript -->
	
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!--===============================================================================================-->
	<script src="resources/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript">
		$('#exampleModal').modal($("#modelcss").val());
	</script>
</body>
</html>