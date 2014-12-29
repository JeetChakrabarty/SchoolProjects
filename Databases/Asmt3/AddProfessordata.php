<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Add Professor</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$firstname = $_POST["fname"];
$lastname = $_POST["lname"];
$wid = $_POST["WID"];

$query = 'insert into INSTRUCTOR values("' . $firstname . '","' . $lastname . '","' . $wid . '")';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{

echo "Professor was added";
}
?>
</body>
</html>

