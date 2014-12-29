<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Assign Course</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$wid = $_POST["WID"];
$cname = $_POST["cname"];
$year = $_POST["year"];
$term = $_POST["term"];
$size = $_POST["size"];
$query = 'insert into TAAssignedTO values("' . $cname . '","' . $wid . '","' . $year . '","' . $term . '","' . $size . '")';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{

echo "Your TA was assigned";
}
?>
</body>
</html>

