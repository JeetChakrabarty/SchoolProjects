<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Delete Course</title>
</head>
<body>
<?php
include 'connectdb.php';
include 'DeleteCourse.php';
?>
<?php
$cid = $_POST["cid"];
$first = 'delete FROM TAAssignedTO where coursenumber = "' . $cid . '"';
$query = 'delete from COURSE where coursenumber = "' . $cid . '"';
if (!mysqli_query($connection, $first)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{
echo "TA has been Unassigned";
}

if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{
echo "Course  was deleted";
}
?>
</body>
</html>

