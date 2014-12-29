<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Professor-Teaching-Assistant Database - View Courses by Teaching Assistant</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<h1>Welcome to the Western Database</h1>
<form action="gettadata.php" method="post">
<?php
   include 'getta.php';
?>
<input type="submit" value="Get Professor Name">
</form>
<?php
mysqli_close($connection);
?>
</body>
</html>

