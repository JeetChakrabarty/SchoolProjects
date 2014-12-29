<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Add Course</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$coursename = $_POST["cname"];
$cno = $_POST["cno"];

$query = 'insert into COURSE values("' . $cno . '","' . $cname . '")';

if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{

echo "Course added";
}
?>
</body>
</html>
