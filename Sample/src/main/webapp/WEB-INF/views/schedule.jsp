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
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
	<div class="row m-3" style="margin-top: 70px!important;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<b>Check for Available Date:</b>
				</div>
				<div class="card-body">
					<form action="scheduleappointment" method="post">
					 <div class="form-group row">
					    <label for="passportoffice" class="col-sm-4 col-form-label">Passport Office</label>
						<div class="col-sm-8">
						<select name="passportoffice" id="passportoffice" class="form-control">
						<c:forEach var="passportoffice" items="${passportoffices}">
							<c:choose>
								<c:when test="${ passportofficevalue == passportoffice}">
									<option value="${passportoffice}" selected="selected">${passportoffice}</option>
								</c:when>
								<c:otherwise>
									<option value="${passportoffice}">${passportoffice}</option>
								</c:otherwise>
							</c:choose>
							<%-- <option value="${passportoffice}">${passportoffice}</option> --%>
						</c:forEach>
						</select>
						</div>
					  </div>
					  <div class="form-group row">
					    <label for="month" class="col-sm-4 col-form-label">Choose Month</label>
						<div class="col-sm-8">
						<select name="month" id="month" class="form-control">
						<c:forEach var="month" items="${months}">
							<c:choose>
								<c:when test="${ monthvalue == month }">
									<option value="${month}" selected="selected">${month}</option>
								</c:when>
								<c:otherwise>
									<option value="${month}">${month}</option>
								</c:otherwise>
							</c:choose>
							<%-- <option value="${month}">${month}</option> --%>
						</c:forEach>
						</select>
						</div>
					  </div>
						<input type="submit" class="btn btn-primary mb-2 float-right" value="check for availability">
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row m-3">
		<div class="col-sm-12">
			<center style="color:white;"><h2><strong>TIME SLOT</strong></h2></center>
			<div class="table-responsive">
				<table class="table">
					<%-- <caption>Time Slot</caption> --%>
					<thead class="thead-dark" style="background-color:black;color:white;">
					    <tr>
					      <th scope="col">Date</th>
					      <th scope="col">10:00 AM</th>
					      <th scope="col">11:00 AM</th>
					      <th scope="col">12:00 PM</th>
					      <th scope="col">01:00 PM</th>
					      <th scope="col">02:00 PM</th>
					      <th scope="col">03:00 PM</th>
					      <th scope="col">04:00 PM</th>
					    </tr>
					</thead>
					<tbody>
					    <c:forEach var="date" items="${tableData}">
					    <tr>
							<th style="background-color:black;color:white;" >${date.key}</th>
							<c:forEach var="time" items="${date.value}">
								<c:choose>
									<c:when test="${time.value == 'notAvailable'}">
										<td class="alert alert-danger" role="alert">
											${time.value}
										</td>
									</c:when>
									<c:otherwise>
							            <td class="alert alert-success" role="alert">
											${time.value}
											<br>
											<br>
											<form action="checkforconfirm" method="post">
												<input type="hidden" name="date" value="${date.key}">
												<input type="hidden" name="time" value="${time.key}">
												<input type="hidden" name="passportoffice" value="${passportofficevalue}">
												<input type="submit" class="btn btn-link ${oldSchedulerButtoncss}" value="confirm">
											</form>
										</td>
							        </c:otherwise>
								</c:choose>
								<%-- <td>
									${time.value}
									<br>
									<br>
									<form action="checkforconfirm" method="post">
										<input type="hidden" name="date" value="${date.key}">
										<input type="hidden" name="time" value="${time.key}">
										<input type="hidden" name="passportoffice" value="${passportofficevalue}">
										<input type="submit" class="btn btn-link" value="confirm">
									</form>
								</td> --%>
							</c:forEach>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Modal -->
<div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="alert alert-danger" role="alert">
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
	<!--===============================================================================================-->
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript">
		$('#exampleModalScrollable').modal($("#modelcss").val());
	</script>
</body>
</html>