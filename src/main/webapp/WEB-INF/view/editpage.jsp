<html>

<head>
<title>Edit Screen</title>
</head>

<body>
<form class="form-horizontal" method="POST" action="save-activity">

    Activity Name: <input type="text" name="activityName" value="${acName}">
    <br><br>
  	Activity By: <input type="text" name="activityBy" value="${acBy}">
    <br><br>
    Activity Status: <input type="text" name="activityStatus" value="${acStatus}">
    <br><br>
						<input type="submit" class="btn btn-primary" value="Save" />
				</form>
</body>

</html>