<!DOCTYPE HTML>
<html>
<head>
<meta charset = "utf-8">
<?php
include 'connectdb.php';
?>
<title> Teaching Assistant Database</title>
<h1> Welcome to the database </h1>
<body>
<h2>Login</h2>
<form action ="GradSecretary.php" method="post">
<label>User Name: </label><br>
<input type = "text" name = "user"><br>
<label>Password: </label> <br>
<input type = "text" name = "pass"></br>
<input type = "submit" value = "Login">
</form>
<a href="http://ec2-54-173-47-203.compute-1.amazonaws.com/assign4/Professor.php">Professor?</a>
</body>
</html>

