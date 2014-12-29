<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Add a TA</title>
</head>
<body>
<?php
include 'connectdb.php';
include 'uploadfile.php';
include 'AddTa.php';
?>
<?php
$firstname = $_POST["fname"];
$lastname = $_POST["lname"];
$sno = $_POST["SNO"];
$wid = $_POST["WID"];
$dtype = $_POST["dtype"];
$pid = $_POST["PID"];

$query = 'insert into TEACHINGASSISTANT values("' . $firstname . '","' . $lastname . '","' . $sno . '","' . $wid . '","' . $dtype . '","' . $TApic . '","' . $pid . '")';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
echo "Your TA was added";
?>
</body>
</html>

