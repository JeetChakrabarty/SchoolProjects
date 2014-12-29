<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Remove Course</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$cid = $_POST["cid"];
$query = 'delete from Course where courseNumber = "' . $cid . '"';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{
echo "Course  was deleted";
}
?>
</body>
</html>


