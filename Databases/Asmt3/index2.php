<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Professor-Teaching-Assistant Database - Select T.A's by Course</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<h1>Welcome to the Western Database</h1>
<form action="gettabycoursedata.php" method="post">
<?php
   include 'gettabycourse.php';
?>
<input type="submit" value="Get Course Name">
</form>
<?php
mysqli_close($connection);
?>
</body>
</html>


