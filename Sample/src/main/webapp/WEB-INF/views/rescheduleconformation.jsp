<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PASSPORT|Reschedule</title>
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<form action="rescheduleconform" method="post">
	<div class="container">
		<div class="row m-3">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<span class="float-left"></span> <span class="float-right"><strong>Status:</strong>
							Pending</span>
					</div>
					<div class="card-body">
						<h5 class="card-title">
							<center>
								<strong>Reschedule conformation</strong>
							</center>
						</h5>

						<div class="row">
							<div class="col">Applicant Id </div>
							<div class="col">:${applicantid}</div>
						</div>
						<div class="row">
							<div class="col">Application Id </div>
							<div class="col">:${applicationid}</div>
						</div>
						<div class="row">
							<div class="col">Name </div>
							<div class="col">:${name}</div>
						</div>
						<!-- <div class="row">
							<div class="col">Total Fees </div>
							<div class="col">:1500.rs</div>
						</div> -->
						<div class="row">
							<div class="col">Scheduled Appointment Date </div>
							<div class="col">:${date}</div>
							<input type="hidden" name="date" value="${date}">
						</div>
						<div class="row">
							<div class="col">Scheduled Appointment Time </div>
							<div class="col">:${time}</div>
							<input type="hidden" name="time" value="${time}">
						</div>
						<div class="row">
							<div class="col">Passport Office</div>
							<div class="col">:${passportoffice}</div>
							<input type="hidden" name="passportOffice" value="${passportoffice}">
						</div>
						<br>
						<center><button type="submit" class="btn btn-primary">Pay</button></center>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="attempts" value="1">
	<input type="hidden" name="reshedule" value="true">
	<input type="hidden" name="paymentStatus" value="true">
	<input type="hidden" name="cancellationStatus" value="false">
	<input type="hidden" name="applicationId" value="${applicationid}">
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
</body>
</html>