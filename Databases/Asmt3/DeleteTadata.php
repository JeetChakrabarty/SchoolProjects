<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Delete TA</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$wid = $_POST["WID"];
$query = 'delete from TEACHINGASSISTANT WHERE userid = "' . $wid . '"';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{
echo "Your TA was deleted";
}
?>
</body>
</html>

