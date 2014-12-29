<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Professor-Teaching-Assistant Database - Select T.A's by Professor</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<h1>Welcome to the Western Database</h1>
<form action="gettabyprofdata.php" method="post">
<?php
   include 'gettabyprof.php';
?>
<input type="submit" value="Get Professor Name">
</form>
<?php
mysqli_close($connection);
?>
</body>
</html>

