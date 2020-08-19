<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Brainstorming | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/homepage" class="navbar-brand">Subjects</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/register">Create Subject</a></li>
					<li><a href="/brainstorming">Brainstorming</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Available Subjects</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Activity Id</th>
								<th>Activity Name</th>
								<th>Activity By</th>
								<th>Status</th>
								<!-- 	<th>Delete</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="activity" items="${activitys }">
								<tr>
									<td>${activity.activityid}</td>
									<td>${activity.activityname}</td>
									<td>${activity.activityby}</td>
									<td>${activity.activitystatus}</td>
				

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>Create Subject</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-activity">
					<input type="hidden" name="id" value="${activity.activityid }" />
					<div class="form-group">
						<label class="control-label col-md-3">Activity Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activityname"
								value="${activity.activityname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Activity By</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activityby"
								value="${activity.activityby }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Activity Status</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activitystatus"
								value="${activity.activitystatus }" />
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Create" />
					</div>
				</form>
			</div>
		</c:when>


		<c:when test="${mode=='MODE_BRAINSTORMING' }">
			<div class="container text-center">
				<h3>START BRAINSTORMING</h3>
				<hr>
				<form class="form-horizontal" method="POST"
					action="start-brainstorming">


					<div class="form-group ">
						<input type="submit" class="btn btn-primary"
							value="Start Brainstorming" />
					</div>
				</form>
			</div>
		</c:when>





		<c:when test="${mode=='MODE_EDIT' }">
			<div class="container text-center">
				<h3>Create Subject</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-activity">
					<div class="form-group">
						<label class="control-label col-md-3">Activity Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activityName"
								value="${acName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Activity By</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activityBy"
								value="${acBy}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Activity Status</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="activityStatus"
								value="${acStatus}" />
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>


	</c:choose>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
