<!DOCTYPE html>
<html>
<body>
<?php
$username = "admin";
$password = "janice";
if($_POST["user"] == $username && $_POST["pass"] == $password)
{?>
<h1> Welcome to the Database </h1><br>
<?php
include 'connectdb.php';
?>
<h2> What would you like to do?  </h2>
<hr>
<u><i><h3>Teaching Assistant<h3></i></u>
<style>
 .boxed{
	border: 1px solid green;
	padding: 1em;
	width: 1024px;
	float: center;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
 }
 body{
	text-align: center;
 }
</style>
<div class ="boxed">
<?php
include 'AddTa.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'UpdateTa.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'DeleteTa.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'AssignTA.php';
?>
</div>
<br><br><hr>
<u><i><h3>Professor</h3></i></u>
<div class ="boxed">
<?php
include 'AddProfessor.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'DeleteProfessor.php';
?>
</div>
<br><br><hr>
<u><i><h3>Courses<h3></i></u>
<div class ="boxed">
<?php
include 'AddCourse.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'DeleteCourse.php';
?>
</div>
<br>
<div class ="boxed">
<?php
include 'AssignCourse.php';
?>
</div><br>




<?php
}
else{
?>
<h1> Error, you have entered the wrong username or password </h1>
<?php } ?>


</body>
</html>
